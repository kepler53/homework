//using minimum spanning tree => kruskal or prim algorithm, disjoint set
//머리 더 안돌아감 prim은 다시 짜보기 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_swa_하나로 {
	
	static int n;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; ++tc) {
			 n = Integer.parseInt(br.readLine());
			double[] xPosition = new double[n];
			double[] yPosition = new double[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				xPosition[i] = Double.parseDouble(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				yPosition[i] = Double.parseDouble(st.nextToken());
			}
			double taxRate = Double.parseDouble(br.readLine());
			
			parent = new int[n];
			make();
			//pq 사용해보기, 아니면 Edge의 List만들고 정렬하기 
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			//pq에 Edge 넣어버리기,가장 작은 weight순으로 정렬될 수 있도록 
			//weight = weight; (x2-x1)^2+(y2-y1)^2;
			//양방향이므로 윗삼각형의 adjMatrix의 간선들만 가져다 쓰는 것처럼 구현 
			//삼각형 위쪽의 모든 간선에 대해서 구해야하므로 
			for (int start = 0; start < n -1; start++) {
				for (int end = start + 1; end < n; end++) {
					double xWeight = Math.pow(xPosition[start] - xPosition[end], 2);
					double yWeight = Math.pow(yPosition[start] - yPosition[end], 2);
					double weight = xWeight + yWeight;
					pq.offer(new Edge(start, end, weight));
				}
			}
			
			Edge now = null;
			double weight = 0; //환경비용값 e*weight  
			// 간선의 start와 end 비교해서 같으면 다음 간선으로 넘어가고 아니면 합치고 거리계산
			while (!pq.isEmpty()) {
				now = pq.poll();
				int startParent = findSet(now.start);
				int endParent = findSet(now.end);
				if (startParent == endParent) { //대표가 같을 경우 안 합친다. 
					continue;
				}else { //아니면 합치고 weight 계산 
					union(startParent, endParent);
					weight += taxRate * now.weight;
				}
			}
			System.out.println("#" + tc + " " + Math.round(weight));
		}	
	}
	static class Edge implements Comparable<Edge> {
		int start, end;
		double weight;

		Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) (this.weight - o.weight); //compareTo의 return type이 int로 강제되어있는 거 같다. => api 살펴보기 
			//강제되어있네.... double안돼서 explicit typecasting하기 
		}
	}
	
	//대표를 자기자신으로 설정 
	static void make() {
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			//rank[i] = ??
		}
	}//여기서 rank선언 해줘야하나?
	
	//대표찾기 
	static int findSet(int x) {
		if (x != parent[x])
			return findSet(parent[x]);
		return x;
	}

	// 대표 일치하지 않으면 합병 
	static void union(int x, int y) {
		if (x < y) {
			parent[y] = parent[x];
		} else {
			parent[x] = parent[y];
		}//순서는 상관없음 
	}
	//rank관리하는 법 모르겠음...... 어떻게 여기에서 더 추가해볼수 있을까?????..Node라는 클래스를 또 만들고 거기서 진행해야하나?
}