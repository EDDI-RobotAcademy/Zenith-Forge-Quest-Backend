package com.cafe.backend.user.controller;

import com.cafe.backend.user.controller.form.UserProfileInfoModifyRequestForm;
import com.cafe.backend.user.service.UserProfileManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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


    // 이메일 중복 검사
    @GetMapping(value = "/check-email")
    public Boolean checkDuplicateEmail(@RequestParam("email") String email) {
        log.info("checkDuplicateEmail(): " + email);
        return userProfileService.checkDuplicateEmail(email);
    }
}
