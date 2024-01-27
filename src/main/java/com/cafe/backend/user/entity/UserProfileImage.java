package com.cafe.backend.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@NoArgsConstructor
public class UserProfileImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;

    private String userProfileImage;

    public UserProfileImage(String prefixWithFileName) {
        this.userProfileImage = prefixWithFileName;
    }

    public static UserProfileImage of(String prefixWithFileName) {
        return new UserProfileImage(prefixWithFileName);
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public void ModifyUserProfileImage(String prefixWithFileName) {
        this.userProfileImage = prefixWithFileName;
    }
}
