package com.dto;

public class UserDto {

	private String email;
	private String fullname;
	private String password;
	private int role_id;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDto(String email, String fullname, String password, int role_id) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.role_id = role_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	
}
