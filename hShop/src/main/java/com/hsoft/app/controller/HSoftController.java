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

	@PostMapping("/create")
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

	@GetMapping("/getRole")
	public List getRole() {
		List<Role> roles = roleRepo.findAll();
		List<Object> roleList = new ArrayList<>();
		for (Role roleObject : roles) {
			roleList.add(roleObject);
		}

		return roleList;
	}

}
