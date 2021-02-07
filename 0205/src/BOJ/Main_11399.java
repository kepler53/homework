package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11399 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int lineLength = sc.nextInt();
		int[] array = new int[lineLength];
		for (int i = 0; i < lineLength; i++) {
			array[i] = sc.nextInt();					
		}
		int temp = 0;
//		for (int i = 1; i < lineLength; i++) {
//			if(array[i]<array[i-1]) {
//				temp = array[i-1];
//				array[i-1] = array[i];
//				array[i] =temp;				
//			}
//			
//		} 여기서 왜 소팅이 안 되는 이유는 뭘까? while문 돌려야하나?
		Arrays.sort(array);
	
		int sum = 0;
		for (int i = 0; i < lineLength; i++) {
//			System.out.println(i+":"+array[i]);
			sum += (lineLength - i)*array[i];
			
		}
		System.out.println(sum);
		sc.close();
	}

}
