package JO_1828;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Chemical[] c = new Chemical[N];
		
		for (int i = 0; i < N; i++) {
			c[i] = new Chemical(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(c);
		
		int refCnt = getRefCnt(c);
		
		System.out.println(refCnt);
		
	}
	
	static class Chemical implements Comparable<Chemical> {	
		int low, high;

		public Chemical( int low, int high) {
			super();
			
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Chemical o) {
			
			return this.high-o.high;
		}
		//어떻게 정리할 것인지
		//이 부분에서 만약 오늘 오후에 정의한 거와 같이 low와 high가 같을 때 어떻게 정의할 것인지 생각해보기
	}
	
	static int getRefCnt(Chemical[] c) {
		
		ArrayList<Chemical> list = new ArrayList<Chemical>();
		list.add(c[0]);
		for (int i = 0; i < c.length; i++) {
			if(list.get(list.size()-1).high<c[i].low) {
				list.add(c[i]);
			}
		}
		
		return list.size();
	}
}
