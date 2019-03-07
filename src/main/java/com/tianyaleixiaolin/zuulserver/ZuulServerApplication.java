package com.tianyaleixiaolin.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author libolin update wrote on 2018/03/01
 *
 * @EnableDiscoveryClient 与 @EnableEurekaClient ：后者只适用于eureka，前者适用所有的注册中心，后者包含前者所有功能（看源码）
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

}
