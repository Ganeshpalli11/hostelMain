package com.project.SmartStay.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.SmartStay.Repository.usersRepository;
import com.project.SmartStay.Services.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	@GetMapping("/Registration")
	public String Registration() {
		return "Registration";
	}
	@GetMapping("/log")
	public String login() {
		return "Login";
	}
	@GetMapping("/Login")
public String UserLogin(@RequestParam String email,@RequestParam String pass) {
		boolean status=userService.LoginUser(email, pass);
		if(status==true) {
			if(email.equals("palliganesh0242@gmail.com")) {
				
			
	return "LoginSuccess";
			}
			else{
				return "userLoginSuccess";
			}
			
		}
		else {
			return "LoginFailed";
		}
}
}
