package com.github.yanming.demo.spring.cloud.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/2/28 11:45
 */
@Service
public class HelloService {


    @Autowired
    @Qualifier(value = "remoteRestTemplate")
    private RestTemplate remoteRestTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String helloService(String name) {

        //return this.restTemplate.getForObject("http://localhost:8060/hello?name="+name,String.class);
        return this.remoteRestTemplate.getForObject("http://eureka-provider/hello?name=" + name, String.class);
    }


    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }


}
