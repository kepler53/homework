import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//주말에 dfs로 풀어보기 => point를 static으로 만들고 조건들만 옮기면 되겟지.. flag도 static으로 
//더 적게 걸리려나 가지치기하니까????

public class Main_boj9205_맥주파티 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			
			int n = sc.nextInt();
			Point[] point = new Point[n+2];
			
			for (int i = 0; i < point.length; i++) {
				point[i] = new Point(sc.nextInt(),sc.nextInt());
			}
			
			//point[0] : 집, point[n+1] :파티장소
			
			//bfs시작
			boolean flag = false; //파티도착했는지 알기 위한 flag 
			boolean[] visited = new boolean[n+2];
			Queue<Point> queue = new LinkedList<>();
			queue.add(point[0]);
			visited[0] = true; 
			
			while (!queue.isEmpty()) {
				Point now = queue.poll();
				int nowX = now.x;
				int nowY = now.y;
				
				//조건 1:파티장소 x,y좌표가 같으면 파티장소 도착, flag = true, while문 탈출
				if(nowX==point[n+1].x&&nowY==point[n+1].y) {
					flag = true;
					break;
				}
				
				//조건 2:편의점 돌아다니기,방문안되고  맨해튼 거리가 1000이하면 큐에 집어넣고 방문체크
				//풀면서 틀린점 :for문 조건에 index값 n+1로 줌 => 당연히 파티 장소 못가지......
				//그려보다가 깨달음.......
				//잘못한 점 : 조건에 편의점 돌아다니기라고 쓴 점, 그냥 집 빼고 다 방문임...... 
				for (int i = 1; i < n+2; i++) {
					int lengthX = Math.abs(now.x-point[i].x);
					int lengthY = Math.abs(now.y-point[i].y);
					if(!visited[i]&& lengthX+lengthY<=1000) {
						queue.offer(point[i]);
						visited[i] = true;
					}
				}
			}
			if(flag==true) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}
	}
	
	static class Point {
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}
}
