package com.exodia_portal.common.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles exceptions of type ExoPortalErrorMessage and returns a structured response.
     *
     * This method is annotated with @ExceptionHandler to indicate that it handles
     * exceptions to the specified type. It logs the exception details for troubleshooting
     * and monitoring purposes and constructs a response entity containing the exception details.
     *
     * @param ex The exception of type ExoPortalErrorMessage that was thrown.
     * @return A ResponseEntity containing a map with the status, error type, and error message list.
     */
    @ExceptionHandler(ExoPortalErrorMessage.class)
    public ResponseEntity<Map<String, Object>> handleExoPortalErrorMessage(ExoPortalErrorMessage ex) {

        // Log exception details
        logger.error("Exception occurred: Status={}, ErrorType={}, ErrorMessages={}",
                ex.getStatus(), ex.getErrorType(), ex.getErrorMessageList(), ex);

        return ResponseEntity.status(ex.getStatus())
                .body(Map.of(
                        "status", ex.getStatus(),
                        "errorType", ex.getErrorType().toString(),
                        "errorMessageList", ex.getErrorMessageList()
                ));
    }

}
