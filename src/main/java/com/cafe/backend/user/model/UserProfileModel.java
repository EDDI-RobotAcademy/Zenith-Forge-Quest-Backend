package com.cafe.backend.user.model;

import com.cafe.backend.user.entity.Email;
import com.cafe.backend.user.entity.User;
import com.cafe.backend.user.entity.UserProfileImage;

public class UserProfileModel {
    private Long id;
    private Email email;
    private String nickname;
    private String phoneNumber;
    private User user;
    private UserProfileImage userProfileImage;
}
