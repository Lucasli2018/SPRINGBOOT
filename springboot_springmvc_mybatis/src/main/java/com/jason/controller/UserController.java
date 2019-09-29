package com.jason.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason.pojo.User;
import com.jason.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	/**
	 * 添加用户
	 */
	@RequestMapping("/addUser")
	public String addUser(User user){
		this.userService.insertUser(user);
		return "ok";
	}
	
	/**
	 * 查询全部用户
	 */
	@RequestMapping("/findUserAll")
	public String findUserAll(Model model){
		List<User> list = this.userService.selectUserAll();
		model.addAttribute("list", list);
		System.out.println(list);
		return "showUsers";
	}
	
	/**
	 * 根据用户id查询用户
	 */
	@RequestMapping("/findUserById")
	public String findUserById(Integer id,Model model){
		User user=this.userService.selectUserById(id);
		model.addAttribute("user", user);
		System.out.println(user);
		return "updateUser";
	}
	
	/**
	 * 更新用户
	 */
	@RequestMapping("/editUser")
	public String editUser(User user){
		System.out.println("editUser:"+user);
		this.userService.updateUser(user);
		return "ok";
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping("/delUser")
	public String delUser(Integer id){
		System.out.println("delUser:"+id);
		this.userService.deleteUserById(id);
		return "redirect:/user/findUserAll";
	}
	
}
