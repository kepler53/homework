package problem1_SWA1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWA_1249 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		int TC = Integer.parseInt(br.readLine());
		//int TC = sc.nextInt();
		// 오늘 수업다시 듣기 입출력에서 nextInt() 부분과 next()부분의 차이점, 복사해서 붙여넣으면 값이 출력 안되고 복사안하면 등어감

		for (int i = 0; i < TC; i++) {
			// int[] array = br.readLine();
			// 어걸 어떻게 나중에 바꿀것인지
			// array받아온걸 어떻게 하나씩 나누는가
			// StringTokenizer로 못나누나
			char[] array = br.readLine().toCharArray();
			// 공부해야할 내용 입출력 완벽하게 하기(고민 제일 많이 한 부분)
			char init = '0';
			int count = 0;

			for (int j = 0; j < array.length; j++) {
				if (init != array[j]) {
					count++;
					init = array[j];
				}
			}
//			System.out.println(i);
//			System.out.println(array);
			System.out.println("#" + (i + 1) + " " + count);
		}
	}
}
