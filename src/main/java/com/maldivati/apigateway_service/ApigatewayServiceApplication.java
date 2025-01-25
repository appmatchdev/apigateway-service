package com.maldivati.apigateway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ApigatewayServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(ApigatewayServiceApplication.class);


	public static void main(String[] args) {
		logger.info("Iniciando ApigatewayServiceApplication...");
		SpringApplication.run(ApigatewayServiceApplication.class, args);
		logger.info("ApigatewayServiceApplication arrancada exitosamente.");
	}

}
