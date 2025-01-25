package com.maldivati.apigateway_service.infraestructure.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class testController {
    @PostMapping("/conect")
    public ResponseEntity<String> createUser() {
        return ResponseEntity.ok("Test Sussefull");
    }
}
