# Eureka注册中心

    云端服务发现，一个基于 REST 的服务，用于定位服务，以实现云端中间层服务发现和故障转移。

##Eureka 服务端
    eureka-server 服务端代码实现
        在pom中引入依赖包：
        <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-eureka-server</artifactId>
                    <version>1.4.6.RELEASE</version>
         </dependency>

        创建 application.yml 配置文件：
        server:
          port: 10000
        eureka:
          instance:
            hostname: localhost
          client:
            fetch-registry: false
            register-with-eureka: false
            serviceUrl:
              defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/```

##Eureka 客户端端
    eureka-client 客户端代码实现
         在pom中引入依赖包
         <dependency>
                     <groupId>org.springframework.cloud</groupId>
                     <artifactId>spring-cloud-starter-eureka</artifactId>
                     <version>1.4.6.RELEASE</version>
          </dependency>
          创建 application.yml 配置文件：
          server:
            port: 8001
          spring:
            application:
              name: eureka-client
          # 注册中心配置
          eureka:
            client:
              serviceUrl:
                defaultZone: http://localhost:10000/eureka/