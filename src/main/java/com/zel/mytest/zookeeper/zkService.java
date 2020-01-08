package com.zel.mytest.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class zkService {
    @Value("${connection}")
    private String connection;


    @RequestMapping(value = "/helloZk" , method = RequestMethod.GET)
    public String creteNode(@RequestParam String path){
        System.out.println("====================="+connection);
        ZkClient zkClient = new ZkClient(connection);
        try {
            zkClient.createPersistent("/"+path); //没返回结果 所以用try catch 方式解决哦
            return "ok";
        } catch (Exception e) {
            return "fail";
        }
    }


}