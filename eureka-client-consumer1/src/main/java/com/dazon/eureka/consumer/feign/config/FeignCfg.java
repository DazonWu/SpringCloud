package com.dazon.eureka.consumer.feign.config;

import feign.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dazon Wu
 * @Description
 * @date 2020/4/24 14:39
 * 2020/4/24
 */

@Slf4j
public class FeignCfg{

    /**
     * 重试
     *
     * @return
     */
    @Bean
    public Retryer feignRetry() {
        return new Retryer.Default();
    }

    /**
     * 设置请求的连接和处理的超时时间
     *
     * @return
     */
    @Bean
    public Request.Options feignRequestOptions() {
        return new Request.Options(10000, 60000);
    }

    /**
     * 修改日志的级别，其余的级别看Logger.Level这个枚举类
     *
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 使用feign默认的契约，而不是使用spring mvc的契约
     * 注意： 此时ProductService01Feign类上的方法的写法发生了改变
     *
     * @return
     */
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }



    @Bean
    public RequestInterceptor requestInterceptor(){
        return template -> template.header("header","wu","da","cheng");
    }
}
