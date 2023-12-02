package com.cafe.backend.user.service;


import com.cafe.backend.user.controller.form.UserProfileModifyRequestForm;

public interface UserProfileService {
    Boolean modifyUserProfile(UserProfileModifyRequest request);
    Boolean checkDuplicateEmail(String email);
}
