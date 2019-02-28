package com.github.yanming.demo.spring.cloud.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @description :
 * @auther : YanMing(yanming_work@163.com)
 * @date : 2019/2/26 17:15
 */
@Service
public class HelloService {


    @Autowired
    @Qualifier(value = "remoteRestTemplate")
    private RestTemplate remoteRestTemplate;


    public String helloService(String name){

        //return this.restTemplate.getForObject("http://localhost:8060/hello?name="+name,String.class);
        return this.remoteRestTemplate.getForObject("http://eureka-provider/hello?name="+name,String.class);
    }


}
