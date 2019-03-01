package com.github.yanming.demo.spring.cloud.config.server.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/3/1 14:16
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMysqlApplication.class, args);
    }
}


