package com.github.yanming.demo.spring.cloud.gateway;

import com.github.yanming.demo.spring.cloud.gateway.filter.TokenFilter;
import com.github.yanming.demo.spring.cloud.gateway.filter.factory.RequestTimeGatewayFilterFactory;
import com.github.yanming.demo.spring.cloud.gateway.limiter.HostAddrKeyResolver;
import com.github.yanming.demo.spring.cloud.gateway.limiter.UriKeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/2/28 16:26
 */
@SpringBootApplication
@RestController
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    //用配置文件就不需要这些
    /**
    // tag::route-locator[]
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String httpUri = "http://httpbin.org:80";
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }
    // end::route-locator[]

    // 在上面的代码中，我们使用了另外一个router，该router使用host去断言请求是否进入该路由，当请求的host有“*.hystrix.com”，都会进入该router，该router中有一个hystrix的filter,该filter可以配置名称、和指向性fallback的逻辑的地址，比如本案例中重定向到了“/fallback”

    // tag::fallback[]
    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
    // end::fallback[]

    **/


    /**


     @Bean
     public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
     // @formatter:off
     return builder.routes()
     .route(r -> r.path("/customer/**")
     .filters(f -> f.filter(new RequestTimeFilter())
     .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
     .uri("http://httpbin.org:80/get")
     .order(0)
     .id("customer_filter_router")
     )
     .build();
     // @formatter:on
     }

     **/



     @Bean
     public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
     return new RequestTimeGatewayFilterFactory();
     }



    /**
        @Bean
        public TokenFilter tokenFilter(){
            return new TokenFilter();
        }
    **/



/**
    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }

    @Primary
    @Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }

    //以用户的维度去限流
    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

**/


}


