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

	@Override
	public boolean validateLogin(String username, String password) {
		Login userInfo = loginRepository.findByUsername(username);
		if (userInfo.getPassword().equals(password)) {
			return true;
		}else{
		return false;
		}
	}

}
