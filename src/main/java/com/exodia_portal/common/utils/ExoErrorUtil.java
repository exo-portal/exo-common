package com.exodia_portal.common.utils;

import com.exodia_portal.common.constant.ExoConstant;
import com.exodia_portal.common.enums.ExoErrorKeyEnum;
import lombok.experimental.UtilityClass;

import java.util.Map;

/**
 * Utility class for building error details in a standardized format.
 * Provides methods to construct error maps for specific fields,
 * ensuring consistency in error handling across the application.
 */
@UtilityClass
public class ExoErrorUtil {

    /**
     * Builds a map containing error details for a specific field.
     *
     * @param fieldName the name of the field that has an error
     * @param errorKeyEnum the enum representing the error key
     * @return a map with field name and error message
     */
    public static Map<String, String> buildFieldError(String fieldName, ExoErrorKeyEnum errorKeyEnum) {
        return Map.of(
                ExoConstant.FIELD_NAME_KEY, fieldName,
                ExoConstant.ERROR_MESSAGE_KEY, errorKeyEnum.getKey()
        );
    }

}
