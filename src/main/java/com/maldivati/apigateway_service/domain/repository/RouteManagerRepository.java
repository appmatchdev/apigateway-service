package com.maldivati.apigateway_service.domain.repository;

import com.maldivati.apigateway_service.domain.model.entity.RouteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface RouteManagerRepository extends JpaRepository<RouteManagerEntity, UUID> {
    RouteManagerEntity findByServiceName(String serviceName);
}
