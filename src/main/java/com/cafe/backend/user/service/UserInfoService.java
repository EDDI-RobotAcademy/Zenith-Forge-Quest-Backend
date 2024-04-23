package com.cafe.backend.user.service;

import com.cafe.backend.kakaoOAuth.controller.requestForm.KakaoUserLoginRequestForm;
import com.cafe.backend.user.entity.User;
import org.springframework.web.servlet.view.RedirectView;

public interface UserInfoService {
    RedirectView userRegisterAndLoginForKakao(KakaoUserLoginRequestForm requestForm);
    String userLogIn(User user, String platform);
    boolean userLogOut(String userToken);
    boolean userWithdrawal(String userToken);
}
