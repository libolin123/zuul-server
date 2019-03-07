package com.tianyaleixiaolin.zuulserver.config.dynamic;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author libolin wrote on 2019/01/01
 */
@Configuration
public class DynamicZuulConfig {

    @Resource
    private ZuulProperties zuulProperties;

    @Resource
    private ServerProperties serverProperties;

    @Bean
    public DynamicZuulRouteLocator routeLocator() {
        return new DynamicZuulRouteLocator(
                serverProperties.getServlet().getServletPrefix(), zuulProperties);
    }
}