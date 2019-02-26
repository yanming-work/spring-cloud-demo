package com.github.yanming.demo.spring.cloud.eureka.clinet;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * EurekaClient
 * @author : YanMing(yanming_work@163.com)
 * @date : 2019/2/26 13:58
 **/
@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaClientApplication {

    @RequestMapping("/")
    public String index(){
        return "hello eureka client";
    }
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}