package com.project.SmartStay.Services;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyMailSender {

    @Autowired
    private EmailSenderService senderService;

    public String sendMail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email address cannot be null or empty");
        }

        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000;
        String randomString = Integer.toString(randomNumber);

        senderService.sendEmail(email, "SmartStay Verification code", "Use this Verification code to verify your account: " + randomString);
        return randomString;
    }
}

