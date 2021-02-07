package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2999 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] array = br.readLine().toCharArray();
		int N = array.length;
		int R =0;
		int C =0;
		
		for (int i = 1; i < array.length; i++) {
			if(N%i==0&&i<=N/i) {
				R = i;
				C = N/i;
			}
		}
		
		char[][] email = new char[C][R];

		
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                email[i][j] = array[i+C*j]; 
                
            }
        }
        
 
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                System.out.print(email[i][j]);
            }
        }	
	}

}
