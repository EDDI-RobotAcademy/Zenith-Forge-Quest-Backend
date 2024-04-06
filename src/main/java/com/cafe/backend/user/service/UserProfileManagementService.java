package com.cafe.backend.user.service;

import com.cafe.backend.user.service.request.UserProfileImageModifyRequest;
import com.cafe.backend.user.service.request.UserProfileInfoModifyRequest;
import com.cafe.backend.user.service.response.UserProfileResponse;

public interface UserProfileManagementService {
    UserProfileResponse findUserProfileByUserToken(String userToken);
    Boolean checkDuplicateEmail(String email);
    Boolean checkDuplicateNickname(String nickname);
    Boolean modifyUserProfileInfo(UserProfileInfoModifyRequest request);
    Boolean modifyUserProfileImage(UserProfileImageModifyRequest request);
}
