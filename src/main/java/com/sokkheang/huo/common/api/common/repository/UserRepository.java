package com.sokkheang.huo.common.api.common.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sokkheang.huo.common.api.common.model.User_Client;
import com.sokkheang.huo.common.utils.Page;

@Mapper
public interface UserRepository {
	
	public List<User_Client> findAllPage(Page paging);
	
	public User_Client findByName(String username);
	
	public User_Client findById(@Param("id") Integer id, @Param("enabled") boolean enabled);

	public int CountUserAvailable(Page page);
	
	public int CountUser(boolean enabled);

	public boolean registerUser(User_Client user);
	
	public boolean updateUser(User_Client user);
	
	//Delete user just update enabled
	public boolean updateStatusCode(@Param("id") Integer id, @Param("enabled") boolean enabled);
	
	public boolean registerUserRole(@Param("uid") int userId, @Param("rid") int roleId);
	
	public boolean updateUserRole(@Param("uid") int userId, @Param("rid") int roleId);
	
	public boolean registerUserCountry(@Param("uid") int userid, @Param("cid") int imageid);
	
	public boolean updateUserCountry(@Param("uid") int userid, @Param("cid") int imageid);
	
	public boolean registerUserLangeuage(@Param("uid") int userid, @Param("lid") int imageid);
	
	public boolean updateUserLanguage(@Param("uid") int userid, @Param("lid") int imageid);
	
	public boolean registerUserImage(@Param("uid") int userid, @Param("imgid") int imageid);
	
	public boolean updateUserImage(@Param("uid") int userid, @Param("imgid") int imageid);

}
