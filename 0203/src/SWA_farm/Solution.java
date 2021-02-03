package SWA_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			int sum = 0;
			int N = Integer.parseInt(br.readLine());
			int array[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					array[i][j] = line.charAt(j)-'0'; //char이므로 0을 빼서 array를 만든다.
				}	
			}
			
			for(int i = 0;i<N/2;i++) {
				for (int j = N/2-i; j <= N/2+i; j++) {
					sum += array[i][j];
				}
			}
			
			for (int i = N/2; i>=0; i--) {
				for (int j = N/2-i; j <= N/2+i; j++) {
					sum += array[N-i-1][j];
				}				
			}
			
			System.out.println("#"+(tc+1)+" "+sum);
			
		}
		
		
		
	}

}
