package com.maldivati.apigateway_service.domain.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "mst_route_manager", schema = "appmatch_apigateway")
public class RouteManagerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkid_mst_route_manager", nullable = false, updatable = false)
    private UUID pkidMstRouteManager;

    @Column(name = "creation_date", nullable = false)
    private String creationDate;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "descriptive_name")
    private String descriptiveName;


    @Column(name = "method")
    private String method;

    @Column(name = "protocol")
    private String protocol;

    @Column(name = "uri")
    private String uri;

    @Column(name = "port")
    private String port;

    @Column(name = "predicates")
    private String predicates;

    @Column(name = "filters")
    private String filters;

    @Column(name = "endpoint")
    private String endpoint;
}
