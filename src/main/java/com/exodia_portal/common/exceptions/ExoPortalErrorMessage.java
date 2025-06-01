package com.exodia_portal.common.exceptions;

import com.exodia_portal.common.constant.ExoErrorTypeEnum;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class ExoPortalErrorMessage extends RuntimeException {
    private final int status;

    private final ExoErrorTypeEnum errorType;

    private final List<Map<String, String>> errorMessageList;


    public ExoPortalErrorMessage(int status, ExoErrorTypeEnum errorType, List<Map<String, String>> errorMessageList) {
        super(String.format("Error occurred with status: %d, type: %s", status, errorType));
        this.status = status;
        this.errorType = errorType;
        this.errorMessageList = errorMessageList;
    }
}