package com.sokkheang.huo.common.api.common.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sokkheang.huo.common.api.common.model.Role;
import com.sokkheang.huo.common.api.common.service.RoleService;
import com.sokkheang.huo.common.constrant.ResultCode;
import com.sokkheang.huo.common.response.Response;
import com.sokkheang.huo.common.response.ResponseList;
import com.sokkheang.huo.common.utils.Paging;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RestRoleController { 

	@Autowired
	private RoleService roleService;
	
	@GetMapping("")
	public Response getRoleAll(Paging paging) {
		List<Role> list = roleService.findAll(paging);
		if(list.isEmpty()) {
			return new ResponseList(ResultCode.retrieve_not_fount.getDescription(),null,null,null,HttpStatus.OK);
		}
		else {
			Integer roleCount = list.size();
			paging.setTotalCount(roleCount);
			return new ResponseList(ResultCode.retrieved.getDescription(),list,paging,null,HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public Response getRoleId(@PathVariable("id") Integer id){
		Role role = roleService.findById(id);
		if(role == null){
			return new ResponseList(ResultCode.retrieve_not_fount.getDescription(),null,null,null,HttpStatus.OK);
		}else{
			return new ResponseList(ResultCode.retrieved.getDescription(),role,null,null,HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public Response saveRole(@RequestBody Role role){
		boolean save = roleService.saveRole(role);
		if(save){
			return new ResponseList(ResultCode.inserted.getDescription(),save,null,null,HttpStatus.OK);
		}else{
			return new ResponseList(ResultCode.insert_failed.getDescription(),null,null,null,HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping
	public Response updateRole(@RequestBody Role role){
		boolean update = roleService.updateRole(role);
		if (update){
			return new ResponseList(ResultCode.updated.getDescription(),update,null,null,HttpStatus.OK);
		}else {
			return new ResponseList(ResultCode.update_failed.getDescription(),null,null,null,HttpStatus.NOT_FOUND);
		}
	}
}
