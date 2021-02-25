package IM대비;

import java.util.Scanner;

public class Main_블랙잭 {

	//조합 사용하는 문제
	static int N,M;
	static int[] input;
	static int[] result; //뽑힌 것
	static int sumMax;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N];
		result = new int[3];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
			
		}
		
		sumMax = 0;
		
		combination(0,0,0);
		
		System.out.println(sumMax);
		
		
	}
	
	static void combination(int cnt,int start, int sum) {
		
		if(cnt==3) {
			if(sum>=sumMax && sum<=M)
				sumMax =sum;
			return;
		}
		if(start==N)
			return;
		
		//넣었을 때
		combination(cnt+1,start+1,sum+input[start]);
		//안넣었을 때 
		combination(cnt,start+1,sum);
		
	}
	
}