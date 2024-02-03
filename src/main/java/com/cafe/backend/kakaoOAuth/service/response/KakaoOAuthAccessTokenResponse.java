package com.cafe.backend.kakaoOAuth.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class KakaoOAuthAccessTokenResponse {
    @JsonProperty("token_type")
    final private String token_type;

    @JsonProperty("access_token")
    final private String access_token;

    @JsonProperty("expires_in")
    final private int expires_in;

    @JsonProperty("refresh_token")
    final private String refresh_token;

    @JsonProperty("refresh_token_expires_in")
    final private int refresh_token_expires_in;
}
