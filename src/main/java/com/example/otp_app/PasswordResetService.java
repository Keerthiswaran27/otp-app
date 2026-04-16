package com.example.otp_app;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class PasswordResetService {
    private final Map<String, User> userDatabase = new HashMap<>();

    public PasswordResetService() {
        userDatabase.put("admin@example.com", new User("admin@example.com", "password123"));
    }

    // Must be generateOTP (all caps OTP)
    public String generateOTP(String email) {
        if (!userDatabase.containsKey(email)) return null;
        String otp = String.format("%06d", new Random().nextInt(999999));
        userDatabase.get(email).setOtp(otp);
        return otp;
    }

    // Must be verifyAndReset
    public boolean verifyAndReset(String email, String otp, String newPassword) {
        User user = userDatabase.get(email);
        if (user != null && user.getOtp() != null && user.getOtp().equals(otp)) {
            user.setPassword(newPassword);
            user.setOtp(null);
            return true;
        }
        return false;
    }
}