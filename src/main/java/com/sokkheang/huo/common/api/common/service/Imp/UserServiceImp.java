package com.sokkheang.huo.common.api.common.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sokkheang.huo.common.api.common.model.Country;
import com.sokkheang.huo.common.api.common.model.Image;
import com.sokkheang.huo.common.api.common.model.Language;
import com.sokkheang.huo.common.api.common.model.Role;
import com.sokkheang.huo.common.api.common.model.User_Client;
import com.sokkheang.huo.common.api.common.repository.UserRepository;
import com.sokkheang.huo.common.api.common.service.UserService;
import com.sokkheang.huo.common.constrant.ResultCode;
import com.sokkheang.huo.common.constrant.StatusCode;
import com.sokkheang.huo.common.utils.Page;

@Service
public class UserServiceImp implements UserService{ 

	@Autowired
	private UserRepository userRepo;

	@Override
    public List<User_Client> findAllPage(Page paging) {
        int totalCount = userRepo.CountUserAvailable(paging);
    	paging.setTotalCount(totalCount);
    	
    	List<User_Client> list = userRepo.findAllPage(paging);
        
    	if(list.isEmpty()){
            System.out.println(User_Client.class.getSimpleName()+" "+ResultCode.Not_Found.getDescription());
        }
        return list;
    }

    @Override
	public User_Client findById(Integer id, boolean enabled) {
		User_Client find = userRepo.findById(id, enabled);
		if(find == null) {
			System.out.println(User_Client.class.getSimpleName()+" "+ResultCode.Not_Found.getDescription());
		}
		return find;
	}

	@Override
	public int CountUserAvailable(Page page) {
		int data = userRepo.CountUserAvailable(page);
		if(data == 0){
			System.out.println("Data not found !");
		}
		return data;
	}

	@Override
	public boolean registerUser(User_Client user) {
		boolean save = userRepo.registerUser(user);
		if(save) {
			for(Role role : user.getRoles()) {
				userRepo.registerUserRole(user.getId(), role.getId());
			}
			for(Image image : user.getImages()) {
				userRepo.registerUserImage(user.getId(), image.getId());
			}
			for(Country country : user.getCountries()) {
				userRepo.registerUserCountry(user.getId(), country.getId());
			}
			for(Language language : user.getLanguages()) {
				userRepo.registerUserLangeuage(user.getId(), language.getId());
			}
			System.out.println(User_Client.class.getSimpleName()+" "+ResultCode.inserted.getDescription());
		}
		else {
			System.out.println(User_Client.class.getSimpleName()+" "+ResultCode.insert_failed.getDescription());
		}
		return true;
	}

	@Override
	public boolean updateUser(User_Client user) {
		boolean update = userRepo.updateUser(user);
		if(update) {
			for(Role role : user.getRoles()) {
				userRepo.updateUserRole(user.getId(), role.getId());
			}
			for(Image image : user.getImages()) {
				userRepo.updateUserImage(user.getId(), image.getId());
			}
			for(Country country : user.getCountries()) {
				userRepo.updateUserCountry(user.getId(), country.getId());
			}
			for(Language language : user.getLanguages()) {
				userRepo.updateUserLanguage(user.getId(), language.getId());
			}
			System.out.println(User_Client.class.getSimpleName()+" "+ResultCode.updated.getDescription());
		}
		else {
			System.out.println(User_Client.class.getSimpleName()+" "+ResultCode.update_failed.getDescription());
		}
		return true;
	}

	@Override
	public boolean updatestatuscode(Integer id, boolean enabled) {
		boolean remove = userRepo.updateStatusCode(id, enabled);
		if(!remove) {
			System.out.println(User_Client.class.getSimpleName()+" "+ResultCode.remove_failed.getDescription());
		}
		return remove;
	}

}
