package hwjava04_����_5��_������;

public class Test {
	public static void main(String[] args) {

		TV[] tvs = new TV[2];
		tvs[0] = new TV(1, "Galaxy", 10000, 63, "A");
		tvs[1] = new TV();
		tvs[1].setProductName("Galaxy");
		tvs[1].setInch(66);
		tvs[1].setPrice(25000);
		tvs[1].setType("B");
		tvs[1].setProductNum(2);

		for (TV tv : tvs) {
			System.out.println(tv);
		}
		//refrigerator ���� ����
		//�غ����� �� �̷��� set���� �Է����� �ʰ� scanner�� �޾ƺ��� �� �����ϱ�
	}
}