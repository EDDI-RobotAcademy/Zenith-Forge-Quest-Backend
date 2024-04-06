package com.cafe.backend.common.kakaoOAuth;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@PropertySource(value = "classpath:application.properties")
@Configuration
@NoArgsConstructor
@AllArgsConstructor
public class KakaoOAuthSecretsProvider {
    @Value("${kakao.oauth.restapi.key}")
    private String KAKAO_AUTH_RESTAPI_KEY;

    @Value("${kakao.oauth.redirect.url}")
    private String KAKAO_AUTH_REDIRECT_URL;

    @Value("${kakao.login.redirect.view}")
    private String KAKAO_REDIRECT_VIEW_URL;

    @Value("${kakao.oauth.token.request.url}")
    private String KAKAO_TOKEN_REQUEST_URL;

    @Value("${kakao.oauth.user.info.request.url}")
    private String KAKAO_USERINFO_REQUEST_URL;

    @Value("${kakao.oauth.refresh.token.request}")
    private String KAKAO_REFRESH_TOKEN_REQUEST_URL;

    @Value("${kakao.oauth.revoke.url}")
    private String KAKAO_DISCONNECT_REQUEST_URL;
}
