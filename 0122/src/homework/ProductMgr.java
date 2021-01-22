package homework;

public class ProductMgr {

	private ProductMgr() {
	}

	private static ProductMgr instance;

	public static ProductMgr getInstance() {
		if (instance == null)
			instance = new ProductMgr();
		return instance;
	}

	public static final int MAX_SIZE = 100;
	private Product[] products = new Product[MAX_SIZE];
	private int count = 0;

	public void add(Product p) {
		products[count] = p;
		count++;
	}

	public Product[] list() {
		Product[] result = new Product[count];

		for (int i = 0; i < count; i++) {
			result[i] = products[i];
		}
		return result;
	}

	public Product searchProduct(int num) { // 이부분 overloading이 안됨
		for (int i = 0; i < count; i++) {
			if (products[i].getProductNum()==num) {
				return products[i];
			}
		}
		return null;
	}

	public void deleteProduct(int num) {
		for (int i = 0; i < count; i++) {
			if ((products[i].getProductNum()==num)){
				products[i] = products[count - 1];
				products[count - 1] = null;
				count--;
			}
		}
	}
	
	public Product[] priceList(int price) {
		Product[] result = new Product[count];
		int k= 0;
		for(int i=0;i<count;i++) {
			if(products[i].getPrice()<price) {
				result[k] = products[i];
				k++;
				return result;
			}
		}
		return null;
	}

}
