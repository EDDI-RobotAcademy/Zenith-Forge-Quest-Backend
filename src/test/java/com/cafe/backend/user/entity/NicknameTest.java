package com.cafe.backend.user.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class NicknameTest {

    @Test
    public void testValidNickname() {
        String validNickname = "goodUser123";
        Nickname nickname = new Nickname(validNickname);
        assertEquals(validNickname, nickname.getNickname());
    }

    @Test
    public void testNullNickname() {
        String nullNickname = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Nickname(nullNickname));
        assertEquals("닉네임은 null이 될 수 없습니다!", exception.getMessage());
    }

    @Test
    public void testEmptyNickname() {
        String emptyNickname = " ";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Nickname(emptyNickname));
        assertEquals("닉네임을 입력해야 합니다!", exception.getMessage());
    }

    @Test
    public void testShortNickname() {
        String shortNickname = "ab";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Nickname(shortNickname));
        assertEquals("닉네임은 3자 이상 20자 이하로 작성되어야 합니다!", exception.getMessage());
    }

    @Test
    public void testLongNickname() {
        String longNickname = "abcdefghijklmnopqrstuvwxyz";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Nickname(longNickname));
        assertEquals("닉네임은 3자 이상 20자 이하로 작성되어야 합니다!", exception.getMessage());
    }

    @Test
    public void testForbiddenNickname() {
        String forbiddenNickname = "admin";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Nickname(forbiddenNickname));
        assertEquals("부적절한 닉네임입니다!", exception.getMessage());
    }

}

