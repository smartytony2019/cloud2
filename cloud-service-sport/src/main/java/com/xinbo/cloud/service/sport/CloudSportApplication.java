package com.xinbo.cloud.service.sport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.xinbo.cloud")
@EnableSwagger2
@MapperScan(basePackages = "com.xinbo.cloud")
public class CloudSportApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudSportApplication.class, args);
    }

}
