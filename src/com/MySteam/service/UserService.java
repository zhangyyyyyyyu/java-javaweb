package com.MySteam.service;

import com.MySteam.domain.User;

public interface UserService {
	User login(String username, String password);
	boolean register(String username,String password,String role);
}
