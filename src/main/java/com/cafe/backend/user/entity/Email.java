package com.cafe.backend.user.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@ToString
public class Email {

    private String email;

    public Email(String email) {
        checkEmailValidation(email);
        this.email = email;
    }

    private void checkEmailValidation (String email) {
        if (email == null) {
            throw new IllegalArgumentException("email은 null이 될 수 없습니다!");
        }

        if (email.trim().isEmpty()) {
            throw new IllegalArgumentException("email을 입력해야 합니다!");
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("유효하지 않은 이메일 형식입니다!");
        }
    }
}
