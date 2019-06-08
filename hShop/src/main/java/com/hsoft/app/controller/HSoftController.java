package com.hsoft.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsoft.app.model.Module;
import com.hsoft.app.model.Role;
import com.hsoft.app.model.User;
import com.hsoft.app.repository.ModuleRepository;
import com.hsoft.app.repository.RoleRepository;
import com.hsoft.app.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HSoftController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private ModuleRepository moduleRepo;

	@GetMapping("/id")
	public String getTestId() {
		return "id";
	}

	/**
	 * All the create requests will start from here..
	 * 
	 * @param user
	 * @return
	 */

	@PostMapping("/createUser")
	public String createUser(@RequestBody User user) {
		userRepo.save(user);
		return "Created User";
	}

	@PostMapping("/createRole")
	public String createRole(@RequestBody Role role) {
		roleRepo.save(role);
		return "Created role";
	}

	@PostMapping("/createModule")
	public String createModule(@RequestBody Module module) {
		moduleRepo.save(module);
		return "Created module";
	}

	/**
	 * All the get requests will start from here..
	 * 
	 * @return
	 */
	@GetMapping("/getUsers")
	public List<User> getUser() {
		return userRepo.findAll();
	}

	@GetMapping("/getRoles")
	public List<Role> getRole() {
		return roleRepo.findAll();
	}

	@GetMapping("/getModules")
	public List<Module> getModule() {
		return moduleRepo.findAll();
	}

}
