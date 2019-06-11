package com.hsoft.app.model;

public class JwtResponse {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private String status;

	public JwtResponse(String jwttoken, String status) {
		this.jwttoken = jwttoken;
		this.status = status;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
