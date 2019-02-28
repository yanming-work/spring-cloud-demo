package com.github.yanming.demo.spring.cloud.hystrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.web.bind.annotation.RestController;
/**
 * 断路器聚合监控(Hystrix Turbine)
 * @description :
 * @auther :  YanMing
 * @date : 2019/2/28 13:55
 */



@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableTurbine
public class HystrixTurbineApplication {

    /**
     * http://localhost:5577/turbine.stream
     */

    public static void main(String[] args) {
        SpringApplication.run( HystrixTurbineApplication.class, args );
    }

}
