package com.exodia_portal.common.exceptions;

import com.exodia_portal.common.constant.ExoErrorTypeEnum;

import java.util.List;
import java.util.Map;

public class ExoPortalErrorMessage extends RuntimeException {
    private int status;
    private String errorType;
    private List<Map<String, String>> errorMessageList;


    public ExoPortalErrorMessage(int status, ExoErrorTypeEnum errorType, List<Map<String, String>> errorMessageList) {
        super(String.format("Error occurred with status: %d, type: %s", status, errorType));
        this.status = status;
        this.errorType = errorType.toString();
        this.errorMessageList = errorMessageList;
    }

    public int getStatus() {
        return status;
    }

    public String getErrorType() {
        return errorType;
    }

    public List<Map<String, String>> getErrorMessageList() {
        return errorMessageList;
    }
}