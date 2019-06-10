package com.hsoft.app.bean;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hsoft.app.model.Module;
import com.hsoft.app.model.Role;

public class RoleModule {
	
	private Role role;
	private List<Long> moduleIds;
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Long> getModuleIds() {
		return moduleIds;
	}
	public void setModuleIds(List<Long> moduleIds) {
		this.moduleIds = moduleIds;
	}
	
}
