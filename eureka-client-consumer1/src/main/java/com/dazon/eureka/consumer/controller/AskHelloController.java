package com.dazon.eureka.consumer.controller;

import com.dazon.eureka.consumer.feign.MyFeignClient;
import com.dazon.eureka.consumer.feign.MyFeignClient2;
import com.dazon.eureka.consumer.feign.config.Provider1Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private MyFeignClient myFeignClient;
    @Autowired
    private MyFeignClient2 myFeignClient2;
    @PostMapping("/ask")
    public String sayHello(){
        //从eureka-client-service服务提供者中请求sayHello服务
        for (int i = 0; i < 100; i++){
            System.out.println(restTemplate.getForEntity("http://eureka-client-service-provider/eureka/client/provider/hello/{name}",String.class,name).getBody());
        }
        return "aa";
    }

    @PostMapping("feignSayHello")
    public void feignSayHello(){
        for (int i = 0; i < 100; i++){
            String s = myFeignClient.sayHello(name);
            //System.out.println(s);
        }
        for (int i = 0; i < 100; i++){
            String s = myFeignClient2.sayHello2(name,new Provider1Interceptor());
            //System.out.println(s);
        }
    }
}
