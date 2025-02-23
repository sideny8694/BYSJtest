package com.XBGC;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Mr.w
 * @description 内容管理服务启动类
 */
@EnableSwagger2Doc
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.XBGC.content.feignclient"}) // 新增此注解
public class ContentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentApplication.class, args);
    }
}
