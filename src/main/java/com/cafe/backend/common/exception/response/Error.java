package com.cafe.backend.common.exception.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Error {

    private String field;

    private String message;

    @Builder
    public Error(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
