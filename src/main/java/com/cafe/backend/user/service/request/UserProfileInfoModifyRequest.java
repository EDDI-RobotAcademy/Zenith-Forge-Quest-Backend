package com.cafe.backend.user.service.request;

import com.cafe.backend.user.entity.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserProfileInfoModifyRequest {
    final private String email;
    final private String nickname;
    final private String phoneNumber;
    final private String userToken;

    public UserProfile toUserProfile() {
        return new UserProfile(
                email, nickname, phoneNumber
        );
    }
}
