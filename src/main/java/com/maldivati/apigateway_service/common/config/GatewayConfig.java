package com.maldivati.apigateway_service.common.config;

import com.maldivati.apigateway_service.domain.model.entity.RouteManagerEntity;
import com.maldivati.apigateway_service.domain.repository.RouteManagerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GatewayConfig {

    private static final Logger logger = LoggerFactory.getLogger(GatewayConfig.class);

    private final RouteManagerRepository routeManagerRepository;

    public GatewayConfig(RouteManagerRepository routeManagerRepository) {
        this.routeManagerRepository = routeManagerRepository;
    }

    /**
     * Configura las rutas para el API Gateway dinámicamente desde la base de datos.
     *
     * @param builder El constructor de rutas de Spring Cloud Gateway.
     * @return Un objeto RouteLocator que define las rutas configuradas.
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        List<RouteManagerEntity> routes = routeManagerRepository.findAll();

        // Log para ver la lista de rutas obtenidas
        logger.info("Configurando rutas dinámicamente desde la base de datos: ");
        for (RouteManagerEntity routeConfig : routes) {
            String uri = routeConfig.getProtocol() + routeConfig.getUri() + routeConfig.getPort();
            logger.info("Ruta: {} - Predicado: {} - Filtro: {} - URI: {}",
                    routeConfig.getPkidMstRouteManager(), routeConfig.getPredicates(), routeConfig.getFilters(), uri);
        }

        // Usar la lista de rutas desde la base de datos para configurar dinámicamente las rutas del Gateway
        RouteLocatorBuilder.Builder routesBuilder = builder.routes();
        for (RouteManagerEntity routeConfig : routes) {
            String uri = routeConfig.getProtocol() + routeConfig.getUri() + routeConfig.getPort();
            String finalUri = uri;
            routesBuilder.route(r -> r.path(routeConfig.getPredicates())
                    .filters(f -> f.stripPrefix(Integer.parseInt(routeConfig.getFilters())))
                    .uri(finalUri));
        }

        return routesBuilder.build();
    }
}
