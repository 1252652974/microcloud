package com.ll.microcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @program: microcloud
 * @description: Rest配置类
 * @author: liuliang
 * @create: 2019-04-02 16:00
 **/
@Configuration
public class RestConfig {
    //在rest请求头信息里面添加认证信息
    @Bean
    public HttpHeaders getHeadrs() { //要进行一个Http头信息配置
        HttpHeaders headers = new HttpHeaders(); //定义一个HTTP的头信息
        String auth = "liuliang:hello"; //认证的原始信息，明文的话浏览器不认，需要加密
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
        // 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        return headers;
    }
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
