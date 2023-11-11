package com.cafe.backend.common.exception.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Builder
public class ExceptionResponse {

    private List<Error> errors;

    public static ExceptionResponse create(String errorMessage) {

        List<Error> errors = Collections.singletonList(
                Error.builder()
                        .message(errorMessage)
                        .build()
        );
        return ExceptionResponse.builder()
                .errors(errors)
                .build ();
    }

    public static ExceptionResponse create(List<ObjectError> objectErrors) {
        List<Error> errors = new ArrayList<>();

        objectErrors.forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            errors.add(
                    Error.builder()
                    .field(fieldName)
                    .message(errorMessage)
                    .build()
            );
        });

        return ExceptionResponse.builder()
                .errors(errors)
                .build();
    }
}
