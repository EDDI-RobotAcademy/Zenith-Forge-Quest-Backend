package com.cafe.backend.kakaoOAuth.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
public class KakaoOAuthAccessTokenResponse {
    @JsonProperty("token_type")
    private String token_type;

    @JsonProperty("access_token")
    private String access_token;

    @JsonProperty("expires_in")
    private int expires_in;

    @JsonProperty("refresh_token")
    private String refresh_token;

    @JsonProperty("refresh_token_expires_in")
    private int refresh_token_expires_in;
}
