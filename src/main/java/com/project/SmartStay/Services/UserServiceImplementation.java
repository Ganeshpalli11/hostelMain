package com.project.SmartStay.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SmartStay.Repository.usersRepository;
import com.project.SmartStay.entity.Users;
@Service
public class UserServiceImplementation implements UserService{
@Autowired
usersRepository userRepo;
	@Override
	public String addUser(Users user) {
		userRepo.save(user);
		return "User Added";
	}
	@Override
	public boolean LoginUser(String email, String pass) {
	    try {
	        Users user = userRepo.getByEmail(email);
	        if (user != null && user.getEmail().equals(email) && user.getPass().equals(pass)) {
	            return true;
	        } else {
	            return false;
	        }
	    } catch (Exception e) {
	        // Log the exception or handle it appropriately
	        e.printStackTrace();
	        return false;
	    }
	}


}
