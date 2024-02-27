package com.example.hoa.Service.ServiceImpl;

import com.example.hoa.Service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendResetPasswordEmail(String to, String resetUrl) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vuhoduc40@gmail.com");
        message.setTo(to);
        message.setSubject("Đặt lại mật khẩu");
        message.setText("Để đặt lại mật khẩu của bạn, vui lòng nhấp vào liên kết sau: " + resetUrl);
        emailSender.send(message);
    }
}
