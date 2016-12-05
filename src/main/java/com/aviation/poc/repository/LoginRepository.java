package com.aviation.poc.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aviation.poc.entity.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Serializable> {
	
	 public Login findByUsername(final String username);
}
