package com.xinbo.cloud.common.mapper2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages="com.xinbo.cloud")
@MapperScan(basePackages = "com.xinbo.cloud")
public class Mapper2Application {
    public static void main(String[] args) {
        SpringApplication.run(Mapper2Application.class, args);
    }

}
