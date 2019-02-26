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
    创建application.yml 配置文件
        #因为spring boot是启动的时候才从配置文件中读取配置属性，配置文件在远程配置中心的话，注册中心的信息需要放在bootstrap.properties中才能启动优先读取，放在application.properties.会报该异常没发现属性
        server:
          port: 8787
        spring:
          application:
            name: config-clinet #指定了配置文件的应用名
          cloud:
            #配置中心
            config:
              # 指明配置服务中心的网址
              uri: http://localhost:8686
              name: config
              #指定的环境 dev 开发环境配置文件 |  test 测试环境  |  pro 正式环境
              profile: dev
              #指定分支
              label: master
        # 注册中心配置
        eureka:
          client:
            serviceUrl:
              defaultZone: http://localhost:10000/eureka/