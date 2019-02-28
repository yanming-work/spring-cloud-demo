package com.github.yanming.demo.spring.cloud.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description :
 * @auther :  YanMing(yanming_work@163.com)
 * @date : 2019/2/26 17:15
 */
@RestController
public class HelloController {


    @Autowired
    HelloService helloService;



    @RequestMapping("/hello")
    public String hello(){
        return helloService.helloService("Hystrix");

    }







}
