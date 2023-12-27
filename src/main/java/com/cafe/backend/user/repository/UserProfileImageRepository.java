package com.cafe.backend.user.repository;

import com.cafe.backend.user.entity.UserProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserProfileImageRepository extends JpaRepository<UserProfileImage, Long> {
}
