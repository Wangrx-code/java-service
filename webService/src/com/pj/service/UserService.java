package com.pj.service;

import com.pj.entity.User;

public interface UserService {
	public User regist(User user);
	public User login(User user);
	public User userModify(User user);
	public User queryByName(String userName);
}
