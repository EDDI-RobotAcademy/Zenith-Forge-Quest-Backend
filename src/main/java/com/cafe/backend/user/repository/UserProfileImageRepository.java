package com.cafe.backend.user.repository;

import com.cafe.backend.user.entity.User;
import com.cafe.backend.user.entity.UserProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserProfileImageRepository extends JpaRepository<UserProfileImage, Long> {
    Optional<UserProfileImage> findUserProfileByUser(User user);
}
