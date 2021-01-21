package com.sokkheang.huo.common.api.common.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sokkheang.huo.common.api.common.model.Role;
import com.sokkheang.huo.common.utils.Paging;

@Mapper 
public interface RoleRepository {

	public List<Role> findAll(Paging paging);
	
	public Role findById(Integer id);
	
	public boolean saveRole(Role role);
	
	public boolean updateRole(Role role);
	
	public Integer countRoleAvailable();

}
