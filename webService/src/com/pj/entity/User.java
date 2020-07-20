package com.pj.entity;

public class User {
	private int userId;
	private String userName;
	private String userPassword;
	private String uerType;
	private String userLocation;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUerType() {
		return uerType;
	}
	public void setUerType(String uerType) {
		this.uerType = uerType;
	}
	public String getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}
	
	public User() {
		super();
	}
	
	public User(String userName) {
		super();
		this.userName = userName;
	}
	public User(String userName, String userPassword, String uerType) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.uerType = uerType;
	}
	public User(String userName, String userPassword, String uerType,
			String userLocation) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.uerType = uerType;
		this.userLocation = userLocation;
	}
	
	public User(int userId, String userName, String userPassword,
			String uerType, String userLocation) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.uerType = uerType;
		this.userLocation = userLocation;
	}
	@Override
	public String toString() {
		return "User [userLocation=" + userLocation + ", uerType=" + uerType
				+ ", userId=" + userId + ", userName=" + userName
				+ ", userPassword=" + userPassword + "]";
	}
	
}
