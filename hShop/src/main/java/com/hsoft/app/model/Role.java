package com.hsoft.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roleId;
	
	@Column(name = "role")
	private String role;
	
	private Set<Module> modules;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "ROLE_MODULE",
	        joinColumns = @JoinColumn(name = "ROLE_ID"),
	        inverseJoinColumns = @JoinColumn(name = "MODULE_ID")
	)
	public Set<Module> getModules() {
	    return modules;
	}
	
}
