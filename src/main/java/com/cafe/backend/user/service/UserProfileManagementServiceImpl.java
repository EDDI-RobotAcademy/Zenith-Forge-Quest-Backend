package com.cafe.backend.user.service;

import com.cafe.backend.user.entity.User;
import com.cafe.backend.user.entity.UserProfile;
import com.cafe.backend.user.repository.UserProfileManagementRepository;
import com.cafe.backend.user.repository.UserRepository;
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
    final private UserProfileManagementRepository userProfileRepository;

    @Override
    public Boolean checkDuplicateEmail(String email) {
        final Optional<UserProfile> maybeUserProfile = userProfileRepository.findUserProfileByEmail(email);

        if (maybeUserProfile.isEmpty()) {
            log.info("can use this email!");
            return true;
        } else {
            log.info("already exist email!");
            return false;
        }
    }

    @Override
    public Boolean modifyUserProfileInfo(UserProfileInfoModifyRequest request) {
        log.info("modifyUserProfileInfo() start!");
        final User user = userRepository.findByUserToken(request.getUserToken());
        final Optional<UserProfile> maybeUserProfile = userProfileRepository.findUserProfileByUser(user);

        if (user == null) {
            return false;
        }

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
}
