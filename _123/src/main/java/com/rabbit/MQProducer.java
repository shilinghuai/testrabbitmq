package com.rabbit;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * created by fuyd on 2018/12/24
 */
@Component
public class MQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(MQMessage mqMessage) {
        rabbitTemplate.convertAndSend(mqMessage.getExchange(), mqMessage.getRouterKey(), mqMessage.getData());
    }

}
