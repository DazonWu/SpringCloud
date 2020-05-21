package com.dazon.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication()
@EnableFeignClients
public class EurekaClientApplicationConsumer1{

    public static void main(String[] args){


        ConfigurableApplicationContext run = SpringApplication.run(EurekaClientApplicationConsumer1.class,args);
    }

}
