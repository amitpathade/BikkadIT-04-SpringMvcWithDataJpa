package com.BikkadIT.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.dao.UserDaoI;
import com.BikkadIT.entity.User;

@Service
public class UserServiceImpl implements UserServiceI {
	
@Autowired
private UserDaoI UserDaoI;

@Override
public int saveUser(User user) {
	System.out.println("service layer method");
	System.out.println(user);
	int id=UserDaoI.saveUserToDb(user);
	return id;
}

@Override
public boolean loginCheckServiceLauer(User user) {
	
	
	List<User> allData = UserDaoI.getAllData();
	
	for(User user1:allData) {
		if(user.getUname().equals(user1.getUname()) && user.getPassward().equals(user1.getPassward())) {
			
			return true;
			
		}
		
	}
	
	
	
	return false;
}

@Override
public List<User> getAll() {
   List<User> list = UserDaoI.getAllDataFromDB();
	return list;
}

@Override
public User getSingelUser(int uid) {
	User single = UserDaoI.getSingle(uid);
 
	return single ;
}

@Override
public List<User> updateUser(User user) {
	List<User> updatUser = UserDaoI.updatUser(user);
	return updatUser;
}


@Override
public List<User> deleteUser(int id) {
	List<User> list = UserDaoI.deleteUserById(id);
	return list;
}

}
