package com.cafe.backend.user.service;

import com.cafe.backend.common.exception.custom.NotFoundException;
import com.cafe.backend.user.entity.*;
import com.cafe.backend.user.repository.UserProfileImageRepository;
import com.cafe.backend.user.repository.UserProfileManagementRepository;
import com.cafe.backend.user.repository.UserRepository;
import com.cafe.backend.user.service.request.UserProfileImageModifyRequest;
import com.cafe.backend.user.service.request.UserProfileInfoModifyRequest;
import com.cafe.backend.user.service.response.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserProfileManagementServiceImpl implements UserProfileManagementService {
    final private UserRepository userRepository;
    final private UserProfileImageRepository userProfileImageRepository;
    final private UserProfileManagementRepository userProfileRepository;

    private User findUserByUserToken(String userToken) {
        // TODO : Redis에서 UserToken으로 User 찾아오는걸로 추후에 수정해야합니다. (~˘▾˘)~♫•*¨*•.¸¸♪
        return userRepository.findUserByUserToken(userToken)
                .orElseThrow(() -> new NotFoundException("This is a non-existent user."));
    }

    private UserProfile findUserProfileByUser(User user) {
        return userProfileRepository.findUserProfileByUser(user)
                .orElseThrow(() -> new NotFoundException("This is a non-existent user profile."));
    }

    private UserProfileImage findUserProfileImageByUser(User user) {
        return userProfileImageRepository.findUserProfileByUser(user)
                .orElseThrow(() -> new NotFoundException("This is a non-existent user profile image."));
    }

    @Override
    public UserProfileResponse findUserProfileByUserToken(String userToken) {
        log.info("findUserProfileByUserToken():  회원 프로필 정보 조회 start!");
        final User user = findUserByUserToken(userToken);
        final UserProfile userProfile = findUserProfileByUser(user);
        final UserProfileImage userProfileImage = findUserProfileImageByUser(user);

        log.info("findUserProfileByUserToken():  회원 프로필 정보 조회 end!");
        return new UserProfileResponse(
                user.getId(), userProfile.getEmail(), userProfile.getNickname(), userProfile.getPhoneNumber(), userProfileImage.getUserProfileImage());
    }

    @Override
    public Boolean checkDuplicateEmail(String email) {
        Email emailAddress = new Email(email);

        final Optional<UserProfile> maybeUserProfile = userProfileRepository.findUserProfileByEmail(emailAddress.getEmail());

        if (maybeUserProfile.isEmpty()) {
            log.info("can use this email!");
            return true;
        } else {
            log.info("already exist email!");
            return false;
        }
    }

    @Override
    public Boolean checkDuplicateNickname(String nickname) {
        Nickname userNickname = new Nickname(nickname);

        final Optional<UserProfile> maybeUserProfile = userProfileRepository.findUserProfileByNickname(userNickname.getNickname());

        if (maybeUserProfile.isEmpty()) {
            log.info("can use this nickname!");
            return true;
        } else {
            log.info("already exist nickname!");
            return false;
        }
    }

    @Override
    public Boolean modifyUserProfileInfo(UserProfileInfoModifyRequest request) {
        log.info("modifyUserProfileInfo() start!");
        Optional<User> maybeUser = userRepository.findUserByUserToken(request.getUserToken());
        if (maybeUser.isEmpty()) {
            return false;
        }

        final User user = maybeUser.get();

        Optional<UserProfile> maybeUserProfile = userProfileRepository.findUserProfileByUser(user);
        if (maybeUserProfile.isPresent()) {
            UserProfile userProfile = maybeUserProfile.get();
            userProfile.ModifyUserProfile(
                    request.getEmail(),
                    request.getNickname(),
                    request.getPhoneNumber());
            userProfileRepository.save(userProfile);
        }
        return false;
    }

    @Override
    public Boolean modifyUserProfileImage(UserProfileImageModifyRequest request) {
        log.info("modifyUserProfileImage() start!");
        final Optional<UserProfile> maybeUserProfile = userProfileRepository.findUserProfileByEmail(request.getEmail());
        if (maybeUserProfile.isPresent()) {
            UserProfileImage userProfileImage = maybeUserProfile.get().getUserProfileImage();
            userProfileImage.ModifyUserProfileImage(
                    request.getPrefixWithFileName());
            userProfileImageRepository.save(userProfileImage);
            return true;
        }
        return false;
    }
}
