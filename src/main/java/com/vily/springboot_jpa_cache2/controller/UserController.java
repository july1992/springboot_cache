package com.vily.springboot_jpa_cache2.controller;

import com.vily.springboot_jpa_cache2.bean.User;
import com.vily.springboot_jpa_cache2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-06-03
 *  
 **/

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService mUserService;

    @Cacheable(value = "sss",key = "#id")
    @GetMapping(value = "/test")
    public String test(@Param("value")String value){

        System.out.println("------------:"+value);
        return value;
    }

    @Cacheable(value = "user",key = "#id")
    @GetMapping(value = "/getUser")
    public User getUser(@RequestParam("value")long id){

        System.out.println("------------:"+id);
        return mUserService.getUser(id);
    }


}
