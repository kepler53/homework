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

	// ��ǰ������ ��ü �迭�� Ȱ���Ͽ� ����
	public void add(Product p) {
		products.add(p);
	}

	// ��ǰ���� ��ü�� �˻��ϴ� ���
	
	public ArrayList<Product> list() {
		return products;
	}

	// ��ǰ��ȣ�� ��ǰ�� �˻��ϴ� ���
	public Product searchProduct(int num) { // �̺κ� overloading�� �ȵ�
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductNum() == num)
				return products.get(i);
		}
		return null;
	}

	// ��ǰ������ ��ǰ�� �˻��ϴ� ���
	public Product searchProductName(String productName) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductName().equals(productName)) {
				return products.get(i);
			}
		}
		return null;
	}

	// ��ǰ��ȣ�� ��ǰ�� �����ϴ� ���
	public void deleteProduct(int num) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductNum() == num) {
				products.remove(i);
			}
		}
	}

	// ��ǰ Ư����������
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

	// TV������ �˻�
	public ArrayList<TV> TVList() {

		ArrayList<TV> TVresult = new ArrayList<>();
		for (int i = 0; i < products.size(); i++)
			if (products.get(i) instanceof TV) {
				TVresult.add((TV) products.get(i));
				return TVresult;
			}
		return null;
	}

	// Refrigerator�� �˻�
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

	// ��ü ��� ��ǰ �ݾ��� ���ϴ� ���
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < products.size(); i++) {
			total += products.get(i).getPrice() * products.get(i).getEntity();
		}
		return total;
	}


}
