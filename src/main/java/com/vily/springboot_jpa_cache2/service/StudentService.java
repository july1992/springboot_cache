package com.vily.springboot_jpa_cache2.service;

import com.vily.springboot_jpa_cache2.bean.Student;
import com.vily.springboot_jpa_cache2.bean.User;
import com.vily.springboot_jpa_cache2.repository.StudentRepository;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-06-05
 *  
 **/

@CacheConfig(cacheNames = "student")
@Service
public class StudentService {

    @Autowired
    StudentRepository mStudentRepository;

    @Cacheable(key = "#id")
    public Student getStudentById(long id) {
        Student userById = mStudentRepository.findUserById(id);
        return userById;
    }


    @CachePut(key = "#result.id")
    public Student updateStudent(Student student) {
        Student save = mStudentRepository.save(student);
        return save;

    }

    @CacheEvict(key = "#id")
    public Integer deleteStudent(long id) {
        Integer integer = mStudentRepository.deleteUserById(id);
        return integer;

    }


    @Caching(
            cacheable = {
                    @Cacheable(key = "#name")
            },
            put = {
                    @CachePut(key = "#result.id")
            }
    )
    public Student getStudentByName(String name) {

        Student userByName = mStudentRepository.findUserByName(name);
        return userByName;

    }
}
