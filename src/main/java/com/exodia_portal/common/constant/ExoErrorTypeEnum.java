package com.exodia_portal.common.constant;

public enum ExoErrorTypeEnum {
    TOAST("toast"),
    FIELD("field");

    private final String value;

    ExoErrorTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}