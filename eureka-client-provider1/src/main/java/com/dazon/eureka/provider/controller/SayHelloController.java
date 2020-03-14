package com.dazon.eureka.provider.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dazon Wu
 * @Description
 * @date 2020/3/10 11:23
 * @email dacheng.wu@baozun.com
 */
@RestController
@RequestMapping("/eureka/client/provider")
public class SayHelloController{

    @RequestMapping("hello/{name}")
    public String sayHello(@PathVariable String name){
        System.out.println("provider 111111");
        return "Hello,".concat(name).concat("!");
    }
}
