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
 * @Description:
 * @Auther: YanMing(yanming_work @ 163.com)
 * @Date: 2019/2/26 14:29
 */

/**
 *  开启更新功能
 **/
@RefreshScope
@RestController
@RequestMapping("/")
public class TestController {
    /**
     *  注入发现客户端
     **/
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/home")
    public String home() {
        return "Hello World!spring cloud config Service !";
    }


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        //获取服务实例，作用为之后console显示效果
        List<ServiceInstance> serviceInstanceList = client.getInstances( "config-server");
        StringBuffer sb = new StringBuffer("");
        for (ServiceInstance serviceInstance: serviceInstanceList
        ) {
            sb.append(" host:" + serviceInstance.getHost() + "; service_id:" + serviceInstance.getServiceId());
        }

        return sb.toString();
    }

}
