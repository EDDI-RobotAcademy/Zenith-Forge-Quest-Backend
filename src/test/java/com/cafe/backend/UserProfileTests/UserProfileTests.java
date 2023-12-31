package com.cafe.backend.UserProfileTests;

import com.cafe.backend.user.entity.User;
import com.cafe.backend.user.entity.UserProfile;
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
    private UserProfileManagementRepository mockUserProfileRepository;
    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserProfileManagementServiceImpl mockUserProfileService;

    @Test
    @DisplayName("check duplicate email")
    public void 프로필을_등록할_때_이메일이_존재하는지_확인합니다() {
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
    @DisplayName("modify user profile info")
    public boolean 회원의_프로필_정보를_수정합니다() {
        // user
        final String userId = "1";
        final String accessToken = "at1";
        final String refreshToken = "rt1";

        final User user = mockUserRepository.findByUserToken("1234");
        final Optional<UserProfile> maybeUserProfile = mockUserProfileRepository.findUserProfileByUser(user);

        if (user == null) {
            return false;
        }

        if (maybeUserProfile.isPresent()) {
            UserProfile userProfile = maybeUserProfile.get();
            userProfile.ModifyUserProfile(
                    "modifyEmail@test.com",
                    "modifyNickname",
                    "010-9999-9999"
            );
            mockUserProfileRepository.save(userProfile);
            return true;
        }
        return false;
    }

}
