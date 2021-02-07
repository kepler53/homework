package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < TC; i++) {
			
			char[] array = br.readLine().toCharArray();
			
			int count =0;
			int sum =0;
			
			for (int j = 0; j < array.length; j++) {
				if(array[j]=='O') {
					count++;
					sum += count;
				}else {
					count = 0;
				}
			}
			System.out.println(sum);
		}
		
	}
}
