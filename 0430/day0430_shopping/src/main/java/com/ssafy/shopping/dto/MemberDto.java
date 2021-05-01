package com.ssafy.shopping.dto;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDto {

	
	String id;
	String pwd;
	String name;
	String address;
		
	public MemberDto() {
	}
	public MemberDto(String id, String pwd, String name, String address) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
