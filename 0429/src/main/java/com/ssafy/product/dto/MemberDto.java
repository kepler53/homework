package com.ssafy.product.dto;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDto {
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	String userid;
	@Override
	public String toString() {
		return "MemberDto [userid=" + userid + ", userpass=" + userpass + ", username=" + username + "]";
	}
	String userpass;
	String username;
	
	public MemberDto() {
		
	}
	public MemberDto(String userid, String userpass, String username) {
		this.userid = userid;
		this.userpass = userpass;
		this.username = username;
	}
	

	
	
}
