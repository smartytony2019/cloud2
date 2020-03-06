package com.xinbo.cloud.common.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.xinbo.cloud.common.mapper"})
@SpringBootApplication
public class MapperApplication {
    public static void main(String[] args) {

        SpringApplication.run(MapperApplication.class, args);

    }
}
