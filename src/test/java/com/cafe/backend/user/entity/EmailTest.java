package com.cafe.backend.user.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class EmailTest {

    @Test
    public void testValidEmail() {
        String validEmail = "test@example.com";
        Email email = new Email(validEmail);
        assertEquals(validEmail, email.getEmail());
    }

    @Test
    public void testNullEmail() {
        String nullEmail = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Email(nullEmail));
        assertEquals("email은 null이 될 수 없습니다!", exception.getMessage());
    }

    @Test
    public void testEmptyEmail() {
        String emptyEmail = " ";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Email(emptyEmail));
        assertEquals("email을 입력해야 합니다!", exception.getMessage());
    }

    @Test
    public void testInvalidEmailFormat() {
        String invalidEmail = "invalid-email";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Email(invalidEmail));
        assertEquals("유효하지 않은 이메일 형식입니다!", exception.getMessage());
    }
}