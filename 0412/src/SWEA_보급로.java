import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



public class SWEA_보급로 {
	
	static int N; // 
	static int[][] map; //지도 
	static int[][] cost; //위치까지 걸린 최소 복구작업시간 저장위한 2차원배열
	static boolean[][] visited; //방문한 적 있는지 없는지 확인 
	static int[] ni = {1,0,-1,0}; //델타함수  
	static int[] nj = {0,-1,0,1};
	static int result; //최소 결과 값
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= C; tc++) {
			
			N = Integer.parseInt(br.readLine()); //틀린 점 int N으로 선언해버림....
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j)-'0';
//					System.out.print(map[i][j]);
				}
//				System.out.println();
			}
			//초기화 
			result = Integer.MAX_VALUE;
			visited = new boolean[N][N];
			cost = new int[N][N];
			for (int i = 0; i < N; i++) { 
				Arrays.fill(cost[i], Integer.MAX_VALUE); //2차원 배열인데 Arrays.fill(cost, Integer.MAX_VALUE); 1차원 배열로 할당
			}
			cost[0][0] = 0;
			
			
			bfs(0,0);
				
			System.out.println("#"+tc+" "+result);	
		}
	}

	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		
		Queue<Point> queue = new LinkedList<>();
		//시작위치집어넣고 방문체크 
		queue.add(new Point(x, y));
		visited[x][y] = true;
		
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			
			
			int nowX = now.x;
			int nowY = now.y;

			//기저조건 : 골에 도착했을 때 
			if(nowX==N-1&&nowY==N-1) {
//				System.out.println("여기 온적 있니??");
				//최솟값 갱신
				result = Math.min(result, cost[N-1][N-1]);
			}
			
			//구현부
			for (int d = 0; d < 4; d++) {
	
				int nextX = nowX + ni[d];
				int nextY = nowY + nj[d];
				
//				System.out.println(N);
				
				//지도 안에 있고 
				if(nextX>=0&&nextY>=0&&nextX<N&&nextY<N) { //int N으로 선언해서 계속 이 if문에 못들어왔음 => 개버러지짓 하지말기 
//					System.out.println(cost[nowX][nowY]);
					//방문한적 없거나 최소비용이 지금 최소비용 + 현재 비용보다 크면 방문 처리, 큐삽입, 최소비용 갱신  
					if(!visited[nextX][nextY]||cost[nextX][nextY]>cost[nowX][nowY]+map[nextX][nextY]) {
//						System.out.println("여길 왓어2?");
						cost[nextX][nextY]=cost[nowX][nowY]+map[nextX][nextY];
						visited[nextX][nextY] = true;
						queue.add(new Point(nextX, nextY));
					}
				}	
			}
		}
	}
	
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}

}
