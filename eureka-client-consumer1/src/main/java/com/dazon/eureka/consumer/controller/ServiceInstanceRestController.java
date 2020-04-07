package com.dazon.eureka.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dazon Wu
 * @Description
 * @date 2020/3/6 15:34
 */
@RestController
@Slf4j
public class ServiceInstanceRestController{

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public void index(){
        List<String> services = client.getServices();
        for (String serviceName:services){
            List<ServiceInstance> instances = client.getInstances(serviceName);
            System.out.println(111);
        }
    }
}
