package com.zel.mytest.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 测试多个消费者,首先需要设置kafka集群的topic有多个partition,
 * 同一个消费者组中的不同消费者,不能消费同一个topic下的同一个partition
 * 最佳实践: 为每个topic准备一个消费者组, 消费者组中的消费者数量不要大于topic中partition的数量,否则多出来的消费者将处于空闲状态
 * 建议消费者组的consumer的数量与partition的数量一致！但即使这样,也有可能一个consumer消费多个partition导致有consumer空闲
 * 关于顺序性:只能保证同一个partition中的消息顺序消费,说白了,其实partition才是真正的队列
 */
@Component
public class Consumer {


    @KafkaListener(topics = {"mytopic2"})
    public void consumer1(String message){
        System.out.println("consumer1收到的消息是:"+message);
    }
    @KafkaListener(topics = {"mytopic2"})
    public void consumer2(String message){
        System.out.println("consumer2收到的消息是:"+message);
    }
    @KafkaListener(topics = {"mytopic2"})
    public void consumer3(String message){
        System.out.println("consumer3收到的消息是:"+message);
    }

}
