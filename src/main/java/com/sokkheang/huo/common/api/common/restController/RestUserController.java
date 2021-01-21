package com.sokkheang.huo.common.api.common.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sokkheang.huo.common.api.common.model.User_Client;
import com.sokkheang.huo.common.api.common.repository.UserRepository;
import com.sokkheang.huo.common.api.common.service.UserService;
import com.sokkheang.huo.common.constrant.ResultCode;
import com.sokkheang.huo.common.response.Response;
import com.sokkheang.huo.common.response.ResponseList;
import com.sokkheang.huo.common.upload.StorageService;
import com.sokkheang.huo.common.utils.Page;
import com.sokkheang.huo.common.utils.SystemDateTime;

@RestController
@RequestMapping("/user")
public class RestUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private StorageService storageService;

    public RestUserController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PreAuthorize("#oauth2.hasScope('foo') and #oauth2.hasScope('read')")
    @GetMapping("")
    public Response GetAllUserPage(Page paging) {
        try {
        	paging.setEnabled(true);
            List<User_Client> list = userService.findAllPage(paging);
            if (!list.isEmpty()) {
                return new ResponseList("Found !", list,paging,userService.CountUserAvailable(paging),ResultCode.retrieved.getDescription());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseList("Not Found !",null,null,null,ResultCode.retrieve_not_fount.getDescription());
    }

    @PreAuthorize("#oauth2.hasScope('foo') and #oauth2.hasScope('read')")
    @GetMapping("/{id}")
    public Response GetUserById(@PathVariable("id") Integer id) {
        User_Client user = userService.findById(id, true);
        try {
            if (user != null) {
                return new ResponseList("Not Found !",user,null,null,ResultCode.retrieve_not_fount.getDescription());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseList("Found !",null,null,null,ResultCode.retrieved.getDescription());
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        Resource resource = storageService.loadAsResource(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PreAuthorize("#oauth2.hasScope('foo') and #oauth2.hasScope('write')")
    @PostMapping("/save")
    public Response RegisterUser(@Valid @RequestBody User_Client user) {
        try {
            SystemDateTime systemDateTime = new SystemDateTime();
            User_Client userObj = userService.findById(user.getId(), true);
            User_Client clients = userRepository.findByName(user.getUsername());
        	if(clients == null ) {
        		if (userObj == null) {
        			int count = userRepository.CountUser(true);
        			int id = ++count;
        			user.setId(id);
        			user.setRegisterdate(systemDateTime.getCurrentDateTime_YYYY_MM_DD());
        			user.setEnabled(true);
        			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        			boolean insert = userService.registerUser(user);
        			if (insert) {
        				User_Client respone = userService.findById(user.getId(), true);
        				return new ResponseList("Insert successfully !",respone,null,null,ResultCode.inserted.getDescription());
        			}
        		}
        	}
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseList("Insert failed !",null,null,null,ResultCode.insert_failed.getDescription());
    }

    @PreAuthorize("#oauth2.hasScope('foo') and #oauth2.hasScope('write')")
    @PutMapping("/update")
    public Response UpdateUser(@RequestBody User_Client user) {
        User_Client userObj = userService.findById(user.getId(), true);
        User_Client clients = userRepository.findByName(user.getUsername());
        try {
        	if(clients.getUsername().equalsIgnoreCase(user.getUsername())) {
        		if (userObj != null) {
        			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        			boolean update = userService.updateUser(user);
        			if (update) {
        				return new ResponseList("Update successfully !",userObj,null,null,ResultCode.updated.getDescription());
        			}
        		}        		
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseList("Update failed !",null,null,null,ResultCode.update_failed.getDescription());
    }

    @PreAuthorize("#oauth2.hasScope('foo') and #oauth2.hasScope('write')")
    @PutMapping("/remove")
    public Response removeUser(@RequestBody User_Client user) {
        User_Client findId = userService.findById(user.getId(), true);
        try {
            if (findId != null) {
                boolean delete = userService.updatestatuscode(user.getId(), false);
                if (delete) {
                    return new ResponseList("Removed successfully !",findId,null,null,ResultCode.removed.getDescription());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseList("Remove failed !",null,null,null,ResultCode.remove_failed.getDescription());
    }

    @PreAuthorize("#oauth2.hasScope('foo') and #oauth2.hasScope('write')")
    @GetMapping("/count")
    public Response getCountUser(Page page){
        int userCount = userService.CountUserAvailable(page);
        if(userCount != 0){
            return new ResponseList("Counted successfully !",userCount,null,userService.CountUserAvailable(page),ResultCode.retrieved.getDescription());
        }
        else {
            return new ResponseList("Count failed !",null,null,null,ResultCode.retrieve_not_fount.getDescription());
        }
    }
}