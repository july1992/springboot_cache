package com.vily.springboot_jpa_cache2;

import com.vily.springboot_jpa_cache2.bean.User;
import com.vily.springboot_jpa_cache2.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaCache2ApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate userRedisTemplate;

    @Autowired
    UserRepository mUserRepository;

    @Test
    public void contextLoads() {


    }

    @Test
    public void test01(){

        System.out.println("------------------------------------------------------");
        stringRedisTemplate.opsForValue().append("sdad","1111");
    }

    /**
     *    redis 存入对象
     */
    @Test
    public void testUser(){

        User userById = mUserRepository.findUserById((long) 3);
//        redisTemplate.opsForValue().set("user",userById);
        userRedisTemplate.opsForValue().set("user01",userById);
    }

}
