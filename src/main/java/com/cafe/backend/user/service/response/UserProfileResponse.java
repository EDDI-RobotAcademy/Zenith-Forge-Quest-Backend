package com.cafe.backend.user.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserProfileResponse {
    final private String userId;
    final private String email;
    final private String nickname;
    final private String phoneNumber;
    final private String profileImage;
}
