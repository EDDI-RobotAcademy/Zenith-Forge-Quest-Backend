package com.cafe.backend.user.service.request;

import com.cafe.backend.user.entity.UserProfile;
import com.cafe.backend.user.entity.UserProfileImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;

@Getter
@AllArgsConstructor
public class UserProfileImageModifyRequest {
    final private String email;
    final private String prefixWithFileName;

//    public UserProfileImage toUserProfileImage() {
//        return new UserProfileImage(
//                prefixWithFileName
//        );
//    }
}
