# Hystrix
熔断器，容错管理工具，旨在通过熔断机制控制服务和第三方库的节点,从而对延迟和故障提供更强大的容错能力。

改造ribbon 工程的代码，首先在pox.xml文件中加入spring-cloud-starter-netflix-hystrix的起步依赖：

    <dependency> 
        <groupId>org.springframework.cloud</groupId> 
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId> 
    </dependency>
    
    修改 HelloService

    @Service
    public class HelloService {
        @Autowired
        @Qualifier(value = "remoteRestTemplate")
        private RestTemplate remoteRestTemplate;
        @HystrixCommand(fallbackMethod = "hiError")
        public String helloService(String name) {
            //return this.restTemplate.getForObject("http://localhost:8060/hello?name="+name,String.class);
            return this.remoteRestTemplate.getForObject("http://eureka-provider/hello?name=" + name, String.class);
        }
        public String hiError(String name) {
            return "hi," + name + ",sorry,error!";
        }
    }
  
 启动eureka-service 再 启动多个 eureka-provider 服务（至少两个才能体现出负载均衡），能正常访问。
 关闭  eureka-provider服务 （一个一个的关闭）