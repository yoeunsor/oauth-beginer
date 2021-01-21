package com.sokkheang.huo.common.config.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sokkheang.huo.common.api.common.model.User_Client;
import com.sokkheang.huo.common.api.common.repository.UserRepository;

public class JdbcUserDetails implements UserDetailsService{

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User_Client user_Client = repository.findByName(username);


        if(user_Client==null){

            throw new UsernameNotFoundException("User "+username+" can not be found");
        }

        User user = new User(user_Client.getUsername(),user_Client.getPassword(),user_Client.isEnabled(),true,true,true,user_Client.getRoles());

        return  user;


    }
}
