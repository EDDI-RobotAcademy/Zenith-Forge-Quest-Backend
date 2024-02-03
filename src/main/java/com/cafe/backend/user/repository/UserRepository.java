package com.cafe.backend.user.repository;

import com.cafe.backend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.accessToken = :accessToken")
    Optional<User> findByUserToken(String accessToken);
}
