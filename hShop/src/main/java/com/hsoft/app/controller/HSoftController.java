package com.hsoft.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsoft.app.model.UserModel;
import com.hsoft.app.repository.UserRepository;

@RestController
public class HSoftController {

	@Autowired
	UserRepository userRepo;

	@GetMapping("/id")
	public String getTestId() {
		return "id";
	}

	@PostMapping("/create")
	public String createUser(@RequestBody UserModel user) {
		userRepo.save(new UserModel(user.getId(), user.getPassword()));
		return "Created";
	}
}
