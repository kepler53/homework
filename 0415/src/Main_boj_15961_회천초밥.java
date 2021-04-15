import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_15961_회천초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushiList = new int[N];
		for (int i = 0; i < N; ++i) {
			sushiList[i] = Integer.parseInt(br.readLine()); 
		}

		int[] countSushi = new int[d + 1]; //초답 번호 담길 인덱스 배열 1번 부터 사용할 거임, 해당  인덱스의 초밥 수가 얼마나 있는지
		countSushi[c]++; //쿠폰 초밥

		int cnt = 1; //몇개 먹을 수 있는 지 체크, 쿠폰 초밥있으므로 1부터 시작 없었으면 0.
		
		for (int i = 0; i < k; i++) {
			if (countSushi[sushiList[i]]++ == 0) { //테이블에 올라온 스시체크
				cnt++; //
			}
		}
		int result = 0; //최대 값 알기 위해 

		for (int i = k; i < k + N; i++) { // 다 먹어보기 순서대로 0123, 1234 ,2345, 3456, 이형태로  N개만큼
			if (--countSushi[sushiList[i - k]] == 0) {
				cnt--;
				}
			if (countSushi[sushiList[i % N]]++ == 0) { //원형이므로 mod해줘야함
				cnt++;
				}
			result = Math.max(cnt, result);
		}

		System.out.println(result);
	}
}