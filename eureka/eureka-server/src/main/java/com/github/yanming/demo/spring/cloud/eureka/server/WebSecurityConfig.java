package com.github.yanming.demo.spring.cloud.eureka.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * CSRF是指跨站请求伪造（Cross-site request forgery），是web常见的攻击之一。
 * 从Spring Security 4.0开始，默认情况下会启用CSRF保护，以防止CSRF攻击应用程序，Spring Security CSRF会针对PATCH，POST，PUT和DELETE方法进行防护。
 * 启用了@EnableWebSecurity注解后，csrf保护就自动生效了。
 **/

/**
 * @description :
 * @auther :  YanMing
 * @date : 2019/3/1 11:01
 */
@EnableWebSecurity //注解后，csrf保护就自动生效了。
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }
}