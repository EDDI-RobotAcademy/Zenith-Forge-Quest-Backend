package com.cafe.backend.kakaoOAuth.service;

import com.cafe.backend.kakaoOAuth.controller.requestForm.KakaoUserLoginRequestForm;

public interface KakaoOAuthService {
    KakaoUserLoginRequestForm kakaoLogin(String code);
}
