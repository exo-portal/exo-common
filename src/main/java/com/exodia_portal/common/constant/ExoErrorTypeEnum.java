package com.exodia_portal.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExoErrorTypeEnum {
    TOAST("toast"),
    FIELD("field");

    private final String value;

}