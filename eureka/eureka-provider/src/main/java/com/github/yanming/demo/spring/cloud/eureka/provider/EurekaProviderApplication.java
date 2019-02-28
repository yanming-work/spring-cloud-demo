package com.github.yanming.demo.spring.cloud.eureka.provider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/2/27 14:49
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello(String name){
        return "eureka-provider hello "+name;
    }

}
