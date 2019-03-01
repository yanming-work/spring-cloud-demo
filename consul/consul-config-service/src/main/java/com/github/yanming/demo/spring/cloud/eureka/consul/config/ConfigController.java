package com.github.yanming.demo.spring.cloud.eureka.consul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/3/1 16:29
 */

@RestController
@RefreshScope
public class ConfigController {

    @Autowired
    private HttpServletRequest request; //自动注入request

    @Value("${config.name}")
    String name;
    @Value("${config.age}")
    String age;
    @Value("${config.version}")
    String version;

    /**
     * 返回配置文件中的值
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String returnValue(){
        String sb = "name is " + name + "," + "age is " +age+ "," + "version is " +version;
        return sb;
    }


    /**
     * 返回配置文件中的值
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(String name){
        //获取服务器端口
        int port= request.getServerPort();
        String sb = "name is " + name + "("+port+")," + "age is " +age+ "," + "version is " +version;
        return sb;
    }
}
