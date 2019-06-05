package com.vily.springboot_jpa_cache2.controller;

import com.vily.springboot_jpa_cache2.bean.Student;
import com.vily.springboot_jpa_cache2.bean.User;
import com.vily.springboot_jpa_cache2.service.StudentService;
import com.vily.springboot_jpa_cache2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/student")
public class StudentController {

    /**
     *   cache:condition="#id>1":  id>1 才缓存
     *   unless="#id==2" : 除了id=2之外缓存
     */

    @Autowired
    private StudentService mStudentService;

    @Cacheable(value = "sss",key = "#value")
    @GetMapping(value = "/test")
    public String test(@RequestParam("value")String value){

        System.out.println("------------:"+value);
        return value;
    }


    @GetMapping(value = "/getStudentById")
    public Student getStudentById(@RequestParam("id")long id){

        return mStudentService.getStudentById(id);
    }


    @GetMapping(value = "/updateStudent")
    public Student updateStudent(Student student ){

        return mStudentService.updateStudent(student);
    }

    @GetMapping(value = "/deleteStudent")
    public void deleteStudent(@RequestParam("id")long id){

        Integer integer = mStudentService.deleteStudent(id);
        System.out.println("-----删除："+id+"---:"+integer);
    }

    @GetMapping(value = "/getStudentByName")
    public Student getStudentByName(@RequestParam("name")String name){

        System.out.println("-----查询："+name);

        return mStudentService.getStudentByName(name);
    }
}
