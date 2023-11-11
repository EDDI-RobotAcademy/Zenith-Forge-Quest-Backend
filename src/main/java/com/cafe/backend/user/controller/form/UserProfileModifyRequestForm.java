package com.cafe.backend.user.controller.form;

import com.cafe.backend.user.entity.UserProfile;
import lombok.*;

import java.util.UUID;

@Getter
@ToString
@RequiredArgsConstructor
public class UserProfileModifyRequestForm {
    private String email;
    private String nickname;
    private String phoneNumber;
    private String profileImg;
}
