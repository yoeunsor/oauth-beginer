package com.sokkheang.huo.common.api.common.service;

import java.util.List;

import com.sokkheang.huo.common.api.common.model.User_Client;
import com.sokkheang.huo.common.utils.Page;

public interface UserService {

	public List<User_Client> findAllPage(Page paging);
	
	public User_Client findById(Integer id, boolean enabled);

	public int CountUserAvailable(Page page);

	public boolean registerUser(User_Client user); 
	
	public boolean updateUser(User_Client user);
	
	public boolean updatestatuscode(Integer id, boolean enabled);
}
