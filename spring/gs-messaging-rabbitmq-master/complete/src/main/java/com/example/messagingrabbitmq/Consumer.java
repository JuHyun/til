package com.example.messagingrabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.ListenerContainerIdleEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @RabbitListener(id = "consumer",
            queues = {RabbitConfiguration.queueName1, RabbitConfiguration.queueName2, RabbitConfiguration.queueName3,
                    RabbitConfiguration.queueName4, RabbitConfiguration.queueName5, RabbitConfiguration.queueName6,
                    RabbitConfiguration.queueName7, RabbitConfiguration.queueName8, RabbitConfiguration.queueName9,
                    RabbitConfiguration.queueName10},
            concurrency = "4")
    public void receiveMessage(String message) {
        System.out.println(String.format("consume message {%s} on {%s} ", message, Thread.currentThread().getName()));

//        try {
//            Thread.sleep(ThreadLocalRandom.current().nextLong(1000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @EventListener(condition = "event.listenerId == 'consumer'")
    public void onApplicationEvent(ListenerContainerIdleEvent event) {
        for (String queueName : event.getQueueNames()) {
            System.out.println(String.format("queue name: {%s}", queueName));
        }
    }
}
