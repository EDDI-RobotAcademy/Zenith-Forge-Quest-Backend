package com.cafe.backend.user.repository;

import com.cafe.backend.user.entity.User;
import com.cafe.backend.user.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileManagementRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findUserProfileByUser(User user);
    Optional<UserProfile> findUserProfileByEmail(String email);
    Optional<UserProfile> findUserProfileByNickname(String nickname);
}
