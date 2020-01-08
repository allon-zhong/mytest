package com.zel.mytest;

import org.I0Itec.zkclient.ZkClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MytestApplicationTests {
    @Value("{connection}")
    private String connection;


    @Test
    void kafkaProducer() {
    }
    @Test
    void zkService() {
        ZkClient zkClient = new ZkClient(connection);
        try {
            zkClient.createPersistent("/zel"); //没返回结果 所以用try catch 方式解决哦
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println("fail");
        }
    }
    @Test
    void contextLoads() {
    }

}
