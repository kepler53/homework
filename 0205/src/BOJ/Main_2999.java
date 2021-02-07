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
		
		char[][] email = new char[R][C];
		int count =0;
		
		//행렬 transpose
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                email[j][i] = array[count++]; 
            }
        }
        
 
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(email[i][j]);
            }
        }
		
	}

}
