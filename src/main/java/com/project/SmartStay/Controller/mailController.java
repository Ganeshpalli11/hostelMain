package com.project.SmartStay.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.SmartStay.Services.MyMailSender;
import com.project.SmartStay.entity.Users;
import com.project.SmartStay.Services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class mailController {

    @Autowired
    MyMailSender senderService;

    @Autowired
    UserService userService;

    @GetMapping("/VerifyEmail")
    public String verifyEmail(@RequestParam String email, @RequestParam String name,
                              @RequestParam String sur_name, @RequestParam String address,
                              @RequestParam String gender, @RequestParam long adhar,
                              @RequestParam String pass, @RequestParam String confirm_pass,
                              HttpSession session) {
        boolean status = userService.LoginUser(email, pass);
        String otp = null;

        if (!status) { // User does not exist
            otp = senderService.sendMail(email);
        }

        session.setAttribute("email", email);
        session.setAttribute("name", name);
        session.setAttribute("sur_name", sur_name);
        session.setAttribute("address", address);
        session.setAttribute("gender", gender);
        session.setAttribute("adhar", adhar);
        session.setAttribute("pass", pass);
        session.setAttribute("confirm_pass", confirm_pass);
        session.setAttribute("otp", otp);

        if (pass.equals(confirm_pass) && !status) { // If passwords match and user does not exist
            return "VerifyEmail";
        } else {
            return "passMissMatch"; // If passwords don't match or user exists
        }
    }


    @PostMapping("/verifyOtp")
    public String verifyOtp(@RequestParam int otp, HttpSession session) {
    	String email = (String) session.getAttribute("email");
        String name = (String) session.getAttribute("name");
        String sur_name = (String) session.getAttribute("sur_name");
        String gender = (String) session.getAttribute("gender");
        long adhar = (long) session.getAttribute("adhar");
        String address = (String) session.getAttribute("address");
        String storedOtp = (String) session.getAttribute("otp");
        String pass = (String) session.getAttribute("pass");
        String confirm_pass = (String) session.getAttribute("confirm_pass");
    	boolean status=userService.LoginUser(email, pass);


if(pass.equals(confirm_pass)) {
        if (email == null || storedOtp == null || status==true) {
            return "verificationFailed";
        }

        if (storedOtp.equals(String.valueOf(otp))) {
        	Users newUser = new Users();
            newUser.setEmail(email);
            newUser.setName(name);
            newUser.setSur_name(sur_name);
            newUser.setAddress(address);
            newUser.setGender(gender);
            newUser.setAdhar(adhar);
            newUser.setPass(pass);
            newUser.setConfirm_pass(confirm_pass);

            userService.addUser(newUser);

            return "verificationSucess";
        } else {
            return "verificationFailed";
        }
    }
else {
	return "index";
    }
}
}
