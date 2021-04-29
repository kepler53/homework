package com.ssafy.product.dto;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDto {

	private String name;
	private int price;
	private String descript;
	
	
	public ProductDto() {
		
	}
	
	
	public ProductDto(String name, int price, String descript) {

		this.name = name;
		this.price = price;
		this.descript = descript;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@Override
	public String toString() {
		return "ProductDto [name=" + name + ", price=" + price + ", descript=" + descript + "]";
	}
	
	
	
}
