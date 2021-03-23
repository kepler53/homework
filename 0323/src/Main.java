import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[][] map = new int[N+1][3];
		
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		// 0:red 1:green 2:blue
		for (int n = 2; n <=N; n++) {
			// 선택한 집의 색이 red일 때 
			map[n][0] = Math.min(map[n-1][1],map[n-1][2])+map[n][0];
			// 선택한 집의 색이 blue일 때 
			map[n][1] = Math.min(map[n-1][2],map[n-1][0])+map[n][1];
			// 선택한 집의 색이 green일 때 
			map[n][2] = Math.min(map[n-1][0],map[n-1][1])+map[n][2];	
		}
		
		System.out.println(Math.min(map[N][0], Math.min(map[N][1], map[N][2])));
	}
}