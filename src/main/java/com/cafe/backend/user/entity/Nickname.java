package com.cafe.backend.user.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ToString
@Getter
public class Nickname {
    private String nickname;

    public Nickname(String nickname) {
        checkNicknameValidation(nickname);
        this.nickname = nickname;
    }

    private void checkNicknameValidation(String nickname) {
        if (nickname == null) {
            throw new IllegalArgumentException("닉네임은 null이 될 수 없습니다!");
        }

        String trimmedNickname = nickname.trim();

        if (trimmedNickname.isEmpty()) {
            throw new IllegalArgumentException("닉네임을 입력해야 합니다!");
        }

        if (trimmedNickname.length() < 3 || trimmedNickname.length() > 20) {
            throw new IllegalArgumentException("닉네임은 3자 이상 20자 이하로 작성되어야 합니다!");
        }

        String forbiddenRegex = ".*\\b(금지어|각종금지어리스트|금지어관리목록|admin)\\b.*";
        Pattern forbiddenPattern = Pattern.compile(forbiddenRegex);
        Matcher matcher = forbiddenPattern.matcher(trimmedNickname);

        if (matcher.matches()) {
            throw new IllegalArgumentException("부적절한 닉네임입니다!");
        }
    }
}
