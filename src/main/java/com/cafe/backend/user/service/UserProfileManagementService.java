package com.cafe.backend.user.service;

import com.cafe.backend.user.service.request.UserProfileInfoModifyRequest;

public interface UserProfileManagementService {
    Boolean checkDuplicateEmail(String email);
    Boolean modifyUserProfileInfo(UserProfileInfoModifyRequest request);
}
