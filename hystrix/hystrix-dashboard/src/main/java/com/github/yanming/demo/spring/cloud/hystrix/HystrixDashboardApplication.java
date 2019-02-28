package com.github.yanming.demo.spring.cloud.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 断路器监控(Hystrix Dashboard)
 *
 * @param :
 * @author : YanMing(yanming_work@163.com)
 * @date : 2019/2/28 13:27
 * @return :
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class HystrixDashboardApplication {
    /**
     * 访问地址 http://localhost:5566/actuator/hystrix.stream
     *
     * 访问地址http://localhost:5566/hystrix 可以看见界面
     *
     * 在上面界面的输入框中依次输入：http://localhost:5566/actuator/hystrix.stream   2000   miya  ；点确定。
     * 在另一个窗口输入： http://localhost:5566/hi?name=hystrix
     *
     * 重新刷新hystrix.stream网页，你会看到良好的图形化界面：
     *
     */
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }



    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam(value = "name", defaultValue = "HystrixDashboard") String name) {

        return "hi " + name;
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }

}
