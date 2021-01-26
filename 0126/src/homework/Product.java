package homework;

public class Product {

	

	private int productNum;
	private String productName;
	private int price;
	private int entity;
	
	public Product() {
		
	}
	
	public Product(int productNum, String productName, int price, int entity) {
		super();
		this.productNum = productNum;
		this.productName = productName;
		this.price = price;
		this.entity = entity;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getEntity() {
		return entity;
	}

	public void setEntity(int entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		return productNum + "\t|\t" + productName + "\t|\t" + price + "\t|\t" + entity;
	}

}
