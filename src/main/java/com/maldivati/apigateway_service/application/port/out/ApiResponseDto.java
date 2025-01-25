package com.maldivati.apigateway_service.application.port.out;


import com.maldivati.apigateway_service.common.config.utils.Messages;
import com.maldivati.apigateway_service.domain.model.enums.ErrorCode;
import com.maldivati.apigateway_service.domain.model.enums.SuccessCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto<T> {

    private boolean success;
    private String code;
    private T data;
    private Messages messages;

    // Método de conveniencia para crear una respuesta exitosa con datos
    public static <T> ApiResponseDto<T> success(T data, SuccessCodeEnum successCode) {
        Messages messages = new Messages();
        messages.setMessageConsole("null");
        messages.setMessageEu(successCode.getMessageEu());
        messages.setMessageEs(successCode.getMessageEs());
        return new ApiResponseDto<>(true, successCode.getCode(), data, messages);
    }

    // Método de conveniencia para crear una respuesta de error con datos
    public static <T> ApiResponseDto<T> error(T data, ErrorCode errorCode, String messageConsole) {
        Messages messages = new Messages();
        messages.setMessageConsole(messageConsole);
        messages.setMessageEu(errorCode.getMessageEu());
        messages.setMessageEs(errorCode.getMessageEs());
        return new ApiResponseDto<>(false, errorCode.getCode(), data, messages);
    }

    // Respuesta de error sin datos
    public static <T> ApiResponseDto<T> error(ErrorCode errorCode, String messageConsole) {
        Messages messages = new Messages();
                messages.setMessageConsole(messageConsole);
        messages.setMessageEu(errorCode.getMessageEu());
        messages.setMessageEs(errorCode.getMessageEs());
        return new ApiResponseDto<>(false, errorCode.getCode(), null, messages);
    }

    // Respuesta exitosa sin datos
    public static <T> ApiResponseDto<T> success(SuccessCodeEnum successCode) {
        Messages messages = new Messages();
        messages.setMessageConsole("null");
        messages.setMessageEu(successCode.getMessageEu());
        messages.setMessageEs(successCode.getMessageEs());
        return new ApiResponseDto<>(true, successCode.getCode(), null, messages);
    }

}