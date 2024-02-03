package com.cafe.backend.common.httpHeader;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HttpHeaderCreator {

    public static HttpHeaders createHttpHeader(MediaType contentType, String headerName, String headerValue) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(contentType);
        httpHeaders.add(headerName, headerValue);

        return httpHeaders;
    }
}
