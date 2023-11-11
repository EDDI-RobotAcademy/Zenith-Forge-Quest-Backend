package com.cafe.backend.user.controller;

import com.cafe.backend.user.controller.form.UserProfileModifyRequestForm;
import com.cafe.backend.user.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    final private UserProfileService userProfileService;

    // 회원 프로필 수정
    @PostMapping("/modify-user-profile")
    public Boolean modifyUserProfile(@RequestBody UserProfileModifyRequestForm form) {
        log.info("modifyUserProfile(): " + form);
        return userProfileService.modifyUserProfile(form);
    }

}
