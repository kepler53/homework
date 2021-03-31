package model;

public class ProductDTO {
	
	//DB에서 하나의 ENTITY가 되는 클래스
	@Override
	public String toString() {
		return "ProductDTO [ID=" + ID + ", productName=" + productName + ", entity=" + entity + ", manufacture="
				+ manufacture + ", price=" + price + "]";
	}

	String ID;
	String productName;
	int entity;
	String manufacture;
	int price;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getEntity() {
		return entity;
	}
	public void setEntity(int entity) {
		this.entity = entity;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(String iD, String productName, int entity, String manufacture, int price) {
		super();
		ID = iD;
		this.productName = productName;
		this.entity = entity;
		this.manufacture = manufacture;
		this.price = price;
	}

}
