package com.example.otp_app;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class PasswordController {

    private final PasswordResetService resetService;

    public PasswordController(PasswordResetService resetService) {
        this.resetService = resetService;
    }

    // Task 1: Request OTP
    @PostMapping("/request-otp")
    public String requestOtp(@RequestParam String email) {
        String otp = resetService.generateOTP(email);
        if (otp != null) {
            return "OTP has been sent to your email (Check console for the code).";
        }
        return "Error: User email not found.";
    }

    // Task 1: Verify OTP and Reset Password
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String email, 
                                @RequestParam String otp, 
                                @RequestParam String newPassword) {
        boolean success = resetService.verifyAndReset(email, otp, newPassword);
        if (success) {
            return "Success: Password has been updated.";
        }
        return "Error: Invalid OTP or Email.";
    }
}