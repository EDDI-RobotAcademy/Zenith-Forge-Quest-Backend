package com.cafe.backend.UserProfileTests;

import com.cafe.backend.user.entity.UserProfile;
import com.cafe.backend.user.repository.UserProfileRepository;
import com.cafe.backend.user.service.UserProfileServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserProfileTests {

    @Mock
    private UserProfileRepository mockUserProfileRepository;

    @InjectMocks
    private UserProfileServiceImpl mockUserProfileService;

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

}
