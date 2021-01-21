package hwjava04_대전_5반_이종현;

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
		//refrigerator 위와 동문
		//해봐야할 것 이렇게 set으로 입력하지 않고 scanner로 받아보는 것 질문하기
	}
}