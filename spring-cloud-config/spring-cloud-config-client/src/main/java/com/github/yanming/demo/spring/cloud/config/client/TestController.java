package com.github.yanming.demo.spring.cloud.config.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/** 当有请求/fresh节点的时候，会重新请求一次ConfigServer去拉取最新的配置文件
        * 请求/fresh需要有几点要求：1.加actuator的依赖 2.SpringCloud1.5以上需要设置 management.security.enabled=false
        * 这个Controller的作用是查看from这个key的值
        **/


/**
 * 测试类
 * @author : YanMing(yanming_work@163.com)
 * @date : 2019/2/26 14:33
 **/

/**
 * 开启更新功能
 **/
@RefreshScope
@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private HttpServletRequest request; //自动注入request

    @RequestMapping("/home")
    public String home() {
        return "Hello World!spring cloud config Client !";
    }
    @Value("${message}")
    String message;

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
        String sb = "message is "+message+"," +"name is " + name + "," + "age is " +age+ "," + "version is " +version;
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
        String sb = "message is "+message+"," +"name is " + name + "("+port+")," + "age is " +age+ "," + "version is " +version;
        return sb;
    }

}