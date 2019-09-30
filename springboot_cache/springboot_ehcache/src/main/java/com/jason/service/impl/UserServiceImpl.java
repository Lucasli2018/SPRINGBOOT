package com.jason.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jason.dao.UserRepository;
import com.jason.pojo.User;
import com.jason.service.UserService;
/**
 * UsersService接口实现类
 *
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findUserAll() {
		return this.userRepository.findAll();
	}

	@Override
	//@Cacheable:对当前查询的对象做缓存处理
	@Cacheable(value="users")
	public User findUserById(Integer id) {
		return this.userRepository.findOne(id);
	}

	@Override
	public Page<User> findUserByPage(Pageable pageable) {
		return this.userRepository.findAll(pageable);
	}

	@Override
	public void saveUser(User user) {
		this.userRepository.save(user);
	}

}
