package com.jason.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason.pojo.User;
/**
 * SpringBoot服务端校验
 *
 *
 */
@Controller
public class UserController {
	
	/**
	 * 
	 * 如果想为传递的对象更改名称，可以使用@ModelAttribute("aa")这表示当前传递的对象的key为aa。
	 * 那么我们在页面中获取该对象的key也需要修改为aa
	 * @param users
	 * @return
	 */
	@RequestMapping("/addUser")
	public String showPage(@ModelAttribute User user){
		return "add";
	}
	/**
	 * 完成用户添加
	 *@Valid 开启对Users对象的数据校验
	 *BindingResult:封装了校验的结果
	 */
	@RequestMapping("/save")
	public String saveUser(@ModelAttribute @Valid User user,BindingResult result){
		if(result.hasErrors()){
			return "add";
		}
		System.out.println(user);
		return "ok";
	}
	
	@RequestMapping("/showUsers")
	public String showUser(){
		String str = null;
		str.length();
		return "index";
	}
	
	@RequestMapping("/showUsers2")
	public String showUser2(){
		int a = 100/0;
		return "index";
	}
	
}
