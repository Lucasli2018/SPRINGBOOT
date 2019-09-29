package com.jason.service;

import java.util.List;

import com.jason.pojo.User;

public interface UserService {
void insertUser(User user);
	
	List<User> selectUserAll();
	
	User selectUserById(Integer id);
	
	void updateUser(User user);
	
	void deleteUserById(Integer id);
}
