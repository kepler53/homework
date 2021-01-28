

public class TV extends Product {
	

	private String brand;
	private int inch;
	
	//constructor
	public TV() {}
	
	public TV(int productNum, String productName, int price, int entity,String brand, int inch) {
		super(productNum, productName, price, entity);
		this.brand = brand;
		this.inch = inch;
	}
	//getter&setter

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	@Override
	public String toString() {
		return super.toString()  +"\t|\t" + brand + "\t|\t" + inch;
	}

	
	
	
}
