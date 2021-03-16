import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BFS와DFS {

	static int N, M, start;
	static boolean map[][]; //정보가 담길 것들
	static boolean visit[]; //이미 왔었는 지 체크

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		map = new boolean[N + 1][N + 1]; //1번 인덱스부터 사용하려고 +1로 선언함
		for (int i = 0; i < M; i++) { // 간선수만큼 추가
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = true;
			map[to][from] = true;
		}

		visit = new boolean[N + 1];
		dfs(start);
		
		System.out.println();
		visit = new boolean[N + 1];
		bfs(start);

	}

	public static void dfs(int now) {
		System.out.print(now + " ");
		visit[now] = true;
		for (int i = 1; i <= N; i++) {
			if (map[now][i] && !visit[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int now) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(now);
		visit[now] = true;

		while (!queue.isEmpty()) {
			int next = queue.poll();
			System.out.print(next + " ");
			for (int i = 1; i <= N; i++) {
				if (map[next][i] && !visit[i]) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
