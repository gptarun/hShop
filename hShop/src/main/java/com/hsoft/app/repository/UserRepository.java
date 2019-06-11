package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsoft.app.model.User;
import java.lang.String;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAll();
	User findById(long userId);
	List<User> findByUserName(String username);
}
