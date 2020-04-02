package com.dazon.eureka.server.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Dazon Wu
 * @Description
 * @date 2020/4/2 20:37
 * @email dacheng.wu@baozun.com
 */
@Component
public class TestFilter implements Filter{

    @Override public void init(FilterConfig filterConfig) throws ServletException{

    }

    @Override public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException{
        System.out.println(1111);
        chain.doFilter(request,response);
    }

    @Override public void destroy(){

    }
}
