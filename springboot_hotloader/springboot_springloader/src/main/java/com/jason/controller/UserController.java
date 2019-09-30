package com.jason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringBoot----SpringLoader
 *
 *
 */
@Controller
public class UserController {
	
	@RequestMapping("/show")
	public String showPage(){
		System.out.println("hi...jason");
		return "index";
	}
}
