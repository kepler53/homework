

import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgr mgr = ProductMgr.getInstance();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===Abc �����д븮���� ���Ű� ȯ���մϴ�===");
			System.out.println("�Ͻ� �۾��� �����ϼ���");
			System.out.println("1:��ǰ�߰� 2:��ǰ��� 3:��ǰã��  4:��ǰ���� 5:Ư���������ϻ�ǰã��");
			System.out.println("6:TV��ǰ��� 7:�������� 8:��ü��ǰ ������ 9:��ǰã��(��ǰ��)  ");

			int select = sc.nextInt();

			if (select == -1)
				break;

			switch (select) {
			case 1:
				sc.nextLine();
				System.out.println("����ϰ��� �ϴ� ��ǰ�� ������");
				System.out.println("1.��ǰ 2.TV 3.�����");
				int type = sc.nextInt();
				if(type==1) {
					sc.nextLine();
					
					System.out.printf("��ǰ��ȣ,��ǰ�̸�,����,����");
					System.out.println();
					String[] input = sc.nextLine().split(",");
				// if input [4].equals(type)
					mgr.add(new Product(Integer.parseInt(input[0]), input[1], Integer.parseInt(input[2]),
						Integer.parseInt(input[3])));
					System.out.println("��ǰ �߰� �Ϸ�");
				}else if(type==2) {
					sc.nextLine();
					System.out.println("��ǰ��ȣ,��ǰ�̸�,����,����,�귣��,����⵵");
					System.out.println("");
					String[] input2 = sc.nextLine().split(",");
					mgr.add(new TV(Integer.parseInt(input2[0]), input2[1], Integer.parseInt(input2[2]),
							Integer.parseInt(input2[3]),input2[4],Integer.parseInt(input2[5])));
					System.out.println("TV ��ǰ�߰��Ϸ�");
				}else if(type==3) {
					sc.nextLine();
					System.out.println("��ǰ��ȣ,��ǰ�̸�,����,����,�귣��,�뷮");
					System.out.println();
					String[] input3 = sc.nextLine().split(",");
					mgr.add(new TV(Integer.parseInt(input3[0]), input3[1], Integer.parseInt(input3[2]),
							Integer.parseInt(input3[3]),input3[4],Integer.parseInt(input3[5])));
					System.out.println("����� ��ǰ�߰��Ϸ�");
				}else {
					System.out.println("��ǰ�� ����� �� �����ϴ�.");
				}
					
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
				ArrayList<Product> result = mgr.priceList(price);
				if (result != null && result.size() > 0) {
					for (Product p : result)
						System.out.println(p);
				} else {
					System.out.println("�ش� ���� ������ ��ǰ�� �����ϴ�.");
				}
				break;
			case 6: // TV��ǰ���
				ArrayList<TV> tv_list = mgr.TVList();
				if (tv_list != null && tv_list.size() > 0) {
					for (TV tv : tv_list) {
						System.out.println(tv);
					}
				}else
					System.out.println("TV ��ǰ�� �����ϴ�.");
				break;
			case 7: //����� ���
				ArrayList<Refrigerator> ref_list = mgr.RefrigeratorList();
				if (ref_list != null && ref_list.size() > 0) {
					for (Product ref : ref_list) {
						System.out.println(ref);
					}
				}else
					System.out.println("����� ��ǰ�� �����ϴ�.");
				break;			
			case 8://��ǰ�����������
				int totalPrice = mgr.getTotalPrice();
				System.out.println("��ǰ�� ������"+totalPrice+"�Դϴ�.");
				break;
			case 9:
				System.out.printf("ã�����ϴ� ��ǰ ���� �Է��ϼ���");
				String productName = sc.next();
				Product searchProductName = mgr.searchProductName(productName);
				if(searchProductName!=null)
					System.out.println(searchProductName);
				else
					System.out.println("�ش� ��ǰ ���� ��ǰ�� �����ϴ�.");
				break;
			default:
				System.out.println("����� �� ���� �Է��ϼ���");

			}
		}
	}
}
