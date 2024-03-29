package com.vily.springboot_jpa_cache2.repository;

import com.vily.springboot_jpa_cache2.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-06-03
 *  
 **/

public interface UserRepository extends JpaRepository<User,String> {

    User findUserById(Long id);

    User findUserByName(String name);

    Integer deleteUserById(Long id);


}
