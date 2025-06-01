package com.exodia_portal.common.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExoPortalErrorMessage.class)
    public ResponseEntity<Map<String, Object>> handleExoPortalErrorMessage(ExoPortalErrorMessage ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(Map.of(
                        "status", ex.getStatus(),
                        "errorType", ex.getErrorType(),
                        "errorMessageList", ex.getErrorMessageList()
                ));
    }
}
