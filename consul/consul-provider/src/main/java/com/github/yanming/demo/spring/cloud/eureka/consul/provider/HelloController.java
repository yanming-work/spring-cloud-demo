package com.github.yanming.demo.spring.cloud.eureka.consul.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/3/1 15:19
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    String port;
    @GetMapping("/hello")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }

}
