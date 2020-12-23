package com.MySteam.service.impl;

import java.sql.SQLException;

import com.MySteam.dao.userDao;
import com.MySteam.dao.impl.userDaoImpl;
import com.MySteam.domain.User;
import com.MySteam.service.UserService;

public class UserServiceImpl implements UserService{
    userDao userdao=new userDaoImpl();
    
	public User login(String username, String password) {
	    User user=null;
	    	try {
				user=userdao.findUserNameAndPassword(username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return user;
	}

	public boolean register(String username,String password,String role) {
	    boolean flag=false;
	    try {
			if(userdao.findUserName(username)==false){//查找用户名是否重复
				flag=userdao.addInfo(username, password, role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}


}
