package com.BikkadIT.service;

import java.util.List;

import com.BikkadIT.entity.User;

public interface UserServiceI {
	
	public int saveUser(User user);
	
	public boolean loginCheckServiceLauer(User user);
	
	public List<User> getAll();

	public User getSingelUser(int uid);
	
	public List<User> updateUser(User user);
	
	public List<User> deleteUser(int id);
}

