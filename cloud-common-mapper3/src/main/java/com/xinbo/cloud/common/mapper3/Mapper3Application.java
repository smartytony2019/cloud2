package com.xinbo.cloud.common.mapper3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.xinbo.cloud.common.mapper3.mapper"})
public class Mapper3Application {

    public static void main(String[] args) {
        SpringApplication.run(Mapper3Application.class, args);
    }

}
