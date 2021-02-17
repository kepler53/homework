package BOJ_1992_쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[][] video;
	static String result; // str으로 쓰면 st와 헷갈릴 수 있으므로 result로 변수 선언
	// 궁금한 점 밖에서 StringBuilder사용해서 붙이려면?

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		video = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				video[i][j] = line.charAt(j) - '0';		
			}	
		}
		// result 초기화
		result = "";

		// 압축 재귀 호출
		compression(0, 0, N);

		System.out.println(result);
	}

	static boolean checkSame(int R, int C, int N) {

		int temp = video[R][C];

		for (int i = R; i < R + N; i++) {
			for (int j = C; j < C + N ; j++) {
				if (temp != video[i][j]) {
					return false;
				} // 하나라도 다르면 바로 false
			}
		}
		return true;
	}

	public static void compression(int R, int C, int N) {
		if (checkSame(R, C, N)) { // 같을 경우 처음 시작값만 String에 붙여준다.
			result += video[R][C]; // 연산자 오버로딩 사용 : String에 붙여쓴다.
		} else {
			// 아닐경우 (압축된 내용)
			result += "(";
			compression(R, C, N/2); // 좌상
			compression(R, C + N / 2, N/2); // 우상
			compression(R + N/2, C, N/2); // 좌하
			compression(R + N/2, C+N/2, N/2); // 우하
			result += ")";

		}

	}

}