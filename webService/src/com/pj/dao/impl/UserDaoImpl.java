package com.pj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pj.dao.UserDao;
import com.pj.entity.Goods;
import com.pj.entity.User;
import com.pj.util.C3P0Util;

public class UserDaoImpl implements UserDao{

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User userResult=null;
		try {
			Connection connection=C3P0Util.getConnection();
			String sql="select user_id,user_name,user_password,user_type,user_location from user where user_name=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				userResult=new User();
				userResult.setUserId(rs.getInt("user_id"));
				userResult.setUserName(rs.getString("user_name"));
				userResult.setUserPassword(rs.getString("user_password"));
				userResult.setUerType(rs.getString("user_type"));
				userResult.setUserLocation(rs.getString("user_location"));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userResult;
	}

	@Override
	public User regist(User user) {
		// TODO Auto-generated method stub
		try {
			Connection connection=C3P0Util.getConnection();
			String sql="insert into user (user_name,user_password,user_type,user_location,create_time)values(?,?,?,?,now())";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUerType());
			ps.setString(4, user.getUserLocation());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User userModify(User user) {
		// TODO Auto-generated method stub
		Connection connection;
		try {
			connection = C3P0Util.getConnection();
			String sql="update user set user_password=?,user_type=?,user_location=? where user_name=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1,user.getUserPassword());
			ps.setString(2, user.getUerType());
			ps.setString(3, user.getUserLocation());
			ps.setString(4, user.getUserName());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User queryByName(String userName) {
		// TODO Auto-generated method stub
		User userResult=null;
		try {
			Connection connection = C3P0Util.getConnection();
			String sql="select user_id from user where user_name=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, userName);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				userResult=new User();
				userResult.setUserId(rs.getInt("user_id"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userResult;
	}

}
