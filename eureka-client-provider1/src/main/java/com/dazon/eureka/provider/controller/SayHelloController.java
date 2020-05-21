package com.dazon.eureka.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dazon Wu
 * @Description
 * @date 2020/3/10 11:23
 */
@RestController
@RequestMapping("/eureka/client/provider")
@Slf4j
public class SayHelloController{

    @RequestMapping("hello/{name}")
    public String sayHello(@RequestHeader(value = "header",required = false) Object header, @PathVariable String name){
        log.info("header:[{}],provider:[{}]",header,"11");
        return "Hello,".concat(name).concat("!");
    }
}
