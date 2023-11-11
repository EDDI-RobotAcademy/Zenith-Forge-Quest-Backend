package com.cafe.backend.user.service;

import com.cafe.backend.user.controller.form.UserProfileModifyRequestForm;
import com.cafe.backend.user.entity.UserProfile;
import com.cafe.backend.user.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    final private UserProfileRepository userProfileRepository;

    @Override
    public Boolean modifyUserProfile(UserProfileModifyRequestForm request) {
        // TODO: token값으로 회원 찾기

        Optional<UserProfile> maybeAccount = userProfileRepository.findByEmail(request.getEmail());
        UserProfile userProfile;
        log.info("modifyAccountInfo's maybeAccount: " + maybeAccount);

        if (maybeAccount.isEmpty()) {
            log.info("doesn't exist member!");
            return false;
        }

        userProfile = UserProfile.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .phoneNumber(request.getPhoneNumber())
                .profileImg(request.getProfileImg())
                .build();

        // Boolean 값으로 변경 성공인지 실패인지 반환하기 vs UserProfileResponseForm 만들어서 변경된 값들을 반환하기
        // 일단은 boolean값으로 진행 해보고 추후에 필요에따라 수정해보잣..
        userProfileRepository.save(userProfile);
        return true;
    }
}
