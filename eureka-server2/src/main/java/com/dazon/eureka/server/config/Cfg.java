package com.dazon.eureka.server.config;

import com.netflix.eureka.StatusFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author Dazon Wu
 * @Description
 * @date 2020/4/2 19:55
 */
@Configuration
public class Cfg{

    /**
     * Eureka状态过滤器，在Server的web容器加载完成，但是自身初始化动作未完成时对请求拦截
     * @return
     */
    @Bean("statusFilter")
    public StatusFilter statusFilter(){

        return new StatusFilter();
    }

    @Bean
    public FilterRegistrationBean registerAuthFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(statusFilter());
        registration.addUrlPatterns("/*");
        registration.setName("statusFilter");
        registration.setOrder(1);  //值越小，Filter越靠前。
        return registration;
    }

    /*@Bean("testFilter")
    public TestFilter getTestFilter(){
        return new TestFilter();
    }*/
}
