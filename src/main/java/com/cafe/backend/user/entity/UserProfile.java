package com.cafe.backend.user.entity;

import com.cafe.backend.user.service.request.UserProfileRegistRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nickname;
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "userProfile", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private UserProfileImage userProfileImage;

    public UserProfile(String email, String nickname, String phoneNumber) {
        this.email = email;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
    }

    public UserProfile(String email, String nickname, String phoneNumber, UserProfileImage userProfileImage) {
        this.email = email;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.userProfileImage = userProfileImage;
        userProfileImage.setUserProfile(this);
    }
}