package com.dazon.eureka.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dazon Wu
 * @Description
 * @date 2020/3/10 13:04
 */
@Configuration
public class Config{

    @Bean
    @LoadBalanced//注入一个可以进行负载均衡的RestTemplate,才可以根据applicationName解析出host
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
