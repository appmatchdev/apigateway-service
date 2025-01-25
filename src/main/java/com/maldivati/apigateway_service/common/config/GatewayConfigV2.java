package com.maldivati.apigateway_service.common.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class GatewayConfigV2 {

    private static final String TARGET_URI = "http://127.0.0.1:8081";
    private static final String PATH_PATTERN = "/api/v1/users/**";
    private static final int STRIP_PREFIX_COUNT = 0;

    /**
     * Configura las rutas para el API Gateway.
     *
     * @param builder El constructor de rutas de Spring Cloud Gateway.
     * @return Un objeto RouteLocator que define las rutas configuradas.
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path(PATH_PATTERN)
                        .filters(f -> f.stripPrefix(STRIP_PREFIX_COUNT))
                        .uri(TARGET_URI)
                )
                .build();
    }
}
