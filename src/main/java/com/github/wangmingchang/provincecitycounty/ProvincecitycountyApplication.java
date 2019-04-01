package com.github.wangmingchang.provincecitycounty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = "com.github.wangmingchang.provincecitycounty.dao")
@ComponentScan(basePackages = "com.github.wangmingchang.*")
@SpringBootApplication
public class ProvincecitycountyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvincecitycountyApplication.class, args);
    }
}
