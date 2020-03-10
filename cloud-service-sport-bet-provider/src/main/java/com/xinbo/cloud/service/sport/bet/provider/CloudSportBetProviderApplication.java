package com.xinbo.cloud.service.sport.bet.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.xinbo.cloud")
@EnableSwagger2
@MapperScan(basePackages = "com.xinbo.cloud")
public class CloudSportBetProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudSportBetProviderApplication.class, args);
    }

}
