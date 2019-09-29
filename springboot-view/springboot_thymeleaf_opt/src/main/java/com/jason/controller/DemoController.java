package com.jason.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason.pojo.User;

/**
 * Thymeleaf入门案例
 *
 *
 */
@Controller
public class DemoController {
	@RequestMapping("/string")
	public String showInfo(Model model){
		model.addAttribute("msg", "Thymeleaf 第一个案例");
		model.addAttribute("key", new Date());
		return "string";
	}
	
	@RequestMapping("/if")
	public String showInfo2(Model model){
		model.addAttribute("sex", "女");
		model.addAttribute("id","1");
		return "if";
	}
	@RequestMapping("/list")
	public String showInfo3(Model model){
		List<User> list = new ArrayList<>();
		list.add(new User(1,"张三",20));
		list.add(new User(2,"李四",22));
		list.add(new User(3,"王五",24));
		model.addAttribute("list", list);
		
		List<User> list2 = new ArrayList<>();
		list.add(new User(5,"jason",20));
		model.addAttribute("list2", list2);
		return "list";
	}
	
	@RequestMapping("/map")
	public String showInfo4(Model model){
		Map<String, User> map = new HashMap<>();
		map.put("u1", new User(1,"张三",20));
		map.put("u2", new User(2,"李四",22));
		map.put("u3", new User(3,"王五",24));
		map.put("u1", new User(1,"jason",20));
		model.addAttribute("map", map);
		
		return "map";
	}
	
	//获取对象作用域
	@RequestMapping("/show5")
	public String showInfo5(HttpServletRequest request,Model model){
		request.setAttribute("req", "HttpServletRequest");
		request.getSession().setAttribute("sess", "HttpSession");
		request.getSession().getServletContext().setAttribute("app", "Application");
		
		request.setAttribute("request", "${#httpServletRequest.getAttribute('requst')}");
		request.getSession().setAttribute("session1", "${session.session1}");
		request.getSession().getServletContext().setAttribute("application1", "${application.application1}");
		return "index5";
	}
	
	//URL表达式
	@RequestMapping("/{page}")
	public String showInfo(@PathVariable String page,Integer id,String name){
		System.out.println(id+"--"+name);
		return page;
	}
	//URL表达式-RESTful
	@RequestMapping("/{page}/{id}/{name}")
	public String showInfo2(@PathVariable String page,@PathVariable Integer id,@PathVariable String name){
		System.out.println(id+"--"+name);
		return page;
	}
}
