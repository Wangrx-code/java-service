package com.pj.service.impl;

import com.pj.dao.UserDao;
import com.pj.dao.impl.UserDaoImpl;
import com.pj.entity.User;
import com.pj.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao=new UserDaoImpl();
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Override
	public User regist(User user) {
		// TODO Auto-generated method stub
		return userDao.regist(user);
	}

	@Override
	public User userModify(User user) {
		// TODO Auto-generated method stub
		return userDao.userModify(user);
	}

	@Override
	public User queryByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.queryByName(userName);
	}

}
