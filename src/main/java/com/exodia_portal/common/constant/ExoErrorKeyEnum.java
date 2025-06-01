package com.exodia_portal.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExoErrorKeyEnum {
    EMAIL_ALREADY_EXISTS("errorMessage.emailAlreadyExists"),
    INVALID_EMAIL_AND_PASSWORD("errorMessage.invalidEmailAndPassword");

    private final String key;

    @Override
    public String toString() {
        return key;
    }
}
