package com.github.yanming.demo.spring.cloud.eureka.provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/2/27 14:49
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication.class, args);
    }

    /**
    自动注入request
     **/
    @Autowired
    private HttpServletRequest request;
    @RequestMapping("/hello")
    public String hello(String name){
        String hostName=request.getServerName();
        //获取服务器端口
        int  hostPort= request.getServerPort();
        String hello= "eureka-provider("+hostName+":"+hostPort+") say: hello "+name;
        return hello;
    }

}
