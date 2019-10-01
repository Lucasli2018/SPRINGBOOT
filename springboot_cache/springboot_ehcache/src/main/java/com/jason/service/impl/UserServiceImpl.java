package com.jason.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jason.dao.UserRepository;
import com.jason.pojo.User;
import com.jason.service.UserService;
/**
 * UsersService接口实现类
 *
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Cacheable(value="users")
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
	@Cacheable(value="users",key="#pageable.pageSize")
	public Page<User> findUserByPage(Pageable pageable) {
		return this.userRepository.findAll(pageable);
	}

	@Override
	//@CacheEvict(value="users",allEntries=true) 清除缓存中以users缓存策略缓存的对象
	@CacheEvict(value="users",allEntries=true)
	public void saveUser(User user) {
		this.userRepository.save(user);
	}

}
