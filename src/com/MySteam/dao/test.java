package com.MySteam.dao;

import java.sql.SQLException;

import com.MySteam.dao.impl.userDaoImpl;

public class test {
    public static void main(String args[]){
    	userDao d=new userDaoImpl();
    	try {
			System.out.println(d.findUserNameAndPassword("zs", "123"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
