package com.example.sdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.example.sdd.dao")
@EnableCaching
public class SddApplication {

    public static void main(String[] args) {
        SpringApplication.run(SddApplication.class, args);
    }

}
