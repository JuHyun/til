package com.example.messagingrabbitmq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

//    public static final String topicExchangeName = "spring-boot-exchange";

    public static final String queueName1 = "spring-boot-01";
    public static final String queueName2 = "spring-boot-02";
    public static final String queueName3 = "spring-boot-03";
    public static final String queueName4 = "spring-boot-04";
    public static final String queueName5 = "spring-boot-05";
    public static final String queueName6 = "spring-boot-06";
    public static final String queueName7 = "spring-boot-07";
    public static final String queueName8 = "spring-boot-08";
    public static final String queueName9 = "spring-boot-09";
    public static final String queueName10 = "spring-boot-10";

    public static final String ROUTING_KEY = "foo.bar.baz";

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrentConsumers(4);
        factory.setAutoStartup(false);
        factory.setChannelTransacted(false);
        factory.setPrefetchCount(1000);
        configurer.configure(factory, connectionFactory);
        return factory;
    }

//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setAutoStartup(false);
//        container.setQueueNames(queueName);
//        container.setPrefetchCount(5);
//        return container;
//    }

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory("localhost", 5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        // Closing a connection returns it to the cache (if the cache size has not been reached).
        // Channels created on such connections are also cached.
        // To cache connections, set the cacheMode to CacheMode.CONNECTION.
//        factory.setChannelCacheSize(2);
//        factory.setCacheMode(CachingConnectionFactory.CacheMode.CONNECTION);
        factory.setPublisherReturns(false);
        factory.setConnectionTimeout(500);

        return factory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setReplyTimeout(500);
        rabbitTemplate.setChannelTransacted(false);
        return rabbitTemplate;
    }

    @Bean
    Queue queue1() {
        return new Queue(queueName1, false);
    }

    @Bean
    Queue queue2() {
        return new Queue(queueName2, false);
    }

    @Bean
    Queue queue3() {
        return new Queue(queueName3, false);
    }

    @Bean
    Queue queue4() {
        return new Queue(queueName4, false);
    }

    @Bean
    Queue queue5() {
        return new Queue(queueName5, false);
    }

    @Bean
    Queue queue6() {
        return new Queue(queueName6, false);
    }

    @Bean
    Queue queue7() {
        return new Queue(queueName7, false);
    }

    @Bean
    Queue queue8() {
        return new Queue(queueName8, false);
    }

    @Bean
    Queue queue9() {
        return new Queue(queueName9, false);
    }

    @Bean
    Queue queue10() {
        return new Queue(queueName10, false);
    }

//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange(topicExchangeName);
//    }
//
//    @Bean
//    Binding binding(Queue queue, TopicExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
//    }
}
