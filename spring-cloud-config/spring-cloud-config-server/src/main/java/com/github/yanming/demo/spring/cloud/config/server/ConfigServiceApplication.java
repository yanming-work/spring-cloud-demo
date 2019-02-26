package com.github.yanming.demo.spring.cloud.config.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
@RestController
public class ConfigServiceApplication {


        public static void main(String[] args) {
        SpringApplication.run(ConfigServiceApplication.class, args);
    }
}