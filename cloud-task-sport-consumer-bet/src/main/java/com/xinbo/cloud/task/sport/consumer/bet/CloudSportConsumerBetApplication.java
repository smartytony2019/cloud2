package com.xinbo.cloud.task.sport.consumer.bet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CloudSportConsumerBetApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudSportConsumerBetApplication.class, args);

    }
}
