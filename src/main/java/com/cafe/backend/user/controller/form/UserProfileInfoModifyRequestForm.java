package com.cafe.backend.user.controller.form;

import com.cafe.backend.user.service.request.UserProfileInfoModifyRequest;
import lombok.*;

@Getter
@RequiredArgsConstructor
public class UserProfileInfoModifyRequestForm {
    private String email;
    private String nickname;
    private String phoneNumber;
    private String userToken;

    public UserProfileInfoModifyRequest toModifyUserProfileInfo() {
        return new UserProfileInfoModifyRequest(
                email, nickname, phoneNumber, userToken
        );
    }
}
