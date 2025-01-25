package com.maldivati.apigateway_service.application.port.in;

import com.maldivati.apigateway_service.application.dto.RouteManagerDto;
import com.maldivati.apigateway_service.application.port.out.ApiResponseDto;

import java.util.UUID;

public interface RouteManagerService {
    ApiResponseDto createRoute(RouteManagerDto dto);
    ApiResponseDto readRoute(UUID id);
    ApiResponseDto updateRoute(UUID id, RouteManagerDto dto);
}
