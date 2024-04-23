package com.cafe.backend.user.service;


import com.cafe.backend.common.kakaoOAuth.KakaoOAuthSecretsProvider;
import com.cafe.backend.kakaoOAuth.controller.requestForm.KakaoUserLoginRequestForm;
import com.cafe.backend.kakaoOAuth.service.KakaoOAuthService;
import com.cafe.backend.redis.RedisService;
import com.cafe.backend.user.entity.User;
import com.cafe.backend.user.entity.UserProfile;
import com.cafe.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    final private KakaoOAuthSecretsProvider kakaoOauthSecretsProvider;
    final private KakaoOAuthService kakaoAuthenticationService;

    final private UserRepository userRepository;
//    final private UserProfileRepository userProfileRepository;
//    final private UserManagementRepository userManagementRepository;

    final private RedisService redisService;

    @Override
    public RedirectView userRegisterAndLoginForKakao(KakaoUserLoginRequestForm requestForm) {
        log.info("userRegisterAndLoginForKakao()");

        Optional<User> maybeUser = userRepository.findByStringId(requestForm.getId());

        RedirectView redirectView;
        final String platformType = "kakao";

        if (maybeUser.isEmpty()) {
            redirectView = handleNewUser(
                    requestForm.getId(), requestForm.getAccessToken(), requestForm.getRefreshToken(),
                    requestForm.getNickName(), null, requestForm.getPicture(),
                    null, platformType);
        } else if (maybeUser.get().getActive().equals(NO)) {
            redirectView = handleInactiveUser(
                    requestForm.getAccessToken(), requestForm.getRefreshToken(),
                    requestForm.getNickName(), requestForm.getId(), null,
                    requestForm.getPicture(), null, maybeUser.get(), platformType);
        } else {
            redirectView = handleActiveUser(
                    requestForm.getAccessToken(), requestForm.getRefreshToken(),
                    maybeUser.get(), platformType);
        }

        return redirectView;
    }

    @Override
    public String userLogIn(User user, String platform) {
        log.info("userLogIn start");

        Optional<UserProfile> maybeUserProfile = userProfileRepository.findByUser(user);

        String profileImg = "";
        String nickName = "";

        try {
            if(maybeUserProfile.isPresent()) {
                profileImg = maybeUserProfile.get().getProfileImg();
                nickName = maybeUserProfile.get().getNickName();

                if (profileImg != null) {
                    profileImg = URLEncoder.encode(profileImg, "UTF-8");
                }

                if (nickName != null) {
                    nickName = URLEncoder.encode(nickName, "UTF-8");
                }
            }

            String userToken = platform + UUID.randomUUID();

            redisService.setUserTokenAndUser(userToken, user.getAccessToken());

            // 로그인 후 헤더에 프로필 사진, 닉네임을 띄우기 위해 url에 담아서 전달
            String mainPageUserInfo = userToken + "&profileImg=" + profileImg + "&nickName=" + nickName;

            log.info("userLogIn end");
            return mainPageUserInfo;

        } catch (Exception e) {
            log.error("Failed to login for user {}: {}", user.getId(), e.getMessage(), e);
            return null;
        }
    }

    @Override
    public boolean userLogOut(String userToken) {
        return false;
    }

    @Override
    public boolean userWithdrawal(String userToken) {
        return false;
    }
}
