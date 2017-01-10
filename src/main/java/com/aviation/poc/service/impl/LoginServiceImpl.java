package com.aviation.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aviation.poc.entity.Login;
import com.aviation.poc.repository.LoginRepository;
import com.aviation.poc.service.LoginService;



@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public boolean validateLogin(String username, String password) {
		Login userInfo = loginRepository.findByUsername(username);
		System.out.println("in login"+userInfo);
		if (null!=userInfo && userInfo.getPassword().equals(password)) {
			return true;
		}else{
		return false;
		}
	}

}
