import java.util.ArrayList;

public interface IProductMgr {

	public void add(Product p);
	public ArrayList<Product> list();
	public Product searchProduct(int num);
	public Product searchProductName(String productName);
	public void deleteProduct(int num);
	public ArrayList<Product> priceList(int price);
	public ArrayList<TV> TVList();
	public ArrayList<Refrigerator> RefrigeratorList();
	
}
