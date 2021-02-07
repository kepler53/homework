package BOJ;

import java.util.Scanner;

public class Main_2851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = sc.nextInt();
		}
		int oversum =0; //100이상인지 체크 
		int undersum =0;//100미만인지 체크
		// 질문할 것 처음에 안 먹는 걸 어떻게 구현해야할 지 모르겠음 
		
		for (int i = 0; i < 10; i++) {
			oversum = undersum + array[i];
			
			if(undersum<oversum&&oversum<100)
				undersum += array[i];
			else if(oversum>=100)
				break;			
		}

		//절대값 구하는 법 MATH.abs 
		if(Math.abs(oversum-100)<=Math.abs(undersum-100))
			System.out.println(oversum);
		else
			System.out.println(undersum);
		
		
	}
}
