package com.ssafy.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductMgr implements IProductMgr, Runnable {

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
	public void add(Product p) throws DuplicateException {

		products.add(p);

		for (int i = 0; i < products.size() - 1; i++) {
			if (products.get(i).getProductNum() == p.getProductNum()) {
				products.remove(p);
				int count = products.get(i).getEntity();
				count += p.getProductNum();
				throw new DuplicateException();
			}
		}

	}

	// 상품정보 전체를 검색하는 기능

	public ArrayList<Product> list() {
		return products;
	}

	// 상품번호로 상품을 검색하는 기능
	public Product searchProduct(int num) throws CodeNotFoundException { // 이부분 overloading이 안됨
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductNum() == num)
				return products.get(i);
			else
				throw new CodeNotFoundException();
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

	// 50inch 이상 tv 출력
	@Override
	public ArrayList<TV> TVPriceList() throws ProductNotFoundException {

		ArrayList<TV> TVresult = new ArrayList<>();
		for (int i = 0; i < products.size(); i++)
			if (products.get(i) instanceof TV && ((TV) products.get(i)).getInch() > 50) {
				TVresult.add((TV) products.get(i));
				return TVresult;
			} else {
				throw new ProductNotFoundException();
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

	// 400L 이상 냉장고
	@Override
	public ArrayList<Refrigerator> RefrigeratorCapacityList() throws ProductNotFoundException {
		ArrayList<Refrigerator> result = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Refrigerator && ((Refrigerator) products.get(i)).getCapacity() > 400) {
				result.add((Refrigerator) products.get(i));
				return result;
			} else {
				throw new ProductNotFoundException();
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

	public void loadData() {
		File f = new File("product.dat");
		if (f.exists()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
				products = (ArrayList<Product>) in.readObject(); // 도서리스트 객체를 파일에서 읽어오기
			} catch (Exception e) {
				System.out.println("[SYSTEM]파일 읽기에 실패하였습니다.");
				e.printStackTrace();
			}
		} else { // 파일이 존재하지 않으면 새로운 리스트 생성
			products = new ArrayList<Product>();
		}
	}

	/**
	 * 상품리스트를 파일에 저장한다.
	 */

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("product.dat"))) {
			out.writeObject(products); // 상품스트 객체를 파일에 저장하기
		} catch (Exception e) {
			System.out.println("[SYSTEM]파일 쓰기에 실패하였습니다.");
			e.printStackTrace();
		}
	}

}
