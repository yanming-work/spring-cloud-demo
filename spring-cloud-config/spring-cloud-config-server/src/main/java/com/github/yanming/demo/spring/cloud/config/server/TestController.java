package com.github.yanming.demo.spring.cloud.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @auther : YanMing(yanming_work@163.com)
 * @date: 2019/2/26 14:29
 */

/**
 *  开启更新功能
 **/
@RefreshScope
@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping("/home")
    public String home() {
        return "Hello World!spring cloud config Service !";
    }


}
