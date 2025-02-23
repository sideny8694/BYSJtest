package com.XBGC;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @description 内容管理服务启动类
 * @author Mr.w
 * @date
 * @version 1.0
 */

@EnableFeignClients(basePackages={"com.XBGC.content.feignclient"})
@SpringBootApplication //启动类 要在com.XBGC修 因为我们的根目录就是这个结构 然后在进行扫包
public class ContentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentApplication.class, args);
    }
}

