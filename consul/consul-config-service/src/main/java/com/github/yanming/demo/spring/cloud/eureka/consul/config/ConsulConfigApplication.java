package com.github.yanming.demo.spring.cloud.eureka.consul.config;

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
public class ConsulConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConfigApplication.class, args);
    }


    /**

     网页上访问consul的KV存储的管理界面，即http://localhost:8500/ui/dc1/kv，创建一条记录，

     key值为：config/consul-config-service:dev/data
     value值如下：

         config:
            name: Yan Ming
            age: 29
            email: yanming_work@163.com
            version: dev

     在浏览器上访问http://localhost:8633/test
     **/

}
