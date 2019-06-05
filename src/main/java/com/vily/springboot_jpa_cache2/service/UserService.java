package com.vily.springboot_jpa_cache2.service;

import com.vily.springboot_jpa_cache2.bean.User;
import com.vily.springboot_jpa_cache2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-06-03
 *  
 **/
@CacheConfig(cacheNames = "user")   // 抽取缓存的公共配置
@Service
public class UserService {


    @Autowired
    private UserRepository mUserRepository;

    @Cacheable(value = "user",key = "#id")
    public User getUser(long id) {
        System.out.println("------------:"+id);
        User userById = mUserRepository.findUserById(id);

        return userById;

    }

    /**
     *   CachePut ： 即调用方法，又更新缓存数据，同步更新缓存
     *   先去查询员工，查询的结果放在缓存中
     *     key  : 默认是传入的对象 User
     *     值 ： 返回的User 对象
     *
     *     user.id:  是返回前的id
     *     result.id : 是返回后的id
     *
     *     调用updateUser（） 接口后，去调用getUser（）接口，会发现缓存实时更改了
     */
    @CachePut(key = "#result.id")
    public User updateUser(User user) {
        System.out.println("-----更新："+user.getId());
        mUserRepository.save(user);
        return user;

    }

    /**
     *
     *   CacheEvict  ： 缓存清除
     *   key： 指定要清除的数据
     *   allEntries = true , 默认是false  ， 如果是true  清除缓存中所有的数据
     *   beforeInvocation=false : 缓存的清除是否在方法之前执行，默认是在方法之后执行
     */
    @Transactional
    @CacheEvict(key = "#id")
    public Integer deleteUser(long id) {

        Integer integer = mUserRepository.deleteUserById(id);

        return integer;
    }


    /**
     *
     *  缓存name的时候  ， 会把id 搜索也缓存进去, 有CachePut的时候 方法必执行
     */
    @Caching(
            cacheable = {
                    @Cacheable(key = "#name")
            },
            put = {
                    @CachePut(key="#result.id")
            }
    )
    public User getUserByName(String name){
        User userByName = mUserRepository.findUserByName(name);
        return userByName;
    }
}
