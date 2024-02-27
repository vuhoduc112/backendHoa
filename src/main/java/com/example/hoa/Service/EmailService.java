package com.example.hoa.Service;

public interface EmailService {
    void sendResetPasswordEmail(String to, String resetUrl);
}
