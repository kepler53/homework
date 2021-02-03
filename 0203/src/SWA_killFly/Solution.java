package SWA_killFly;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
	
		int TC = sc.nextInt();
		
		for (int tc = 0; tc < TC; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] array = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					array[i][j] = sc.nextInt();
				}	
			}
			int max = 0;
			for (int i = 0; i <= N-M; i++) {
				for (int j = 0; j <=N-M; j++) {
					int sum =0;
					
					for (int di = 0; di < M; di++) {
						for (int dj = 0; dj < M; dj++) {
							sum += array[i+di][j+dj];
						}
					}
					if(sum>max)
						max = sum;
					
				}
			}
		
			System.out.println("#"+(tc+1)+" "+max);
		}
	
	}

}
