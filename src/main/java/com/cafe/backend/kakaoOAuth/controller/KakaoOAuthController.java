package com.cafe.backend.kakaoOAuth.controller;

import com.cafe.backend.kakaoOAuth.controller.requestForm.KakaoUserLoginRequestForm;
import com.cafe.backend.kakaoOAuth.service.KakaoOAuthService;
import com.cafe.backend.redis.RedisService;
import com.cafe.backend.user.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/kakao-oauth")
public class KakaoOAuthController {
    final private KakaoOAuthService kakaoAuthenticationService;
//    final private UserInfoService userInfoService;
    final private RedisService redisService;

    @GetMapping("/login")
    public String kakaoUserLogin(@RequestParam(name = "code") String code) {
        log.info("kakaoUserLogin() -> code: {}", code);
        KakaoUserLoginRequestForm requestForm = kakaoAuthenticationService.kakaoLogin(code);
//        return userInfoService.userRegister(requestForm);
        String idToken = requestForm.getIdToken();

        String userToken = UUID.randomUUID().toString();
        redisService.setKeyAndValue(userToken, idToken);

        return userToken;
    }
}
