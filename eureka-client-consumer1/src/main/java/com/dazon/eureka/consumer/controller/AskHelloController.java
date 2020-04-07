package com.dazon.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dazon Wu
 * @Description
 * @date 2020/3/10 11:23
 */
@RestController
@RequestMapping("/eureka/client/consumer")

public class AskHelloController{
    @Value("${spring.application.name}")
    private String name;
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/ask")
    public String sayHello(){
        //从eureka-client-service服务提供者中请求sayHello服务
        for (int i = 0; i < 100; i++){
            System.out.println(restTemplate.getForEntity("http://eureka-client-service-provider/eureka/client/provider/hello/{name}",String.class,name).getBody());
        }
        return "";
    }
}
