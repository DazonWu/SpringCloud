package com.dazon.eureka.server.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author Dazon Wu
 * @Description
 * @date 2020/4/2 20:37

 */
@WebFilter(urlPatterns="/*")
@Component
public class TestFilter implements Filter{

    @Override public void init(FilterConfig filterConfig) throws ServletException{
        ServletContext servletContext = filterConfig.getServletContext();
        Enumeration<String> servletNames = servletContext.getServletNames();
        while (servletNames.hasMoreElements()){
            System.out.println(servletNames.nextElement());
        }
        //servletContext.servlet

    }

    @Override public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException{
        System.out.println(1111);
        chain.doFilter(request,response);
    }

    @Override public void destroy(){

    }
}
