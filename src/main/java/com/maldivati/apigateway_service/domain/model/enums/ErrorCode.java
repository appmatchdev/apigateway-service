package com.maldivati.apigateway_service.domain.model.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    ACCOUNT_ALREADY_EXISTS("1001", "Username already exists","La cuenta de usuario ya existe"),
    ACCOUNT_NOT_FOUND("1002", "User not found","EL usuario no se encuentra"),
    DATABASE_ERROR("1003", "Database connection error","Error de conexión a la base de datos"),
    INTERNAL_SERVER_ERROR("9999", "Internal Server Error","Error Interno");

    private final String code;
    private final String messageEu;
    private final String messageEs;

    // Constructor
    ErrorCode(String code, String messageEu, String messageEs) {
        this.code = code;
        this.messageEu = messageEu;
        this.messageEs = messageEs;
    }
}
