package com.maldivati.apigateway_service.domain.model.enums;

import lombok.Getter;

@Getter
public enum SuccessCodeEnum {
    USER_CREATED("User created successfully","Usuario Creado correctamente", "001"),
    USER_FOUND("User found successfully", "Usuario encontrado correctamente","002"),
    USER_UPDATED("User updated successfully","Usuario actualizado exitosamente", "003"),
    USER_DELETED("User deleted successfully","Usuario borrado correctamente", "004");

    private final String messageEu;
    private final String messageEs;
    private final String code;

    SuccessCodeEnum(String messageEu, String messageEs, String code) {
        this.messageEu = messageEu;
        this.messageEs = messageEs;
        this.code = code;
    }
}
