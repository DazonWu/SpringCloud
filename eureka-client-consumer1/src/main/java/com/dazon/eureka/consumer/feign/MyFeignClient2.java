package com.dazon.eureka.consumer.feign;

import com.dazon.eureka.consumer.feign.config.Provider1Interceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Dazon Wu
 * @Description
 * @date 2020/4/22 10:51
 */
@FeignClient(name = "eureka-client-service-provider2")
//@RequestMapping("/eureka/client/provider")目测写法与path作用一致
public interface MyFeignClient2{
    @PostMapping(value = "/eureka/client/provider/hello/{name}")
    String sayHello2(@PathVariable("name") String name,@RequestBody Provider1Interceptor Provider1Interceptor);
}
