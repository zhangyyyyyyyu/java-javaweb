package com.MySteam.dao;

import java.sql.SQLException;

import com.MySteam.domain.User;

public interface userDao {
    User findUserNameAndPassword(String username,String password) throws SQLException;
    boolean findUserName(String username) throws SQLException;
    boolean addInfo(String username,String password,String role) throws SQLException;
}
