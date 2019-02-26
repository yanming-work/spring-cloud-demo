# spring-cloud-config

    配置管理工具包，让你可以把配置放到远程服务器，集中化管理集群配置，目前支持本地存储、Git以及Subversion。

##配置管理服务端 spring-cloud-config-server
    创建application.yml 配置文件
    
        server:
          port: 8686
        spring:
          application:
            name: config-server
          cloud:
            config:
              server:
                default-application-name: ${spring.application.name}
                #配置本地
                #native:
                  #search-locations: classpath:/config/
                # 配置git仓库
                git:
                  # git仓库地址
                  uri: https://github.com/yanming-work/config_demo
                  # 配置仓库路径
                  search-paths: yml
                  label: master
                  # 访问git仓库的用户密码 如果Git仓库为公开仓库，可以不填写用户名和密码，如果是私有仓库需要填写
                  #username: username
                  #password: *********
        # 注册中心配置
        eureka:
          instance:
            hostname: localhost
          client:
            serviceUrl:
              defaultZone: http://localhost:10000/eureka/


##配置管理客户端 spring-cloud-config-client
