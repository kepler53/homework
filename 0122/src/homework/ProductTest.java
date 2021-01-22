package homework;

import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgr mgr = ProductMgr.getInstance();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===Abc �����д븮���� ���Ű� ȯ���մϴ�===");
			System.out.println("�Ͻ� �۾��� �����ϼ���");
			System.out.println("1.�߰� 2:��ǰ��� 3:��ǰã�� 4:��ǰ���� 5:Ư���������ϻ�ǰã��");

			int select = sc.nextInt();

			if (select == -1)
				break;

			switch (select) {
			case 1:
				sc.nextLine();
				System.out.println("��ǰ��ȣ,��ǰ�̸�,����,����");
				String[] input = sc.nextLine().split(",");
				mgr.add(new Product(Integer.parseInt(input[0]), input[1], Integer.parseInt(input[2]),
						Integer.parseInt(input[3])));
				System.out.println("��ǰ �߰� �Ϸ�");
				break;
			case 2:
				System.out.println("��ǰ ����� ������ �����ϴ�.");
				for (Product p : mgr.list()) {
					System.out.println(p);
				}
				break;
			case 3:
				System.out.println("ã���� ��ǰ�� ��ȣ�� �Է��ϼ���");
				int searchNum = sc.nextInt();
				Product product = mgr.searchProduct(searchNum);
				if (product == null) {
					System.out.println("�ش� ��ǰ��ȣ�� �������� �ʽ��ϴ�");
				} else
					System.out.println(product);

				break;
			case 4:
				System.out.println("�����Ͻ� ��ǰ�� ��ǰ��ȣ�� �Է��ϼ���");
				int deleteNum = sc.nextInt();
				mgr.deleteProduct(deleteNum);				
				break;
			case 5:
				System.out.println("������ �Է��ϼ���");
				int price = sc.nextInt();
				Product[] result = mgr.priceList(price);
				if(result != null && result.length>0){
					for(Product p : result)
						System.out.println(p);
				}else {
					System.out.println("�ش� ���� ������ ��ǰ�� �����ϴ�.");
				}
				break;
			default:
				System.out.println("����� �� ���� �Է��ϼ���");

			}
		}
	}
}
