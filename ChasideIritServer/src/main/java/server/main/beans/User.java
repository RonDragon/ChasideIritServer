package server.main.beans;

import server.main.enums.UserType;

public class User {
	private int userId;
	private String userName;
	private String userPhone;
	private String password;
	private UserType type;

	
	//const
	public User() {}
	public User(int userId, String userName, String userPhone,UserType type) {
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
	}
	public User( String userName,String password,UserType type) {
		this.userName = userName;
		this.password = password;
		this.type = type;
	}
	public User(int userId, String userPhone,UserType type) {
		this.userId = userId;
		this.userPhone = userPhone;
		this.type = type;
	}
	public User( String userPhone,UserType type) {
		this.userPhone = userPhone;
		this.type = type;
	}
	//get&set
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
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + ", password="
				+ password + ", type=" + type + "]";
	}
	
}
