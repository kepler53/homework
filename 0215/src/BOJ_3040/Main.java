package BOJ_3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int N = 9;
	static final int R = 7;

	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());

		}

		subset(0);

	}
	// 부분집합으로 푼 버젼 , 부분집합의 합
	static void subset(int cnt) {
		if (cnt == N) {
			int sum = 0, selectedCnt = 0; 
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sum += input[i];
					selectedCnt++;
				}
			}

			if (sum == 100 && selectedCnt == R) {
				for (int i = 0; i < N; i++) {
					if (isSelected[i])
						System.out.println(input[i]);
				}
			}
			return;
		}

		// 선택
		isSelected[cnt] = true;
		subset(cnt + 1);
		// 비선택
		isSelected[cnt] = false;
		subset(cnt + 1);

	}
	
	//조합 버젼으로 풀어보기 => cnt == R으로 해서 풀기 기저조건에서 sum =100 이면 그 때 값들 다 출력, 구현부는 동일 , 아니면 sum 값을 아예 파라미터로 같이 넘기기
	

}
