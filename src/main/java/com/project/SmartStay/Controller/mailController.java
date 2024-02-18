package com.project.SmartStay.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.SmartStay.Services.MyMailSender;

import jakarta.servlet.http.HttpSession;


@Controller
public class mailController {

    @Autowired
    MyMailSender senderService;

    @GetMapping("/VerifyEmail")
    public String verifyEmail(@RequestParam String email, HttpSession session) {
        String otp = senderService.sendMail(email); // Get the OTP from sendMail method
        session.setAttribute("email", email);
        session.setAttribute("otp", otp); // Store the OTP in session
        return "VerifyEmail";
    }

    @GetMapping("/verifyOtp")
    public String verifyOtp(@RequestParam int otp, HttpSession session) {
        String email = (String) session.getAttribute("email");
        String storedOtp = (String) session.getAttribute("otp");

        if (email == null || storedOtp == null) {
            // Handle error, email or OTP not found in session
            return "verificationFailed";
        }

        // Compare the entered OTP with the stored OTP
        if (storedOtp.equals(String.valueOf(otp))) {
            // Verification successful
            return "verificationSucess";
        } else {
            // Verification failed
            return "verificationFailed";
        }
    }
}
