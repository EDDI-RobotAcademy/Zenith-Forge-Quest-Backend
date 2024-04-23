package com.cafe.backend.kakaoOAuth.service;

import com.cafe.backend.common.httpHeader.HttpHeaderCreator;
import com.cafe.backend.common.kakaoOAuth.KakaoOAuthSecretsProvider;
import com.cafe.backend.kakaoOAuth.controller.requestForm.KakaoUserLoginRequestForm;
import com.cafe.backend.kakaoOAuth.service.response.KakaoOAuthAccessTokenResponse;
import com.cafe.backend.kakaoOAuth.service.response.KakaoOAuthUserInfoResponse;
import com.cafe.backend.user.entity.User;
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

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class KakaoOAuthServiceImpl implements KakaoOAuthService {
    final private KakaoOAuthSecretsProvider kakaoOAuthSecretsProvider;
    final private UserRepository userRepository;
    final private RestTemplate restTemplate;

    @Override
    public KakaoUserLoginRequestForm kakaoLogin(String code) {
        log.info("kakaoLogin()");

        // 카카오 서버에서 accessToken 받아오기
        KakaoOAuthAccessTokenResponse kakaoOauthAccessTokenResponse = requestAccessTokenFromKakao(code);
        final String accessToken = kakaoOauthAccessTokenResponse.getAccess_token();
        final String refreshToken = kakaoOauthAccessTokenResponse.getRefresh_token();

        // 카카오 서버에서 받아온 accessToken으로 사용자 정보 받아오기
        KakaoOAuthUserInfoResponse kakaoOauthUserInfoResponse = requestUserInfoFromKakao(accessToken);

        KakaoUserLoginRequestForm kakaoUserLoginRequestForm
                = new KakaoUserLoginRequestForm(
                kakaoOauthAccessTokenResponse.getAccess_token(),
                kakaoOauthAccessTokenResponse.getRefresh_token(),
                kakaoOauthUserInfoResponse.getId(),
                kakaoOauthUserInfoResponse.getProperties().getNickname(),
                kakaoOauthUserInfoResponse.getProperties().getProfile_image());

        return kakaoUserLoginRequestForm;
    }

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

        return kakaoAccessTokenResponseForm.getBody();
    }

    private KakaoOAuthUserInfoResponse requestUserInfoFromKakao(String accessToken) {
        log.info("requestUserInfoFromKakao()");

        final String kakaoUserInfoRequestUrl = kakaoOAuthSecretsProvider.getKAKAO_USERINFO_REQUEST_URL();

        try {
            HttpHeaders httpHeaders = HttpHeaderCreator.createHttpHeader(
                    MediaType.APPLICATION_FORM_URLENCODED, "Accept", "application/json");
            httpHeaders.add("Authorization", "Bearer " + accessToken);

            HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

            ResponseEntity<KakaoOAuthUserInfoResponse> kakaoUserInfoResponseForm
                    = restTemplate.postForEntity(kakaoUserInfoRequestUrl, requestEntity, KakaoOAuthUserInfoResponse.class);

            return kakaoUserInfoResponseForm.getBody();

        } catch (RestClientException e) {
            log.error("Error during requestUserInfoFromKakao: " + e.getMessage());

//            Optional<User> maybeUser = userRepository.findByAccessToken(accessToken);
//            User user = maybeUser.get();
//            KakaoOAuthAccessTokenResponse kakaoOauthAccessTokenResponse = refreshKakaoAccessToken(user);
//
//            HttpHeaders httpHeaders = HttpHeaderCreator.createHttpHeader(
//                    MediaType.APPLICATION_FORM_URLENCODED, "Accept", "application/json");
//            httpHeaders.add("Authorization", "Bearer " + kakaoOauthAccessTokenResponse.getAccess_token());
//
//            HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
//
//            ResponseEntity<KakaoOAuthUserInfoResponse> kakaoUserInfoResponseForm
//                    = restTemplate.postForEntity(kakaoUserInfoRequestUrl, requestEntity, KakaoOAuthUserInfoResponse.class);
//
//            return kakaoUserInfoResponseForm.getBody();

            return null;
        }
    }

    // 카카오 리프래쉬 토큰으로 액세스 토큰 재발급
//    @Override
//    public KakaoOAuthAccessTokenResponse refreshKakaoAccessToken(User user) {
//        log.info("refreshKakaoAccessToken start");
//
//        String refreshToken = user.getRefreshToken();
//
//        // 헤더 설정
//        HttpHeaders httpHeaders = HttpHeaderCreator.createHttpHeader(
//                MediaType.APPLICATION_FORM_URLENCODED, "Accept", "application/json");
//
//        // 바디 설정
//        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
//        parameters.add("grant_type", "refresh_token");
//        parameters.add("client_id", kakaoOAuthSecretsProvider.getKAKAO_AUTH_RESTAPI_KEY());
//        parameters.add("refresh_token", refreshToken);
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, httpHeaders);
//
//        ResponseEntity<KakaoOAuthAccessTokenResponse> kakaoAccessTokenResponseForm = restTemplate.postForEntity(
//                kakaoOAuthSecretsProvider.getKAKAO_REFRESH_TOKEN_REQUEST_URL(),
//                requestEntity,
//                KakaoOAuthAccessTokenResponse.class);
//
//        final String renewAccessToken = kakaoAccessTokenResponseForm.getBody().getAccess_token();
//        final String renewRefreshToken = kakaoAccessTokenResponseForm.getBody().getRefresh_token();
//
//        log.info("new accessToken : " + renewAccessToken);
//        log.info("new refreshToken : " + renewRefreshToken);
//
//        user.updateAccessToken(renewAccessToken);
//
//        // refreshToken의 유효 기간이 1개월 미만인 경우 새로운 refreshToken을 받아오므로 새롭게 저장
//        if(renewRefreshToken != null) {
//            log.info("RefreshToken successfully renewed");
//            user.updateRefreshToken(renewRefreshToken);
//        }
//        userRepository.save(user);
//
//        return kakaoAccessTokenResponseForm.getBody();
//    }
}