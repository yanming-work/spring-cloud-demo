package com.github.yanming.demo.spring.cloud.eureka.consul.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/3/1 15:32
 */
@FeignClient(value = "consul-provider")
public interface ConsulClientFeign {

    @GetMapping(value = "/hello")
    String sayHello(@RequestParam(value = "name") String name);
}

