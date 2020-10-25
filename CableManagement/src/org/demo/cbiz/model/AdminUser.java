package org.demo.cbiz.model;

public class AdminUser {

	private Long id;
	private String name;
	private String email;
	private String password;
	private boolean isActive;
	
	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdminUser(String name, String email, String password, boolean isActive) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
