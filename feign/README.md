# Feign
Feign是一种声明式、模板化的HTTP客户端。
    Feign 是一个声明式WebService客户端,使用Feign只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。注意：负载均衡是加在客户端中，而不是服务端中。
    使用方法:
    
    1、定义一个接口
  
    public interface HelloClient {
        /**
            参数要加上 @RequestParam 否则无效
         **/
        @RequestMapping(method = RequestMethod.GET, value = "/hello")
        String hello(@RequestParam(value = "name")String name);
    }
    2、添加注解
     @FeignClient("eureka-provider")
     public interface HelloClient {
            /**
                参数要加上 @RequestParam 否则无效
             **/
            @RequestMapping(method = RequestMethod.GET, value = "/hello")
            String hello(@RequestParam(value = "name")String name);
        }
        
        在Controller  类中调用接口即可。
    