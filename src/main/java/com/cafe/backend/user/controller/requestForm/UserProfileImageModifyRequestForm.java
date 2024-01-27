package com.cafe.backend.user.controller.requestForm;

import com.cafe.backend.user.service.request.UserProfileImageModifyRequest;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
public class UserProfileImageModifyRequestForm {
    private String email;

    public UserProfileImageModifyRequest toModifyUserProfileImage(MultipartFile file) {
        UUID randomPrefix = UUID.randomUUID();
        String prefixWithFileName = randomPrefix + file.getOriginalFilename();

        return new UserProfileImageModifyRequest(
                email,
                prefixWithFileName
        );
    }
}
