package com.sokkheang.huo.common.api.common.restController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sokkheang.huo.common.api.common.model.Image;
import com.sokkheang.huo.common.api.common.repository.ImageRepository;
import com.sokkheang.huo.common.api.common.service.ImageService;
import com.sokkheang.huo.common.constrant.ResultCode;
import com.sokkheang.huo.common.constrant.StatusCode;
import com.sokkheang.huo.common.response.Response;
import com.sokkheang.huo.common.response.ResponseList;
import com.sokkheang.huo.common.upload.StorageService;
import com.sokkheang.huo.common.utils.Paging;
import com.sokkheang.huo.common.utils.SystemDateTime;

@RestController
@RequestMapping("/image")
public class ImageRestController {

    private StorageService storageService;

    public ImageRestController(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    private ImageService service;
    
    @Autowired
    private ImageRepository imgRepo;

    @GetMapping("")
    public Response getAllImage(Paging paging){
        List<Image> list = null;
        try{
            list = service.findAll(paging);
            if(list.isEmpty()){
                return new ResponseList(ResultCode.retrieve_not_fount.getDescription(),null,null,null,HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Integer imageCount = list.size();
        paging.setTotalCount(imageCount);
        return new ResponseList(ResultCode.retrieved.getDescription(),list,paging,null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Integer id){
        Image image = service.findById(id);
        if(image == null){
            return new ResponseList(ResultCode.retrieve_not_fount.getDescription(),null,null,null,HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseList(ResultCode.retrieved.getDescription(),image,null,null,HttpStatus.OK);
        }
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        Resource resource = storageService.loadAsResource(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/upload-file")
    public Response uploadFile(@RequestParam("file") MultipartFile file){

        Image image = new Image();
        SystemDateTime systemDateTime = new SystemDateTime();

        String name = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(name)
                .toUriString();

        int count = imgRepo.countImage(StatusCode.Active.getValue());
        int id = ++count;

        image.setId(id);
        image.setName(name);
        image.setSize(file.getSize());
        image.setType(file.getContentType());
        image.setUri(uri);
        image.setCreateby("1");
        image.setCreatedatetime(systemDateTime.getCurrentDateTime_YYYY_MM_DD());
        image.setLastchangeby("1");
        image.setLastchangedatetime(systemDateTime.getCurrentDateTime_YYYY_MM_DD());
        image.setStatuscode(StatusCode.Active.getValue());
        boolean save = service.insertImage(image);
        if(save){
            return new ResponseList(ResultCode.inserted.getDescription(),image,null,null,HttpStatus.OK);
        }else {
            return new ResponseList(ResultCode.insert_failed.getDescription(),null,null,null,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/upload-multiple-files")
    public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.stream(files)
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }
}
