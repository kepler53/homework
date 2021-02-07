package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3985 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		int person = Integer.parseInt(br.readLine());
		
		int start;
		int end;
		int expectIndex = 0;
		int expectSum;
		int realIndex = 0;
		int realSum = 0;
		int expectNum = 0; //실수한 부분 이 부분을 for문 안에 집어넣어서 값을 계속 바뀌는 데 답은 제대로 나와서 틀림
		
		boolean[] isUsed = new boolean[length+1];
		
		for (int i = 1; i <= person; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			expectSum = end -start;
			if(expectSum > expectNum) {
				expectNum = expectSum;
				expectIndex = i;				
			}
			
			int count = 0;
			
			for (int j = start; j <= end; j++) {
				if(isUsed[j]==true)
					continue;
				else {
					isUsed[j] =true;
					count++;
				}
			}
			
			if(count>realSum) {
				realSum = count;
				realIndex = i;
			}
			
		}
		
		System.out.println(expectIndex);
		System.out.println(realIndex);
	
	}
	
	
}