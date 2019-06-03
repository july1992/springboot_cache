package com.vily.springboot_jpa_cache2.service;

import com.vily.springboot_jpa_cache2.bean.User;
import com.vily.springboot_jpa_cache2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-06-03
 *  
 **/

@Service
public class UserService {


    @Autowired
    private UserRepository mUserRepository;

    public User getUser(long id) {

        User userById = mUserRepository.findUserById(id);

        return userById;

    }
}
