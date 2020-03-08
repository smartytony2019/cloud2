package com.xinbo.cloud.common.mapper2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages="com.xinbo.cloud")
@MapperScan(basePackages = "com.xinbo.cloud")
@EnableSwagger2
public class Mapper2Application {
    public static void main(String[] args) {

        SpringApplication.run(Mapper2Application.class, args);
    }
}
