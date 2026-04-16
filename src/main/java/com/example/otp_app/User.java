package com.example.otp_app; // 1. Must match the Service package exactly

public class User { // 2. Must be capitalized 'U'
    private String email;
    private String password;
    private String otp;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }
}