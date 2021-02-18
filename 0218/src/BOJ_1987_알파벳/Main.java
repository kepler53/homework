package BOJ_1987_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//5 6
//ABCDEF
//GHIJKL
//MNOPQR
//STUVWX
//YDEAYZ

public class Main {

	static int R, C; // 행 
	static char[][] alphabet; // 들어오는 알파벳 이차원 배열 저장
	static boolean[] isUsed; // 알파벳 사용되었는지 여부 판단

	static int length; // 여태까지 길이

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	// 상하좌우 델타함수, 재귀하면서 선언하면 계속 메모리 잡아먹으므로 static으로 구현

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// alpabhet함수 초기화 =>왜안했을까 다른건 다 쳐하면서 하..... , 안해서 nullpointerexception

		alphabet = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				alphabet[i][j] = line.charAt(j);
			}
		}

		// isUsed초기화
		isUsed = new boolean[26];
		// length초기화
		length = 1; // 주어진 조건에 시작부터 1이라고 나와있음
		
		//와 이거 처리 안해서 한 시간 잡아먹네.......
		isUsed[alphabet[0][0] - 'A'] = true;

		// 재귀함수 호출
		countLength(0, 0, length);

		System.out.println(length);
	}

	private static void countLength(int row, int col, int cnt) {

		// 기저조건
		if (length < cnt) {
			length = cnt;
//			if (isUsed[alphabet[row][col] - 'A']) {
//				System.out.println("length: "+ length+" row: "+ row +" col: "+ col +" past alphabet :" + alphabet[row][col]);
//				
//			}
		}
		if (cnt==26) { 
			length =26; //pass는 했는데 이 기저 조건이 맞는지 모르겠음, cnt가 26일때인지 length가 26일때인지 
			return;
		}

		// 재귀부분
		int nr, nc;
		for (int d = 0; d < 4; d++) {
			nr = row + di[d];
			nc = col + dj[d];

			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !isUsed[alphabet[nr][nc] - 'A']) {
				isUsed[alphabet[nr][nc] - 'A'] = true;
				countLength(nr, nc, cnt + 1);
				isUsed[alphabet[nr][nc] - 'A'] = false;
			}
		}

	}

}
