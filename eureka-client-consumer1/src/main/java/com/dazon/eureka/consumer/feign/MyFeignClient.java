package com.dazon.eureka.consumer.feign;

import com.dazon.eureka.consumer.feign.config.FeignCfg;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Dazon Wu
 * @Description
 * @date 2020/4/22 10:51
 */
@FeignClient(name = "eureka-client-service-provider",configuration = FeignCfg.class)
//@RequestMapping("/eureka/client/provider")目测写法与path作用一致
public interface MyFeignClient{
    //@PostMapping(value = "hello/{name}")
    @RequestLine("POST /eureka/client/provider/hello/{name}")
    String sayHello(@Param("name") String name);
}
