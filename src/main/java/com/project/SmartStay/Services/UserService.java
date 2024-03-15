package com.project.SmartStay.Services;

import com.project.SmartStay.entity.Users;

public interface UserService {
public String addUser(Users user);
public boolean LoginUser(String email, String pass);
}
