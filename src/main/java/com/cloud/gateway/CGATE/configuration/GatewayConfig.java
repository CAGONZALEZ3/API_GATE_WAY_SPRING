package com.cloud.gateway.CGATE.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Ruta para el servicio en localhost:8080
                .route("testcg1", r -> r.path("/api/v1/r/**")
                        .uri("http://localhost:8080"))
                
                // Ruta para el servicio en localhost:3000
                .route("testcg2", r -> r.path("/api/v1/**")
                        .uri("http://localhost:3000"))
                
                // Ruta para el servicio JSONPlaceholder
                .route("jsonholder", r -> r.path("/todos/**")
                        .uri("https://jsonplaceholder.typicode.com"))
                .build();
    }
}