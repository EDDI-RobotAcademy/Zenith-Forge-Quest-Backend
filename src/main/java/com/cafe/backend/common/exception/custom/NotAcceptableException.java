package com.cafe.backend.common.exception.custom;

public class NotAcceptableException extends RuntimeException{

    public NotAcceptableException(String message) {
        super(message);
    }
}
