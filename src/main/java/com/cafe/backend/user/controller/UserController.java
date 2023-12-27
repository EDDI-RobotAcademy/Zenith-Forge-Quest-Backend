package com.cafe.backend.user.controller;

import com.cafe.backend.user.controller.form.UserProfileImageModifyRequestForm;
import com.cafe.backend.user.controller.form.UserProfileInfoModifyRequestForm;
import com.cafe.backend.user.service.UserProfileManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    final private UserProfileManagementService userProfileService;

    // 회원 프로필 정보 수정
    @PutMapping("/modify-user-profile-info")
    public Boolean modifyUserProfileInfo(@RequestBody UserProfileInfoModifyRequestForm form) {
        log.info("modifyUserProfile(): " + form);
        return userProfileService.modifyUserProfileInfo(form.toModifyUserProfileInfo());
    }

    // 회원 프로필 이미지 수정
    @PutMapping(value = "/modify-user-profile-image",
                consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
                                MediaType.APPLICATION_JSON_VALUE })
    public Boolean modifyUserProfileImage(@RequestPart(value = "imageFile") MultipartFile imageFile,
                                          @RequestPart(value = "userInfo") UserProfileImageModifyRequestForm form) {
        return userProfileService.modifyUserProfileImage(form.toModifyUserProfileImage(imageFile));
    }

    // 이메일 중복 검사
    @GetMapping(value = "/check-email")
    public Boolean checkDuplicateEmail(@RequestParam("email") String email) {
        return userProfileService.checkDuplicateEmail(email);
    }

    @GetMapping(value = "/check-duplicate-nickname")
    public Boolean checkDuplicateNickname(@RequestParam("nickname") String nickname) {
        return userProfileService.checkDuplicateNickname(nickname);
    }
}
