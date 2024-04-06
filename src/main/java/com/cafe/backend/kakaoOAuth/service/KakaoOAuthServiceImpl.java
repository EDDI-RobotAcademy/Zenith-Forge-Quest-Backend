package com.cafe.backend.kakaoOAuth.service;

import com.cafe.backend.common.httpHeader.HttpHeaderCreator;
import com.cafe.backend.common.kakaoOAuth.KakaoOAuthSecretsProvider;
import com.cafe.backend.kakaoOAuth.service.response.KakaoOAuthAccessTokenResponse;
import com.cafe.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class KakaoOAuthServiceImpl implements KakaoOAuthService {
    final private KakaoOAuthSecretsProvider kakaoOAuthSecretsProvider;
    final private UserRepository userRepository;
    final private RestTemplate restTemplate;

    private KakaoOAuthAccessTokenResponse requestAccessTokenFromKakao(String code) {
        log.info("requestAccessTokenFromKakao start");

        final String kakaoClientId = kakaoOAuthSecretsProvider.getKAKAO_AUTH_RESTAPI_KEY();
        final String kakaoRedirectUrl = kakaoOAuthSecretsProvider.getKAKAO_AUTH_REDIRECT_URL();
        final String kakaoTokenRequestUrl = kakaoOAuthSecretsProvider.getKAKAO_TOKEN_REQUEST_URL();

        HttpHeaders httpHeaders = HttpHeaderCreator.createHttpHeader(
                MediaType.APPLICATION_FORM_URLENCODED, "Accept", "application/json");

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("grant_type", "authorization_code");
        parameters.add("client_id", kakaoClientId);
        parameters.add("redirect_uri", kakaoRedirectUrl);
        parameters.add("code", code);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, httpHeaders);

        ResponseEntity<KakaoOAuthAccessTokenResponse> kakaoAccessTokenResponseForm
                = restTemplate.postForEntity(kakaoTokenRequestUrl, requestEntity, KakaoOAuthAccessTokenResponse.class);

        log.info("requestAccessTokenFromKakao end");
        return kakaoAccessTokenResponseForm.getBody();
    }
}