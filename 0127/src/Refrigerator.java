

public class Refrigerator extends Product {

	
	private String brand;
	private int capacity;
	

	//constructor
	public Refrigerator() {
	}

	public Refrigerator(int productNum, String productName, int price, int entity,String brand, int capacity) {
		super(productNum, productName, price, entity);

		this.brand = brand;
		this.capacity = capacity;
	}

	//getter&setters

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return super.toString() +"\t|\t" + "\t|\t" + brand + "\t|\t" + capacity;
	}

}
