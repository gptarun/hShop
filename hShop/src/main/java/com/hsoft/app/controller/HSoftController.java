package com.hsoft.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsoft.app.bean.RoleModule;
import com.hsoft.app.constant.HShopConstant;
import com.hsoft.app.model.Department;
import com.hsoft.app.model.Location;
import com.hsoft.app.model.Module;
import com.hsoft.app.model.ParentModule;
import com.hsoft.app.model.Role;
import com.hsoft.app.model.RoleModuleTab;
import com.hsoft.app.model.TransactionLog;
import com.hsoft.app.model.User;
import com.hsoft.app.repository.DepartmentRepository;
import com.hsoft.app.repository.LocationRepository;
import com.hsoft.app.repository.ModuleRepository;
import com.hsoft.app.repository.ParentModuleRepository;
import com.hsoft.app.repository.RoleModuleRepository;
import com.hsoft.app.repository.RoleRepository;
import com.hsoft.app.repository.TransactionLogRepository;
import com.hsoft.app.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HSoftController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private ModuleRepository moduleRepo;

	@Autowired
	private DepartmentRepository depRepo;

	@Autowired
	private ParentModuleRepository pmRepo;

	@Autowired
	private RoleModuleRepository roleModuleRepo;

	@Autowired
	private PasswordEncoder bcryptEncode;

	@Autowired
	private LocationRepository locationRepo;

	@Autowired
	private TransactionLogRepository transactionLogRepo;

	@GetMapping("/id")
	public String getTestId() {
		return "id";
	}

	/**
	 * All the create requests will start from here.....
	 * 
	 * @param user
	 * @return
	 */

	@PostMapping("/createUser")
	public Map<String, String> createUser(@RequestBody User user) {
		Map<String, String> response = new HashMap<>();
		try {
			user.setPassword(bcryptEncode.encode(user.getPassword()));
			userRepo.save(user);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "User has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/createRole")
	public Map<String, String> createRole(@RequestBody Role role) {
		Map<String, String> response = new HashMap<>();
		try {
			roleRepo.save(role);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Role has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/createModule")
	public Map<String, String> createModule(@RequestBody Module module) {
		Map<String, String> response = new HashMap<>();
		try {
			moduleRepo.save(module);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Module has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/createRoleModMap")
	public Map<String, String> createRoleModMap(@RequestBody RoleModule roleModule) {
		Map<String, String> response = new HashMap<>();
		try {
			long roleId = roleModule.getRole().getRoleId();
			for (long moduleId : roleModule.getModuleIds()) {
				roleModuleRepo.save(new RoleModuleTab(roleId, moduleId));
			}
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Mapping of Role and Module has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/createDep")
	public Map<String, String> createDep(@RequestBody Department dep) {
		Map<String, String> response = new HashMap<>();
		try {
			depRepo.save(dep);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Department has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/createPM")
	public Map<String, String> createParentModule(@RequestBody ParentModule pm) {
		Map<String, String> response = new HashMap<>();
		try {
			pmRepo.save(pm);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Department has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/createLocation")
	public Map<String, String> createLocation(@RequestBody Location location) {
		Map<String, String> response = new HashMap<>();
		try {
			locationRepo.save(location);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Location has been added");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/createUserLog")
	public Map<String, String> createLog(@RequestBody TransactionLog transactionLog) {
		Map<String, String> response = new HashMap<>();
		try {
			transactionLogRepo.save(transactionLog);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Logs has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	/**
	 * All the GET requests will start from here..
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

	@GetMapping("/getPModules")
	public List<ParentModule> getPModule() {
		return pmRepo.findAll();
	}

	@GetMapping("/getDepartments")
	public List<Department> getDepartments() {
		return depRepo.findAll();
	}

	@GetMapping("/getLocations")
	public List<Location> getLocations() {
		return locationRepo.findAll();
	}

	@PostMapping("/getUser")
	public Map<String, Object> getUserByName(@RequestBody User user) {
		Map<String, Object> response = new HashMap<>();
		try {
			List<User> userByName = userRepo.findByUserName(user.getUserName());
			List<RoleModuleTab> roleModuleId = roleModuleRepo
					.findModuleIdByRoleId(userByName.get(0).getRole().getRoleId());
			List<String> modules = new ArrayList<>();

			for (RoleModuleTab roleModuleTab : roleModuleId) {
				modules.add(moduleRepo.findById(roleModuleTab.getModuleId()).get(0).getModuleName());
			}

			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "User found");
			response.put(HShopConstant.DATA, userByName.get(0));
			response.put(HShopConstant.MODULE, modules);
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	/**
	 * Update queries from here......
	 */

	@PostMapping("/changePassword")
	public Map<String, String> changePassword(@RequestBody User userObj) {
		Map<String, String> response = new HashMap<>();
		try {
			List<User> user = userRepo.findByUserName(userObj.getUserName());
			user.get(0).setPassword(bcryptEncode.encode(userObj.getPassword()));
			userRepo.save(user.get(0));
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Password has been changed successfully");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@DeleteMapping("/deleteUsers")
	public Map<String, String> deleteUser(@RequestBody List<User> userObj) {
		Map<String, String> response = new HashMap<>();
		try {
			for (User user : userObj) {
				userRepo.deleteById(user.getUserId());
			}
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "User has been deleted successfully");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

}
