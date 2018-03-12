package com.joo.validate;

import java.util.Date;
import java.util.List;

public class UserVo {

	private String userId;
	private String password;
	private String email;
	private List<?> auth;
	private Date createDate;
	
	
	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public List<?> getAuth() {
		return auth;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAuth(List<?> auth) {
		this.auth = auth;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", password=" + password + ", email=" + email + ", auth=" + auth
				+ ", createDate=" + createDate + "]";
	}
	
}
