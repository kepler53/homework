package homework;

public class TV extends Product {
	

	private String brand;
	private int year;
	
	//constructor
	public TV() {}
	
	public TV(int productNum, String productName, int price, int entity,String brand, int year) {
		super(productNum, productName, price, entity);
		this.brand = brand;
		this.year = year;
	}
	//getter&setter

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return super.toString()  +"\t|\t" + brand + "\t|\t" + year;
	}

	
	
	
}
