package com.github.yanming.demo.spring.cloud.eureka.clinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/2/27 13:09
 */
@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/client")
    public String client() {
        List<String> serviceList = discoveryClient.getServices();
        StringBuffer services = new StringBuffer("Services: " + serviceList);
        services.append("\r\n</br>");
        services.append("Services 详细信息：");
        services.append("\r\n</br>");
        if (serviceList != null && serviceList.size() > 0){
            for (String serviceId : serviceList
            ) {
                List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances(serviceId);
                if (serviceInstanceList != null && serviceInstanceList.size() > 0) {
                    services.append("ServiceId:"+serviceId+"");
                    services.append("\r\n</br>");
                    for (ServiceInstance instance:serviceInstanceList
                         ) {
                        services.append("&nbsp;&nbsp;&nbsp;&nbsp;         host:" + instance.getHost() +",port:" + instance.getPort());
                        services.append("\r\n</br>");
                    }
                }
            }

        }

        return services.toString();
    }


}
