package com.MySteam.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MySteam.dao.userDao;
import com.MySteam.domain.User;
import com.MySteam.util.DBUtil;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;


public class userDaoImpl implements userDao{

	public User findUserNameAndPassword(String username, String password) throws SQLException {
		User user=null;
		Connection con=DBUtil.getConnection();//1.获取连接
		String sql="select * from users where username=? and password=?";//2.对sql语句进行预处理
		PreparedStatement pst=(PreparedStatement) ((java.sql.Connection) con).prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, password);
		ResultSet rs=pst.executeQuery();//3.执行更新操作
		if(rs.next()){
			user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
		}
		DBUtil.release(rs,pst,con);
		return user;
	}

	public boolean findUserName(String username) throws SQLException {
		boolean flag=false;
		Connection con= DBUtil.getConnection();
		String sql="select * from users where username=?";
		PreparedStatement pst=(PreparedStatement) ((java.sql.Connection) con).prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			flag=true;
		}
		DBUtil.release(rs, pst, con);
		return flag;
	}

	public boolean addInfo(String username, String password,String role) throws SQLException {
		Connection con =  DBUtil.getConnection();
		String sql = "insert into users values(null,?,?,?)";
		PreparedStatement pst =(PreparedStatement) ((java.sql.Connection) con).prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, password);
		pst.setString(3, role);
		int num = pst.executeUpdate();
		DBUtil.release(pst, con);
		return num>=1;
	}
    
}
