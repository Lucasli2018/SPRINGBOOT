package com.jason.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jason.pojo.User;

public interface UserService {
	List<User> findUserAll();
	User findUserById(Integer id);
	Page<User> findUserByPage(Pageable pageable);
	void saveUser(User user);
}
