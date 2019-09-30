package com.jason.dao.impl;

import org.springframework.stereotype.Repository;

import com.jason.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public void saveUser() {
		System.out.println("save user ...");
	}

}
