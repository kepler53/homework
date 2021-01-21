package hwjava04_대전_5반_이종현;

public class TV {


	private int productNum =0;
	private String productName ="";
	private int price =0;
	private int inch=0;
	private String type="";
	

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
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public TV() {
		
	}
	
	public TV(int num,String name, int price, int inch, String type) {
		productNum = num;
		productName= name;
		this.price = price;
		this.inch = inch;
		this.type = type;
	}
	
	public String toString() {
		return productNum +"\t"+productName+"\t" + price +"\t"+inch+"\t"+type;
	}
	
	
}
