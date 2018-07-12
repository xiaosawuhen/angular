package com.lxzl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@PostMapping
	public String login() {
		
		System.out.println("login");
		return "login.html";
	}
}
