package com.cafe.backend.common.exception.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Error {

    private final String fieldName;

    private final String message;

    @Builder
    public Error(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message   = message;
    }
}
