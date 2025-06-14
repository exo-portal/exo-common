package com.exodia_portal.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum representing different types of error handling mechanisms in the application.
 * <ul>
 *     <li><b>TOAST</b>: Used for displaying error messages as toast notifications.</li>
 *     <li><b>FIELD</b>: Used for associating error messages with specific input fields.</li>
 * </ul>
 */
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
