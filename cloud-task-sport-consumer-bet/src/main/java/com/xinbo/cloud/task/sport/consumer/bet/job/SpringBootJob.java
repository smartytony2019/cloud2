package com.xinbo.cloud.task.sport.consumer.bet.job;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SpringBootJob {


    /**
     * 按照标准时间来算，每隔 10s 执行一次
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void job1() {

        System.out.println(LocalDateTime.now());

    }

}
