package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsoft.app.model.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
	List<UserLogin> findAll();
	UserLogin findById(long userLoginId);
}
