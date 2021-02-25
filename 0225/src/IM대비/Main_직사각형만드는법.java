package IM대비;

import java.util.Scanner;

public class Main_직사각형만드는법 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int recCnt=0;
		
		int N = sc.nextInt();
		
		for (int i = 1; i <=N; i++) {
			for (int j = i; i*j <= N; j++) {
				recCnt++;
			}
		}
		
		System.out.println(recCnt);
	}

}