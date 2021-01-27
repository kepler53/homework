import java.util.ArrayList;

public class ProductMgr implements IProductMgr {

	private ProductMgr() {
	}

	private static ProductMgr instance;

	public static ProductMgr getInstance() {
		if (instance == null)
			instance = new ProductMgr();
		return instance;
	}

	ArrayList<Product> products = new ArrayList<Product>();

	// 상품정보를 객체 배열을 활용하여 저장
	public void add(Product p) {
		products.add(p);
	}

	// 상품정보 전체를 검색하는 기능
	
	public ArrayList<Product> list() {
		return products;
	}

	// 상품번호로 상품을 검색하는 기능
	public Product searchProduct(int num) { // 이부분 overloading이 안됨
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductNum() == num)
				return products.get(i);
		}
		return null;
	}

	// 상품명으로 상품을 검색하는 기능
	public Product searchProductName(String productName) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductName().equals(productName)) {
				return products.get(i);
			}
		}
		return null;
	}

	// 상품번호로 상품을 삭제하는 기능
	public void deleteProduct(int num) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductNum() == num) {
				products.remove(i);
			}
		}
	}

	// 상품 특정가격이하
	public ArrayList<Product> priceList(int price) {
		ArrayList<Product> result = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getPrice() < price) {
				result.add(products.get(i));
				return result;
			}

		}
		return null;
	}

	// TV정보만 검색
	public ArrayList<TV> TVList() {

		ArrayList<TV> TVresult = new ArrayList<>();
		for (int i = 0; i < products.size(); i++)
			if (products.get(i) instanceof TV) {
				TVresult.add((TV) products.get(i));
				return TVresult;
			}
		return null;
	}

	// Refrigerator만 검색
	public ArrayList<Refrigerator> RefrigeratorList() {
		ArrayList<Refrigerator> result = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Refrigerator) {
				result.add((Refrigerator) products.get(i));
				return result;
			}
			
		}
		return null;
	}

	// 전체 재고 상품 금액을 구하는 기능
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < products.size(); i++) {
			total += products.get(i).getPrice() * products.get(i).getEntity();
		}
		return total;
	}


}
