import java.util.ArrayList;

public interface IProductMgr {

	public void add(Product p)throws DuplicateException;
	public ArrayList<Product> list();
	public Product searchProduct(int num) throws CodeNotFoundException ;
	public Product searchProductName(String productName);
	public void deleteProduct(int num);
	public ArrayList<Product> priceList(int price);
	public ArrayList<TV> TVList();
	public ArrayList<Refrigerator> RefrigeratorList();
	public ArrayList<TV> TVPriceList() throws ProductNotFoundException;
	public ArrayList<Refrigerator> RefrigeratorCapacityList() throws ProductNotFoundException;
	
}
