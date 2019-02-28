package com.github.yanming.demo.spring.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/2/27 15:40
 */
@FeignClient("eureka-provider")
public interface HelloClient {
    /**
        参数要加上 @RequestParam 否则无效
     **/
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String hello(@RequestParam(value = "name")String name);
}
