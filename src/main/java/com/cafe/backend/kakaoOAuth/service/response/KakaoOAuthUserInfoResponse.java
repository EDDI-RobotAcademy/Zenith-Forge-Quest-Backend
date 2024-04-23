package com.cafe.backend.kakaoOAuth.service.response;

import lombok.Data;
import lombok.Getter;

@Getter
public class KakaoOAuthUserInfoResponse {
    private String id;
    private String connected_at;
    private Properties properties;

    @Data
    public class Properties {
        private String nickname;
        private String profile_image;
    }
}
