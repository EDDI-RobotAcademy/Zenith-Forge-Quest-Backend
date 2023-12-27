package com.cafe.backend.UserProfileTests;

import com.cafe.backend.user.controller.form.UserProfileImageModifyRequestForm;
import com.cafe.backend.user.entity.User;
import com.cafe.backend.user.entity.UserProfile;
import com.cafe.backend.user.entity.UserProfileImage;
import com.cafe.backend.user.repository.UserProfileImageRepository;
import com.cafe.backend.user.repository.UserProfileManagementRepository;
import com.cafe.backend.user.repository.UserRepository;
import com.cafe.backend.user.service.UserProfileManagementServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserProfileTests {

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private UserProfileImageRepository mockUserProfileImageRepository;
    @Mock
    private UserProfileManagementRepository mockUserProfileRepository;

    @InjectMocks
    private UserProfileManagementServiceImpl mockUserProfileService;

    @Test
    @DisplayName("check duplicate email")
    public void 이메일의_중복_여부를_확인합니다() {
        final String enteredByUserEmail = "test@test.com";

        final UserProfile userProfile = new UserProfile(
                "faker@test.com",
                "nickname",
                "010-1234-1234"
        );

        when(mockUserProfileRepository.findUserProfileByEmail(enteredByUserEmail))
                .thenReturn(Optional.of(userProfile));

        Boolean isAlreadyExistEmail = mockUserProfileService.checkDuplicateEmail(enteredByUserEmail);
        assertEquals(isAlreadyExistEmail, false);
    }

    @Test
    @DisplayName("check duplicate nickname")
    public void 닉네임의_중복_여부를_확인합니다() {
        final String enteredByUserNickname = "대상혁";

        final UserProfile userProfile = new UserProfile(
                "faker@test.com",
                "nickname",
                "010-1234-1234"
        );

        when(mockUserProfileRepository.findUserProfileByNickname(enteredByUserNickname))
                .thenReturn(Optional.of(userProfile));

        Boolean isAlreadyExistNickname = mockUserProfileService.checkDuplicateNickname(enteredByUserNickname);
        assertEquals(isAlreadyExistNickname, false);
    }

    @Test
    @DisplayName("modify user profile info")
    public void 회원의_프로필_정보를_수정합니다() {
        // user
        final String userId = "1";
        final String accessToken = "at1";
        final String refreshToken = "rt1";

        final User user = mockUserRepository.findByUserToken("1234");
        final Optional<UserProfile> maybeUserProfile = mockUserProfileRepository.findUserProfileByUser(user);

        if (user == null) {
        }

        if (maybeUserProfile.isPresent()) {
            UserProfile userProfile = maybeUserProfile.get();
            userProfile.ModifyUserProfile(
                    "modifyEmail@test.com",
                    "modifyNickname",
                    "010-9999-9999"
            );
            mockUserProfileRepository.save(userProfile);
        }
    }

    @Test
    @DisplayName("modify user profile info")
    public void 회원의_프로필_사진을_수정합니다() {
        UserProfileImage userProfileImage = new UserProfileImage("test_image.jpg");

        UserProfileImageModifyRequestForm form = new



    }

}
