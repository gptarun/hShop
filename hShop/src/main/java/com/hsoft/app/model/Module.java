package com.hsoft.app.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long moduleId;
	
	@Column(name = "module_name")
	private String moduleName;
}
