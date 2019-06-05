package com.vily.springboot_jpa_cache2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@EnableConfigurationProperties
public class SpringbootJpaCache2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaCache2Application.class, args);
    }

}
