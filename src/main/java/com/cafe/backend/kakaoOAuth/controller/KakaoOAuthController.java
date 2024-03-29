package com.cafe.backend.kakaoOAuth.controller;

import com.cafe.backend.kakaoOAuth.service.KakaoOAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/kakao-oauth")
public class KakaoOAuthController {
    final private KakaoOAuthService kakaoAuthenticationService;
}
