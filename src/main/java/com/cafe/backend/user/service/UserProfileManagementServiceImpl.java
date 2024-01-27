package com.cafe.backend.user.service;

import com.cafe.backend.user.entity.*;
import com.cafe.backend.user.repository.UserProfileImageRepository;
import com.cafe.backend.user.repository.UserProfileManagementRepository;
import com.cafe.backend.user.repository.UserRepository;
import com.cafe.backend.user.service.request.UserProfileImageModifyRequest;
import com.cafe.backend.user.service.request.UserProfileInfoModifyRequest;
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
        final User user = userRepository.findByUserToken(request.getUserToken());
        if (user == null) {
            return false;
        }

        final Optional<UserProfile> maybeUserProfile = userProfileRepository.findUserProfileByUser(user);
        if (maybeUserProfile.isPresent()) {
            UserProfile userProfile = maybeUserProfile.get();
            userProfile.ModifyUserProfile(
                    request.getEmail(),
                    request.getNickname(),
                    request.getPhoneNumber());
            userProfileRepository.save(userProfile);
            return true;
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
