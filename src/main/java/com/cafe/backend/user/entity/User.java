package com.cafe.backend.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString(exclude = "userProfile")
@Getter
@NoArgsConstructor
public class User {
    @Id
    private String id;

    private String accessToken;
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(String id, String accessToken, String refreshToken) {

    }
}
