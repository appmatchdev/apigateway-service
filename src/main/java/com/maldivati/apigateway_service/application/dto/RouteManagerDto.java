package com.maldivati.apigateway_service.application.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class RouteManagerDto {

        private UUID pkidMstRouteManager;
        private LocalDateTime creationDate;
        private String expirationDate;
        private String serviceName;
        private String descriptiveName;
        private String method;
        private String protocol;
        private String uri;
        private String port;
        private String predicates;
        private String filters;
        private String endpoint;

}
