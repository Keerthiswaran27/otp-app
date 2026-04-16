package com.example.otp_app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OtpAppApplicationTests {

    @Autowired
    private PasswordResetService resetService;

    @Test
    void contextLoads() {
        // This checks if the Spring application starts correctly
    }

    // Task 2: JUnit test for invalid OTP
    @Test
    void testInvalidOtpResetAttempt() {
        // Arrange: Generate an OTP for a user
        resetService.generateOTP("admin@example.com");

        // Act: Try to reset using a WRONG OTP ("000000")
        boolean result = resetService.verifyAndReset("admin@example.com", "000000", "newPass123");

        // Assert: The result should be false
        assertFalse(result, "Reset should fail when an incorrect OTP is provided.");
    }

    // Task 2: JUnit test for non-existent user
    @Test
    void testInvalidUserResetAttempt() {
        // Act: Try to reset for an email that isn't in our "database"
        boolean result = resetService.verifyAndReset("unknown@user.com", "123456", "newPass123");

        // Assert: The result should be false
        assertFalse(result, "Reset should fail when the user does not exist.");
    }
}