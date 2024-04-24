package com.cafe.backend.user.service;


import com.cafe.backend.common.httpHeader.HttpHeaderCreator;
import com.cafe.backend.common.kakaoOAuth.KakaoOAuthSecretsProvider;
import com.cafe.backend.kakaoOAuth.controller.requestForm.KakaoUserLoginRequestForm;
import com.cafe.backend.kakaoOAuth.service.KakaoOAuthService;
import com.cafe.backend.redis.RedisService;
import com.cafe.backend.user.entity.User;
import com.cafe.backend.user.entity.UserProfile;
import com.cafe.backend.user.repository.UserProfileManagementRepository;
import com.cafe.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
    final private UserProfileManagementRepository userProfileManagementRepository;
//    final private UserManagementRepository userManagementRepository;

    final private RedisService redisService;

    @Override
    public RedirectView userRegister(KakaoUserLoginRequestForm requestForm) {
        log.info("userRegisterAndLoginForKakao() -> requestForm: {}", requestForm);

//        String idToken = requestForm.getIdToken();
//        User user = userRepository.findByUserProfileEmail(email);

        String accessToken = requestForm.getAccessToken();
        log.info("userRegister() -> accessToken: {}", accessToken);

        HttpHeaders httpHeaders = HttpHeaderCreator.createHttpHeader(
                MediaType.APPLICATION_FORM_URLENCODED, "Accept", "application/json");
        httpHeaders.add("Authorization", "Bearer " + accessToken);

        return null;

//        RedirectView redirectView;
//        redisService.setKeyAndValue(requestForm.getAccessToken(), email);
//
//        if (user == null) {
//            redirectView = handleNewUser(
//                    requestForm.getEmail(), requestForm.getAccessToken(), requestForm.getRefreshToken(),
//                    requestForm.getNickName(), null, requestForm.getPicture(),
//                    null, platformType);
//        } else if (user.getActive().equals(NO)) {
//            redirectView = handleInactiveUser(
//                    requestForm.getAccessToken(), requestForm.getRefreshToken(),
//                    requestForm.getNickName(), requestForm.getId(), null,
//                    requestForm.getPicture(), null, user, platformType);
//        } else {
//            redirectView = handleActiveUser(
//                    requestForm.getAccessToken(), requestForm.getRefreshToken(),
//                    user, platformType);
//        }
//
//        return redirectView;
    }

    @Override
    public String userLogIn(User user, String platform) {
        log.info("userLogIn start");

//        Optional<UserProfile> maybeUserProfile = userProfileRepository.findByUser(user);
//
//        String profileImg = "";
//        String nickName = "";
//
//        try {
//            if(maybeUserProfile.isPresent()) {
//                profileImg = maybeUserProfile.get().getProfileImg();
//                nickName = maybeUserProfile.get().getNickName();
//
//                if (profileImg != null) {
//                    profileImg = URLEncoder.encode(profileImg, "UTF-8");
//                }
//
//                if (nickName != null) {
//                    nickName = URLEncoder.encode(nickName, "UTF-8");
//                }
//            }
//
//            String userToken = platform + UUID.randomUUID();
//
//            redisService.setUserTokenAndUser(userToken, user.getAccessToken());
//
//            // 로그인 후 헤더에 프로필 사진, 닉네임을 띄우기 위해 url에 담아서 전달
//            String mainPageUserInfo = userToken + "&profileImg=" + profileImg + "&nickName=" + nickName;
//
//            log.info("userLogIn end");
//            return mainPageUserInfo;
//
//        } catch (Exception e) {
//            log.error("Failed to login for user {}: {}", user.getId(), e.getMessage(), e);
//            return null;
//        }

        return null;
    }

    @Override
    public boolean userLogOut(String userToken) {
        return false;
    }

    @Override
    public boolean userWithdrawal(String userToken) {
        return false;
    }

//    private RedirectView handleNewUser(
//            String id, String accessToken, String refreshToken, String nickName,
//            String email, String profileImg, String contactNumber, String platformType) {
//
//        User user = signUpUser(id, accessToken, refreshToken, userType);
//        saveUserProfile(id, nickName, email, profileImg, contactNumber, user);
//        saveUserManagement(user);
//
//        log.info("User not registered with us. Sign up completed.");
//        return getRedirectView(user, platformType);
//    }
//
//    private User signUpUser(String id, String accessToken, String refreshToken) {
//        User user = User.builder()
//                .id(id)
//                .active(YES)
//                .accessToken(accessToken)
//                .refreshToken(refreshToken)
//                .build();
//        userRepository.save(user);
//        return user;
//    }

}
