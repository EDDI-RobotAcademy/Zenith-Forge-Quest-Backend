package com.cafe.backend.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
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

    @NotNull
    private String email;

    @NotNull
    private String nickname;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String profileImg;

    @Builder
    public UserProfile(String email, String nickname, String phoneNumber, String profileImg) {
        this.email = email;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.profileImg = profileImg;
    }
}