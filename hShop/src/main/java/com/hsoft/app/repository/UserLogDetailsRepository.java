package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.UserLoginDetails;

public interface UserLogDetailsRepository extends JpaRepository<UserLoginDetails, Long>  {
	
	
}
