package com.zel.mytest.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/helloKafka" , method = RequestMethod.GET)
    public String producer(@RequestParam String params){
        System.out.println("收到的参数为:"+params);
        for(int i=0;i<100;i++){
//            kafkaTemplate.send("mytopic2",params+i);
            int key = i/10;
            kafkaTemplate.send("mytopic2",null,key+"",i+"");
        }
//        kafkaTemplate.send("mytopic2",params);
        return "成功";
    }

}
