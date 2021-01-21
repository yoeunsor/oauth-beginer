package com.sokkheang.huo.common.api.common.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sokkheang.huo.common.api.common.model.Image;
import com.sokkheang.huo.common.api.common.repository.ImageRepository;
import com.sokkheang.huo.common.api.common.service.ImageService;
import com.sokkheang.huo.common.utils.Paging;

import java.util.List;

@Service
public class ImageServiceImp implements ImageService {

    @Autowired
    private ImageRepository imageRepo;

    @Override
    public List<Image> findAll(Paging paging) {
        List<Image> list = null;
            list = imageRepo.findAll(paging);
            if(list.isEmpty()){
                System.out.println("Data not found !");
            }
        return list;
    }

    @Override
    public Image findById(Integer id) {
        Image image = imageRepo.findById(id);
        if(image == null){
            System.out.println("Data not found !");
        }
        return image;
    }

    @Override
    public boolean insertImage(Image image) {
        boolean save = imageRepo.insertImage(image);
        if(!save){
            System.out.println("Save failed !");
        }
        return save;
    }

    @Override
    public boolean updateImage(Image image) {
        boolean update = imageRepo.updateImage(image);
        if(!update){
            System.out.println("Update failed !");
        }
        return update;
    }

    @Override
    public boolean updateImageStatusCode(String statuscode) {
        boolean updateStatusCode = imageRepo.updateImageStatusCode(statuscode);
        if(!updateStatusCode){
            System.out.println("Update StatusCode failed !");
        }
        return updateStatusCode;
    }
}
