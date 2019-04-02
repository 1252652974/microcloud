package com.ll.microcloud.service.impl;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @program: microcloud
 * @description: 浏览器认可的请求
 * @author: liuliang
 * @create: 2019-04-02 17:09
 **/

public class TestHeadr {
    //认证的原始信息浏览器不认，需要进行下面处理，如：autoHeader
    public static void main(String[] args) {
        String auth = "liuliang:hello"; //认证的原始信息
        byte[] encodeAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic" + new String(encodeAuth);
        System.out.printf(authHeader);
    }
}
