package com.cafe.backend.user.service;


import com.cafe.backend.user.controller.form.UserProfileModifyRequestForm;

public interface UserProfileService {
    Boolean modifyUserProfile(UserProfileModifyRequestForm request);
}
