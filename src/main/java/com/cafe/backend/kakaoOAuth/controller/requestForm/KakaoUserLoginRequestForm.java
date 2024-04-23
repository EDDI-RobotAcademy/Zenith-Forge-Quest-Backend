package com.cafe.backend.kakaoOAuth.controller.requestForm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KakaoUserLoginRequestForm {
    private String accessToken;
    private String refreshToken;
    private String id;
    private String nickName;
    private String picture;
}
