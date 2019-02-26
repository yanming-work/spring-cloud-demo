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
        spring:
          application:
             name: eureka-server  
        eureka:
          instance:
            hostname: localhost
          client:
            fetch-registry: false
            register-with-eureka: false
            serviceUrl:
              defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/

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
                
   ####建立高可用注册服务中心（集群）
        准备多台机器 （peer1，peer2，peer3），配置对于的IP(修改hosts文件)。
        在eureka-server 服务端，添加多个配置文件。
   #####application-peer1.yml
    server:
      port: 10000
    spring:
      application:
         name: eureka-server  
    eureka:
      instance:
        hostname: peer1
      client:
        serviceUrl:
          defaultZone: http://peer1:10000/eureka/,http://peer2:10000/eureka/,http://peer3:10000/eureka/
   #####application-peer2.yml
    server:
      port: 10000
    spring:
      application:
         name: eureka-server  
    eureka:
      instance:
        hostname: peer2
      client:
        serviceUrl:
          defaultZone: http://peer1:10000/eureka/,http://peer2:10000/eureka/,http://peer3:10000/eureka/
   #####application-peer3.yml
    server:
      port: 10000
    spring:
      application:
         name: eureka-server  
    eureka:
      instance:
        hostname: peer3
      client:
        serviceUrl:
          defaultZone: http://peer1:10000/eureka/,http://peer2:10000/eureka/,http://peer3:10000/eureka/

###打包发布
用 maven 打成jar包，并将jar包分别放到三个服务器上,在三个服务器上分别启动服务，分别执行下面三行命令

java -jar eureka-server.jar --spring.profiles.active=peer1
java -jar eureka-server.jar --spring.profiles.active=peer2
java -jar eureka-server.jar --spring.profiles.active=peer3