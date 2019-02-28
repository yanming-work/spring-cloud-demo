package com.github.yanming.demo.spring.cloud.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @description :
 * @auther : YanMing(yanming_work@163.com)
 * @date : 2019/2/26 17:10
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonApplication {


    /**
     * 实例化ribbon使用的RestTemplate,使用@EnableEurekaClient声明为Eureka客户端， RestTemplate需要配合@LoadBalanced才能通过服务名spring.application.name解析到具体的服务上
     */
    @LoadBalanced
    @Bean(name="remoteRestTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }


}