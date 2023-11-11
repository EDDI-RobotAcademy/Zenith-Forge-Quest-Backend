package com.cafe.backend.common.exception.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExceptionResponse {

    private String message;

    public static ExceptionResponse create(String message) {
        return ExceptionResponse.builder()
                .message(message)
                .build();
    }
}
