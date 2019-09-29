package com.jason.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jason.mapper.UserMapper;
import com.jason.pojo.User;
import com.jason.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void insertUser(User user) {
		this.userMapper.insertUser(user);
	}

	@Override
	public List<User> selectUserAll() {
		return this.userMapper.selectUserAll();
	}

	@Override
	public User selectUserById(Integer id) {
		return this.userMapper.selectUserById(id);
	}

	@Override
	public void updateUser(User user) {
		this.userMapper.updateUser(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		this.userMapper.deleteUserById(id);
	}

}
