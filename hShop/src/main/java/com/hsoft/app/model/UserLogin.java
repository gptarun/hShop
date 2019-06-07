package com.hsoft.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.apache.tomcat.jni.Address;

public class UserLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userLoginId;
	
	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	@NotBlank
	private String password;
	
	

}
