package com.xinbo.cloud.service.sport.bet.provider.controller;


import com.xinbo.cloud.common.dto.ActionResult;
import com.xinbo.cloud.common.Util.ResultFactory;
import com.xinbo.cloud.common.dto.RocketMessage;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("sportbet")
public class BetController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;


    @Value("${rocketmq.mytopic}")
    private String sportBetTopic;


    @GetMapping("submit")
    public ActionResult submit() {
        RocketMessage message = RocketMessage.<String>builder().messageBody("hello rocketmq").build();
        SendResult sendResult = rocketMQTemplate.syncSend(sportBetTopic, MessageBuilder.withPayload(message).build());
        return ResultFactory.success(sendResult);
    }


}
