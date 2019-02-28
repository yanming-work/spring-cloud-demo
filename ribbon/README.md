# Ribbon
提供云端负载均衡，有多种负载均衡策略可供选择，可配合服务发现和断路器使用。
Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端,负载均衡的工具;

    /**
     * 实例化ribbon使用的RestTemplate,使用@EnableEurekaClient声明为Eureka客户端， RestTemplate需要配合@LoadBalanced才能通过服务名spring.application.name解析到具体的服务上
     */
    @LoadBalanced
    @Bean(name="remoteRestTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    
     @Autowired
     @Qualifier(value = "remoteRestTemplate")
     private RestTemplate remoteRestTemplate;  
     
     
     启动eureka-service 再 启动多个 eureka-provider 服务（至少两个才能体现出负载均衡）。
     
     idea怎么允许一个服务启动多个。
     
    右上角 选择服务的下拉框中选择 Edit Configurations...  然后弹出Run/Debug Configurations 窗体 ,选择对应要启动多个的Application。在右边勾选 Allow parallel run（idea 版本为 Single instance only）
    

  