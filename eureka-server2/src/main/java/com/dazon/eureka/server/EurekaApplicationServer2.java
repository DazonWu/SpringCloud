package com.dazon.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Eureka Server 集群环境下，Eureka Server之间会进行注册表信息同步，
 * 这时被同步的注册表信息的Eureka Server将会被其他同步注册表信息的Eureka Server成为peer
 */



@SpringBootApplication
//会为项目自动配置必须的配置类，标识该服务为注册中心
@EnableEurekaServer
@ServletComponentScan
public class EurekaApplicationServer2{

    public static void main(String[] args){
        //new SpringApplicationBuilder(EurekaServerApplication.class).run()
        ConfigurableApplicationContext run = SpringApplication.run(EurekaApplicationServer2.class,args);
    }


}
