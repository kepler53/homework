import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_SWEA_벽돌깨기 {

	static int N, W, H; //구슬 수 , 가로길이, 세로길이
	static int[][] map; //처음 저장된 블록
	static int[] result; // 뽑은 구슬을 어느 column에 떨어뜨릴지 저장하기 위한 배열
	static int[] ni = {-1,0,1,0}; // 델타함수
	static int[] nj = {0,1,0,-1};
	static boolean[][] visited; //구슬이 방문한 적 있는 지 없는 지 체크하기 위한 boolean 배열
	static int ans; // 최종결과
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC ; tc++) {
			
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			visited = new boolean[H][W];
			result = new int[N];
			ans = Integer.MAX_VALUE;
			permutation(0); //그냥 순열 아니라 중복순열
			System.out.println("#"+tc+" "+ans);
			
		}
		
	}



	private static void permutation(int nCnt) {
		if(nCnt == N) {
			int totalBlockCnt = countBlock(map);
			int[][] copiedMap = copyMap(map);
			
//			구슬 넣어서 벽돌 빼기
			for (int i = 0; i < N; i++) {
				resetVisit();
				int deleteBlockCnt = fall(copiedMap, result[i]);
				deleteBlank(copiedMap);
				totalBlockCnt -= deleteBlockCnt;
			}
			
			ans = Math.min(ans, totalBlockCnt);
			return;
		}
		
		for (int i = 0; i < W; i++) {
			result[nCnt] = i;
			permutation(nCnt+1);
		}
		
	}
	
//	private static void permutation(int nCnt) {
//		result[0] = 2;
//		result[1] = 2;
//		result[2] = 6;
//		
//		int[][] copiedMap = copyMap(map);
//		resetVisit();
//		int deleteBlockCnt = fall(copiedMap, result[0]);
//		deleteBlank(copiedMap);
//		resetVisit();
//		deleteBlockCnt = fall(copiedMap, 2);
//		System.out.println("2번 째 구슬 낙하 후 맵");
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.printf("%3d",copiedMap[i][j]);				
//			}
//			System.out.println();
//		}
//		deleteBlank(copiedMap);
//		System.out.println("2번째 구슬 블랭크 없앤 후 맵");
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.printf("%3d",copiedMap[i][j]);				
//			}
//			System.out.println();
//		}
//		resetVisit();
//		deleteBlockCnt = fall(copiedMap, 6);
//		deleteBlank(copiedMap);


//	}

	private static void deleteBlank(int[][] copiedMap) {
		
		//먼저 열을 선택하고
		//아래서부터 0이 있으면 내려오게 한다.
		//뭘 잘못했지 왜 다른데는 가라 앉는 데   앞부분은 안 가라 앉는거지.....
		for (int col = 0; col < W; col++) {
			for (int row = H-1; row > 0; row--) {
				int cnt=0;
				for (int i = 0; i < row; i++) {
					if(copiedMap[row-i][col]==0) {
						for (int j = row-i; j > 0; j--) {
							copiedMap[j][col] = copiedMap[j-1][col];		
						}
						i--;
					}
					copiedMap[0][col] = 0;
					cnt++;
					if(cnt==row)
						break;
				}
				
				//디버깅 요청하기 => 위의 코드도 다 가라앉아야지 정상아닌가 ? 무슨 실수 한거지?
				
				//0이 연속되는 경우를 제외해야하므로 위의 경우도 그거 고려했는 데 왜 안될까
				//swap 형태로 짜기
//				if(copiedMap[row][col]==0) {
//					// 0이 다음에 어디서 나타나는 지 확인하기 위해
//					int tempRow = row; 
//					 // 다음 0이 안나타나는 row 체크
//					while(copiedMap[tempRow][col]==0 && tempRow >0) {
//						tempRow--;
//					}
//					copiedMap[row][col] = copiedMap[tempRow][col];
//					copiedMap[tempRow][col] = 0;
//				}
			}	
		}
	}


	private static int fall(int[][] copiedMap, int colNum) {

		int deleteCnt = 0; //지운 벽돌 수
		
		Queue<Point> queue = new LinkedList<>();
		
		for (int i = 0; i < H; i++) {
			if(copiedMap[i][colNum]!=0) {
				queue.add(new Point(i, colNum));
				visited[i][colNum] = true;
				break; //break 거는 거 생각 못함
			}
		}
		
		//bfs 시작
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			int nowX = now.x;
			int nowY = now.y;
			
			int distance = copiedMap[nowX][nowY]-1; //삭제 가능한 거리, 십자가 모양으로 다 없애버리기
			
			// 큐에서 꺼내면 벽돌깨기
			copiedMap[nowX][nowY] = 0;
			deleteCnt++;
			
			for (int d = 0; d < 4; d++) {
				int nextX = nowX;
				int nextY = nowY;
				for (int i = 0; i < distance; i++) { //자기자신부터 distance까지 삭제
					 nextX += ni[d];
					 nextY += nj[d];
					
					//지도 밖으로  나갈 경우
					if (nextX<0||nextX>=H||nextY<0||nextY>=W) {
						continue;
					}
					//방문한적 있는 경우
					if(visited[nextX][nextY]) {
						continue;
					}
					//깰 벽돌이 없는 경우
					if (copiedMap[nextX][nextY]==0) {
						continue;
					}
					//아니면 깰 수 있는 벽돌이므로 queue에 넣고 방문 처리
					queue.add(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
			
		}
		
		return deleteCnt;
	}

	private static void resetVisit() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				visited[i][j] = false;
			}
		}
	}

	private static int[][] copyMap(int[][] map) {
		
		int[][] copiedMap = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copiedMap[i][j] = map[i][j];
			}
		}
		return copiedMap;
	}
	
	private static int countBlock(int[][] map) {
		
		int cnt = 0;
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]!=0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static class Point{
		int x;
		int y;
		
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
}