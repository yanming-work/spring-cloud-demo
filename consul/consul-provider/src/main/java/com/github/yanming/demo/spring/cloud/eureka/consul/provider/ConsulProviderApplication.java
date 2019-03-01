package com.github.yanming.demo.spring.cloud.eureka.consul.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/3/1 15:18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulProviderApplication.class, args);
    }

}
