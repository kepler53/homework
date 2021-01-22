package homework;

import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgr mgr = ProductMgr.getInstance();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===Abc 디지털대리점에 오신걸 환영합니다===");
			System.out.println("하실 작업을 선택하세요");
			System.out.println("1.추가 2:상품목록 3:물품찾기 4:물품삭제 5:특정가격이하상품찾기");

			int select = sc.nextInt();

			if (select == -1)
				break;

			switch (select) {
			case 1:
				sc.nextLine();
				System.out.println("상품번호,상품이름,가격,수량");
				String[] input = sc.nextLine().split(",");
				mgr.add(new Product(Integer.parseInt(input[0]), input[1], Integer.parseInt(input[2]),
						Integer.parseInt(input[3])));
				System.out.println("상품 추가 완료");
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
				Product[] result = mgr.priceList(price);
				if(result != null && result.length>0){
					for(Product p : result)
						System.out.println(p);
				}else {
					System.out.println("해당 가격 이하의 제품이 없습니다.");
				}
				break;
			default:
				System.out.println("제대로 된 값을 입력하세요");

			}
		}
	}
}
