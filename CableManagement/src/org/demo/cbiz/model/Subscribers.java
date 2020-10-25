package org.demo.cbiz.model;

import java.util.Date;

public class Subscribers {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date activatedOn;
	private Date deactivatedOn;
	private boolean active;
	private String userType;

	
	public Subscribers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subscribers(String firstName, String lastName, String email, String password, Date activatedOn,
			Date deactivatedOn, boolean active, String userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.activatedOn = activatedOn;
		this.deactivatedOn = deactivatedOn;
		this.active = active;
		this.userType = userType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public Date getActivatedOn() {
		return activatedOn;
	}
	public void setActivatedOn(Date activatedOn) {
		this.activatedOn = activatedOn;
	}
	public Date getDeactivatedOn() {
		return deactivatedOn;
	}
	public void setDeactivatedOn(Date deactivatedOn) {
		this.deactivatedOn = deactivatedOn;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
