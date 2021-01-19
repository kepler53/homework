package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int intArray[] = new int[500];
		int intArray2[] = new int[500];
		int used[] = new int[500];

		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
			
			if (intArray[i] == 0) {
				
				break;
			}
			
			used[intArray[i]/10]++;
			
		}

		for (int i = 0; i < used.length-1; i++) {
			//0을 안 출력하기 위하여 used.length-1을 설정
			if (used[i] != 0) {
				System.out.println(i + ":" + used[i] + "개");
			}
		}
		
	}
}
