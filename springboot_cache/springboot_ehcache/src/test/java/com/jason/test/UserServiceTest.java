package com.jason.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jason.App;
import com.jason.service.UserService;

/**
 * UsersService测试
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testFindUserById(){
		//第一次查询
		System.out.println(this.userService.findUserById(1));
		
		//第二次查询
		System.out.println(this.userService.findUserById(1));
	}
}
