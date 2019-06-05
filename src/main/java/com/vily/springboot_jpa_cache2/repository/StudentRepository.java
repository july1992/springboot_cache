package com.vily.springboot_jpa_cache2.repository;

import com.vily.springboot_jpa_cache2.bean.Student;
import com.vily.springboot_jpa_cache2.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-06-03
 *  
 **/

public interface StudentRepository extends JpaRepository<Student,String> {

    Student findUserById(Long id);

    Student findUserByName(String name);

    Integer deleteUserById(Long id);


}
