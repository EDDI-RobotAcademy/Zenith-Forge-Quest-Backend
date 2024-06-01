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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    private String userProfileImage;

    public UserProfileImage(String prefixWithFileName) {
        this.userProfileImage = prefixWithFileName;
    }

    public static UserProfileImage of(String prefixWithFileName) {
        return new UserProfileImage(prefixWithFileName);
    }

    public void setUserProfile(User user) {
        this.user = user;
    }

    public void ModifyUserProfileImage(String prefixWithFileName) {
        this.userProfileImage = prefixWithFileName;
    }
}
