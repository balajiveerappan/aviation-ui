package com.aviation.poc.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aviation.poc.service.LoginService;

@Controller
public class AviationLoginController {

	@Autowired
	private LoginService loginService;
		
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginView(@RequestParam("username") String username,@RequestParam("password") String password, HttpServletResponse response) {
		boolean loginValidRes =  loginService.validateLogin(username, password);
		if(loginValidRes){
			return "dashboard";
		}else{
			return "login";
		}
		
	}
	@RequestMapping(value="/login/redirect", method=RequestMethod.GET)
	public String redirect(){
		return "login";
	}
}
