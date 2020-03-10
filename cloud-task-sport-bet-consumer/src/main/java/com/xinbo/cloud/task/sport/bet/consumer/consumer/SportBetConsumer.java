package com.xinbo.cloud.task.sport.bet.consumer.consumer;


import com.xinbo.cloud.common.dto.RocketMessage;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(nameServer = "${rocketmq.name-server}", topic = "${rocketmq.mytopic}", consumerGroup = "${rocketmq.producer.group}")
public class SportBetConsumer implements RocketMQListener<RocketMessage<String>> {
    @Override
    public void onMessage(RocketMessage<String> message) {
        System.out.println("#################  --> "+message.getMessageBody());
    }
}