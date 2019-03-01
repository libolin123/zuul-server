package com.tianyaleixiaolin.zuulserver.core.controller;

import com.tianyaleixiaolin.zuulserver.core.service.RefreshRouteService;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;


/**
 * @author libolin wrote on 2019/03/01
 */
@RestController
public class RouteController {
    @Resource
    private RefreshRouteService refreshRouteService;
    @Resource
    private ZuulHandlerMapping zuulHandlerMapping;

    @GetMapping("/refreshRoute")
    public String refresh() {
        refreshRouteService.refreshRoute();
        return "refresh success";
    }

    @RequestMapping("/watchRoute")
    public Object watchNowRoute() {
        //可以用debug模式看里面具体是什么
        Map<String, Object> handlerMap = zuulHandlerMapping.getHandlerMap();
        return handlerMap;
    }
}
