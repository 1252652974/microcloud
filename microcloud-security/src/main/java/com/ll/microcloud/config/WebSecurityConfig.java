package com.ll.microcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.annotation.Resource;

/**
 * @program: microcloud
 * @description: 安全配置类
 * @author: liuliang
 * @create: 2019-04-02 18:52
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("liuliang").password("hello").roles("USER")
                .and().withUser("ll").password("hello").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表示所有的访问都必须进行认证处理后才能正常运行
        http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated();
        //所有的Rest服务一定要设置为无状态，以提升操作性能
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }
}
