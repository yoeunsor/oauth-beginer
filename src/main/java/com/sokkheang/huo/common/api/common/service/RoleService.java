package com.sokkheang.huo.common.api.common.service;

import java.util.List;

import com.sokkheang.huo.common.api.common.model.Role;
import com.sokkheang.huo.common.utils.Paging;

public interface RoleService {

	public List<Role> findAll(Paging paging); 
	
	public Role findById(Integer id);
	
	public boolean saveRole(Role role);
	
	public boolean updateRole(Role role);
	
	public Integer countRoleAvailable();

}
