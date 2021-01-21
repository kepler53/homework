package hwjava04_대전_5반_이종현;

public class Refrigerator {
	
	private int productNum =0;
	private String productName ="";
	private int price = 0;
	private int count =0;
	private int capacity = 0;


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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void Refrigerator() {
		
	}
	public void Refrigerator(int num,String name, int price, int count, int capacity) {
		productNum = num;
		name = name;
		this.price = price;
		this.count = count;
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return "Refrigerator [productNum=" + productNum + ", productName=" + productName + ", price=" + price
				+ ", count=" + count + ", capacity=" + capacity + "]";
	}
	
	
}
