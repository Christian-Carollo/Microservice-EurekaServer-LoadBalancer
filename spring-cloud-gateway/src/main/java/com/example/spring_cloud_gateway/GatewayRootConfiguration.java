package com.example.spring_cloud_gateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GatewayRootConfiguration {

    @Bean
    public RouteLocator customRoute(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p.path("/get")
                        .filters(h-> h.addRequestHeader("MyHeader","TryHeader")
                                .addRequestParameter("MyParam","TryParam"))
                        .uri("http://httpbin.org:80"))
                .route(p->p.path("/servicea/**").uri("lb://CLIENT1")).build();
    }
    
}
