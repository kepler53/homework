package com.ssafy.product.dto;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDto {
	
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDto(String mname, int mprice, String mdescription) {
		super();
		this.mname = mname;
		this.mprice = mprice;
		this.mdescription = mdescription;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMprice() {
		return mprice;
	}
	public void setMprice(int mprice) {
		this.mprice = mprice;
	}
	public String getMdescription() {
		return mdescription;
	}
	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}
	@Override
	public String toString() {
		return "ProductDto [mname=" + mname + ", mprice=" + mprice + ", mdescription=" + mdescription + "]";
	}
	String mname;
	int mprice;
	String mdescription;

}
