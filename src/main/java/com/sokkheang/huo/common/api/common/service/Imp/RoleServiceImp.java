package com.sokkheang.huo.common.api.common.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sokkheang.huo.common.api.common.model.Role;
import com.sokkheang.huo.common.api.common.repository.RoleRepository;
import com.sokkheang.huo.common.api.common.service.RoleService;
import com.sokkheang.huo.common.utils.Paging;

@Service
public class RoleServiceImp implements RoleService{

	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public List<Role> findAll(Paging paging) {
		Integer CountRole = roleRepo.countRoleAvailable();
		return roleRepo.findAll(paging);
	}

	@Override
	public Role findById(Integer id) {
		return roleRepo.findById(id);
	}

	@Override
	public boolean saveRole(Role role) {
		return roleRepo.saveRole(role);
	}

	@Override
	public boolean updateRole(Role role) {
		return roleRepo.updateRole(role);
	}
	
	@Override
	public Integer countRoleAvailable() {
		return roleRepo.countRoleAvailable();
	}

}
