package com.github.yanming.demo.spring.cloud.eureka.consul.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/3/1 15:34
 */
@RestController
public class HelloController {

    @Autowired
    ConsulClientFeign consulClientFeign;


    @GetMapping("/hello")
    public String sayHello(@RequestParam( defaultValue = "consul",required = false) String name) {
        return consulClientFeign.sayHello(name);
    }
}


