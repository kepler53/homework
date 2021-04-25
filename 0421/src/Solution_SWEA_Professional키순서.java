import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_Professional키순서 {
	
	//dfs,bfs,floyd-warshall : 내가 생각한 풀 수 있는 경우, floyd-warshall 사용할 해볼 경우 별로 없으므로 사용해보기, 나중에 다시 풀 때는 dfs로 풀기
	//bfs로 풀면 큰 애 들어가는 큐, 작은애 들어가는 큐 만들어서 값 return 받아서 더해서 N-1이면 될 것이고
	//dfs => 지금은 생각이 안남 => 머리가 안돌아가 => 수업들으면서 생각하기
	//dijsktra도 플로이드 워셜이랑 비슷할 듯, pq쓴 버젼(N^2*lonN)일 것이고 , 아니면 pq안쓴 버젼은 floyed-warshall하고 똑같이 써서 이건 의미가 없을 듯.....  
	//최단경로의 의미가 있나? 유량이 N(N-1)/2인 거 찾아내면되나? 
	//Prim이나 Kruskal을 사용하려나? 절대 안 되는 것 MST가 안되므로
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			
			
			int N = sc.nextInt(); // max500 => floyd warshall N^3 :25000*500 => 천이백오십만
			int M = sc.nextInt();
			
			int[][] adj = new int[N+1][N+1]; //1번 인덱스부터 쓰므로
			
			//초기값 무한대 =>Integer.MaxValue 하면 오류 나서 그냥 임의의 큰 값 => 499가 최대이므로
			final int INF = 25000*25000/2+1;
			for (int i = 0; i < adj.length; i++) {
				Arrays.fill(adj[i], INF);
			}
						
			//입력받은 값은 간선의 value 1로 집어줌, 입력받는 앞의 학생의 키 < 입력받는 뒤의 학생의 키 
			for (int i = 0; i < M; i++) {
				adj[sc.nextInt()][sc.nextInt()] = 1;
			}
//			showMap(adj);			
			int[] dp = new int[N+1]; //자신에게 오는거하고 나가는 거 기록하려고 만든 dp
			for (int k = 0; k < N+1; k++) {
				for (int i = 0; i < N+1; i++) {
					for (int j = 0; j < N+1; j++) {
						if(adj[i][j]>adj[i][k]+adj[k][j]) {
							adj[i][j]=adj[i][k]+adj[k][j];
						}
					}
				}
			}
//			showMap(adj);
			//들어오는 애 나가는애의 수 세주기
			for (int i = 0; i < N+1; i++) {
				for (int j = 0; j < N+1; j++) {
					if(adj[i][j]!=INF) {
						dp[i]++;
						dp[j]++;
					}
				}
			}

//			for (int i = 0; i < dp.length; i++) {
//				System.out.println(i+" "+dp[i]);
//			}
			//들어오는 애하고 나가는 애의 수의 합이 N-1이면 끝
			int result = 0;
			for (int i = 0; i < dp.length; i++) {
				if(dp[i]==N-1) {
					result++;
				}
			}
			System.out.println("#"+tc+" "+result);
			
		}
		
		
	}
	
	static void showMap(int[][] adj) {
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				System.out.printf("%11d",adj[i][j]);
			}
			System.out.println();
		}
	}
}
