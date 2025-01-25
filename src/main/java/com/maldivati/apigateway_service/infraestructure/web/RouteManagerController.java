package com.maldivati.apigateway_service.infraestructure.web;


import com.maldivati.apigateway_service.application.dto.RouteManagerDto;
import com.maldivati.apigateway_service.application.port.out.ApiResponseDto;
import com.maldivati.apigateway_service.infraestructure.persistence.RouteManagerServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/router")
@CrossOrigin(origins = "*")
public class RouteManagerController {

    private final RouteManagerServiceImpl _routeManagerService;

    public RouteManagerController(RouteManagerServiceImpl routeManagerService) {
        this._routeManagerService = routeManagerService;
    }
    @PostMapping(value = "/createRoute", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseDto> createAccount(@RequestBody RouteManagerDto request) {
        ApiResponseDto createdUser = _routeManagerService.createRoute(request);
        return ResponseEntity.status(201).body(createdUser);
    }
}
