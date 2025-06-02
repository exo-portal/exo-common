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
public enum ExoErrorTypeEnum {
    TOAST("toast"),
    FIELD("field");

    private final String value;

    @Override
    public String toString() {
        return value;
    }

}