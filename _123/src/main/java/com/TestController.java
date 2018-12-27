package com;


import com.rabbit.MQMessage;
import com.rabbit.MQProducer;
import com.rabbitmq.client.AMQP;
import org.springframework.beans.factory.annotation.Autowired;
import com.rabbit.MQProducer;
import com.rabbitmq.client.AMQP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by fuyd on 2018/12/6
 */
@RequestMapping(value = "/test11")
@RestController
public class TestController {

    @Autowired
    private MQProducer mqProducer;


    @RequestMapping(value = "/mqSend",method = RequestMethod.GET)
    public void mqSend() {
        // TODO rabbitmq
        String s = "test";
        System.out.print("hello,slh");
        MQMessage mqMessage = new MQMessage("quntum.exchange1", "quntum.router.key1", "hello,slh");
        mqProducer.sendMessage(mqMessage);
    }
}
