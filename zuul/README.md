# Zuul
Zuul 是在云平台上提供动态路由,监控,弹性,安全等边缘服务的框架。Zuul 相当于是设备和 Netflix 流应用的 Web 网站后端所有请求的前门。

Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如／api/user转发到到user服务，/api/shop转发到到shop服务。zuul默认和Ribbon结合实现了负载均衡的功能。
zuul有以下功能：

    Authentication
    Insights
    Stress Testing
    Canary Testing
    Dynamic Routing
    Service Migration
    Load Shedding
    Security
    Static Response handling
    Active/Active traffic management


     新建application.yml
     
     
     server:
       port: 6677
     spring:
       application:
         name: service-zuul
     eureka:
            client:
              serviceUrl:
                defaultZone: http://localhost:10000/eureka/    
     zuul:
       routes:
         api-a:
           path: /api-a/**
           serviceId: service-ribbon
         api-b:
           path: /api-b/**
           serviceId: service-feign
     
       首先服务的端口为6677，指定服务注册中心的地址为http://localhost:10000/eureka/，服务名为service-zuul；以/api-a/ 开头的请求都转发给service-ribbon服务；以/api-b/开头的请求都转发给service-feign服务；
       
       
       服务过滤
       
       zuul不仅只是路由，并且还能过滤，做一些安全验证。继续改造工程；
       
       创建Filter 继承 ZuulFilter 
       
       filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
       
           pre：路由之前
           routing：路由之时
           post： 路由之后
           error：发送错误调用
       
       filterOrder：过滤的顺序
       shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
       run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    
       