package com.ssafy.product.dto;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDto {

	
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDto(int pno, String pname, int pprice, String pdescription, List<FileInfoDto> fileInfos) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
		this.pdescription = pdescription;
		this.fileInfos = fileInfos;
	}
	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ", pprice=" + pprice + ", pdescription=" + pdescription
				+ ", fileInfos=" + fileInfos + "]";
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public List<FileInfoDto> getFileInfos() {
		return fileInfos;
	}
	public void setFileInfos(List<FileInfoDto> fileInfos) {
		this.fileInfos = fileInfos;
	}
	private int pno;
	private String pname;
	private int pprice;
	private String pdescription;
	private List<FileInfoDto> fileInfos;
	
	
}
