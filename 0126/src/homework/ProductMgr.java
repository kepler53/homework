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

	// 상품정보를 객체 배열을 활용하여 저장
	public void add(Product p) {
		products[count] = p;
		count++;
	}

	// 상품정보 전체를 검색하는 기능
	public Product[] list() {
		Product[] result = new Product[count];

		for (int i = 0; i < count; i++) {
			result[i] = products[i];
		}
		return result;
	}

	// 상품번호로 상품을 검색하는 기능
	public Product searchProduct(int num) { // 이부분 overloading이 안됨
		for (int i = 0; i < count; i++) {
			if (products[i].getProductNum() == num) {
				return products[i];
			}
		}
		return null;
	}

	// 상품명으로 상품을 검색하는 기능
	public Product searchProductName(String productName) {
		for (int i = 0; i < count; i++) {
			if (products[i].getProductName().equals(productName)) {
				return products[i];
			}
		}
		return null;
	}

	// 상품번호로 상품을 삭제하는 기능
	public void deleteProduct(int num) {
		for (int i = 0; i < count; i++) {
			if ((products[i].getProductNum() == num)) {
				products[i] = products[count - 1];
				products[count - 1] = null;
				count--;
			}
		}
	}

	// 상품 특정가격이하
	public Product[] priceList(int price) {
		Product[] result = new Product[count];
		int k = 0;
		for (int i = 0; i < count; i++) {
			if (products[i].getPrice() < price) {
				result[k] = products[i];
				k++;
				return result;
			}
		}
		return null;
	}

	// TV정보만 검색
	public TV[] TVList() {
		int tv_count = 0;
		
		for (int i = 0; i < count; i++)
			if (products[i] instanceof TV)
				++tv_count;
		
		TV[] result = new TV[tv_count];
		int k=0;
		for (int j = 0; j < count; j++) {
			if (products[j] instanceof TV)
				result[k++] = (TV)products[j];

		}
		return result;
	}

	// Refrigerator만 검색
	public Refrigerator[] RefrigeratorList() {
		int ref_count = 0;
		
		for (int i = 0; i < count; i++)
			if (products[i] instanceof Refrigerator)
				ref_count++;
		
		Refrigerator[] result = new Refrigerator[ref_count];
		
		int j = 0;
		for (int k = 0; k < count; k++) {
			if (products[k] instanceof Refrigerator)
				result[j] = (Refrigerator)products[k];
		}
		return result;
	}

	// 전체 재고 상품 금액을 구하는 기능
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < count; ++i) {
			total += products[i].getPrice();
		}
		return total;
	}

}
