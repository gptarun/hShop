package com.hsoft.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hsoft.app.model.User;
import com.hsoft.app.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepo;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		List<User> userObj = userRepo.findByUserName(userName);

		if (userObj == null) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		} else {
			return new org.springframework.security.core.userdetails.User(userObj.get(0).getUserName(),
					userObj.get(0).getPassword(), new ArrayList<>());
		}

		/*
		 * if ("javainuse".equals(username)) { return new User("javainuse",
		 * "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new
		 * ArrayList<>()); } else { throw new
		 * UsernameNotFoundException("User not found with username: " + username); }
		 */
	}
}
