package com.vily.springboot_jpa_cache2.controller;

import com.vily.springboot_jpa_cache2.bean.User;
import com.vily.springboot_jpa_cache2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    /**
     *   cache:condition="#id>1":  id>1 才缓存
     *   unless="#id==2" : 除了id=2之外缓存
     */

    @Autowired
    private UserService mUserService;

    @Cacheable(value = "sss",key = "#value")
    @GetMapping(value = "/test")
    public String test(@RequestParam("value")String value){

        System.out.println("------------:"+value);
        return value;
    }


    @GetMapping(value = "/getUser")
    public User getUser(@RequestParam("id")long id){

        return mUserService.getUser(id);
    }


    @GetMapping(value = "/updateUser")
    public User updateUser(User user ){

        return mUserService.updateUser(user);
    }

    @GetMapping(value = "/deleteUser")
    public void deleteUser(@RequestParam("id")long id){

        Integer integer = mUserService.deleteUser(id);
        System.out.println("-----删除："+id+"---:"+integer);
    }
}
