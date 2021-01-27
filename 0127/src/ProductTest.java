

import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgr mgr = ProductMgr.getInstance();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===Abc 디지털대리점에 오신걸 환영합니다===");
			System.out.println("하실 작업을 선택하세요");
			System.out.println("1:상품추가 2:상품목록 3:물품찾기  4:물품삭제 5:특정가격이하상품찾기");
			System.out.println("6:TV상품출력 7:냉장고출력 8:전체상품 가격합 9:물품찾기(상품명)  ");

			int select = sc.nextInt();

			if (select == -1)
				break;

			switch (select) {
			case 1:
				sc.nextLine();
				System.out.println("등록하고자 하는 상품을 고르세요");
				System.out.println("1.상품 2.TV 3.냉장고");
				int type = sc.nextInt();
				if(type==1) {
					sc.nextLine();
					
					System.out.printf("상품번호,상품이름,가격,수량");
					System.out.println();
					String[] input = sc.nextLine().split(",");
				// if input [4].equals(type)
					mgr.add(new Product(Integer.parseInt(input[0]), input[1], Integer.parseInt(input[2]),
						Integer.parseInt(input[3])));
					System.out.println("상품 추가 완료");
				}else if(type==2) {
					sc.nextLine();
					System.out.println("상품번호,상품이름,가격,수량,브랜드,생산년도");
					System.out.println("");
					String[] input2 = sc.nextLine().split(",");
					mgr.add(new TV(Integer.parseInt(input2[0]), input2[1], Integer.parseInt(input2[2]),
							Integer.parseInt(input2[3]),input2[4],Integer.parseInt(input2[5])));
					System.out.println("TV 상품추가완료");
				}else if(type==3) {
					sc.nextLine();
					System.out.println("상품번호,상품이름,가격,수량,브랜드,용량");
					System.out.println();
					String[] input3 = sc.nextLine().split(",");
					mgr.add(new TV(Integer.parseInt(input3[0]), input3[1], Integer.parseInt(input3[2]),
							Integer.parseInt(input3[3]),input3[4],Integer.parseInt(input3[5])));
					System.out.println("냉장고 상품추가완료");
				}else {
					System.out.println("상품을 등록할 수 없습니다.");
				}
					
				break;
			case 2:
				System.out.println("상품 목록은 다음과 같습니다.");
				for (Product p : mgr.list()) {
					System.out.println(p);
				}
				break;
			case 3:
				System.out.println("찾으실 물품의 번호를 입력하세요");
				int searchNum = sc.nextInt();
				Product product = mgr.searchProduct(searchNum);
				if (product == null) {
					System.out.println("해당 상품번호는 존재하지 않습니다");
				} else
					System.out.println(product);

				break;
			case 4:
				System.out.println("삭제하실 상품의 상품번호를 입력하세요");
				int deleteNum = sc.nextInt();
				mgr.deleteProduct(deleteNum);
				break;
			case 5:
				System.out.println("가격을 입력하세요");
				int price = sc.nextInt();
				ArrayList<Product> result = mgr.priceList(price);
				if (result != null && result.size() > 0) {
					for (Product p : result)
						System.out.println(p);
				} else {
					System.out.println("해당 가격 이하의 제품이 없습니다.");
				}
				break;
			case 6: // TV상품출력
				ArrayList<TV> tv_list = mgr.TVList();
				if (tv_list != null && tv_list.size() > 0) {
					for (TV tv : tv_list) {
						System.out.println(tv);
					}
				}else
					System.out.println("TV 상품이 없습니다.");
				break;
			case 7: //냉장고 출력
				ArrayList<Refrigerator> ref_list = mgr.RefrigeratorList();
				if (ref_list != null && ref_list.size() > 0) {
					for (Product ref : ref_list) {
						System.out.println(ref);
					}
				}else
					System.out.println("냉장고 상품이 없습니다.");
				break;			
			case 8://상품가격총합출력
				int totalPrice = mgr.getTotalPrice();
				System.out.println("상품의 총합은"+totalPrice+"입니다.");
				break;
			case 9:
				System.out.printf("찾고자하는 상품 명을 입력하세요");
				String productName = sc.next();
				Product searchProductName = mgr.searchProductName(productName);
				if(searchProductName!=null)
					System.out.println(searchProductName);
				else
					System.out.println("해당 상품 명의 제품은 없습니다.");
				break;
			default:
				System.out.println("제대로 된 값을 입력하세요");

			}
		}
	}
}
