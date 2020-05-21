package com.dazon.eureka.consumer.feign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Dazon Wu
 * @Description
 * @date 2020/4/26 15:52
 * 2020/4/26
 */
public class Provider1Interceptor implements RequestInterceptor{

    @Override public void apply(RequestTemplate template){
        template.header("header","wu","da","cheng");
    }
}
