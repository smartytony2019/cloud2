package com.xinbo.cloud.common.mapper2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.xinbo.cloud.common.mapper2.mapper"})
public class Mapper2Application {

    public static void main(String[] args) {
        SpringApplication.run(Mapper2Application.class, args);
    }

}
