package com.crudoperation.dao;

import com.crudoperation.model.User;

public interface UserDao {

	public int saveUser(User user);
	
	public User loginUser(String email, String password);
}
