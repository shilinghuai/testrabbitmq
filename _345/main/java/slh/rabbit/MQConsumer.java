package slh.rabbit;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import slh.message.BaseListener;
import slh.message.Tests;

import javax.annotation.PostConstruct;

/**
 * created by fuyd on 2018/12/24
 */
@Component
public class MQConsumer {

    @Autowired
    private DirectExchange directExchange;

    @Autowired
    private MQProperties mqProperties;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Autowired
    private BaseListener quntumListener;

    @Autowired
    private Tests tests;

    @PostConstruct
    public void init() {
        registerQueuesAndListeners();
    }

    private void registerQueuesAndListeners() {
        System.out.print("slh-init");
        quntumQueuesAndListeners();
        rabbitAdmin.initialize();
    }

    private void quntumQueuesAndListeners() {
        // 队列
        Queue queue = new Queue(mqProperties.getQuntumInQueue(), true, false, false);
        // 路由关键字
        Binding binding = BindingBuilder.bind(queue).to(directExchange).with(mqProperties.getAddressKey());
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(queue);
        container.setExposeListenerChannel(true);
        // 最大并发消费
        container.setMaxConcurrentConsumers(1);
        // 并发消费
        container.setConcurrentConsumers(1);
        // 自动确认
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        System.out.print(quntumListener+"slh-init");
        container.setMessageListener(tests);

        // register to spring context
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        beanFactory.registerSingleton("QuntumInQueue", queue);
        beanFactory.registerSingleton("QuntumInQueueBinding", binding);
        beanFactory.registerSingleton("QuntumInSimpleMessageListenerContainer", container);
    }
}
