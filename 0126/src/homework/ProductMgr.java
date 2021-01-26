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

	// ��ǰ������ ��ü �迭�� Ȱ���Ͽ� ����
	public void add(Product p) {
		products[count] = p;
		count++;
	}

	// ��ǰ���� ��ü�� �˻��ϴ� ���
	public Product[] list() {
		Product[] result = new Product[count];

		for (int i = 0; i < count; i++) {
			result[i] = products[i];
		}
		return result;
	}

	// ��ǰ��ȣ�� ��ǰ�� �˻��ϴ� ���
	public Product searchProduct(int num) { // �̺κ� overloading�� �ȵ�
		for (int i = 0; i < count; i++) {
			if (products[i].getProductNum() == num) {
				return products[i];
			}
		}
		return null;
	}

	// ��ǰ������ ��ǰ�� �˻��ϴ� ���
	public Product searchProductName(String productName) {
		for (int i = 0; i < count; i++) {
			if (products[i].getProductName().equals(productName)) {
				return products[i];
			}
		}
		return null;
	}

	// ��ǰ��ȣ�� ��ǰ�� �����ϴ� ���
	public void deleteProduct(int num) {
		for (int i = 0; i < count; i++) {
			if ((products[i].getProductNum() == num)) {
				products[i] = products[count - 1];
				products[count - 1] = null;
				count--;
			}
		}
	}

	// ��ǰ Ư����������
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

	// TV������ �˻�
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

	// Refrigerator�� �˻�
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

	// ��ü ��� ��ǰ �ݾ��� ���ϴ� ���
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < count; ++i) {
			total += products[i].getPrice();
		}
		return total;
	}

}
