package com.github.yanming.demo.spring.cloud.eureka.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * EurekaServer
 * @author : YanMing(yanming_work@163.com)
 * @date : 2019/2/26 13:58
 * @param :
 * @return :
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}