
import java.util.Scanner;

//서로소 집합
public class Solution {

	
	static int[] parent;
	static int N,M;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <=TC; tc++) {
			 N = sc.nextInt();
			 M = sc.nextInt();
			
			parent = new int[N+1]; //1번 인덱스부터 사용하려고 N+1선언
			
			boolean[] used = new boolean[N+1]; //parent가 사용된적있는지 없는 지 알기 위해서
			
			make(); // 이 작업 안해서 다 1들어가있었음
			
			for (int i = 0; i < M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				if(find(from)!= find(to)) {
					union(from,to);
				}		
			}
			
			int unionCnt = 0;
			for (int i = 1; i <=N; i++) {
				int parent = find(i);
				if(!used[parent]) { //사용된적 없으면 카운트 증가
					unionCnt++;
				}
				used[parent] = true; //사용처리
			}	
			System.out.println("#"+tc+" "+unionCnt);	
		}
	}
	
	//각각에 맞는 parent 설정
	public static void make() {
		for (int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
	}
	
	
	//대표찾기
	public static int find(int number) {
		if(number==parent[number]) {
			return number;
		}else {
			return parent[number] = find(parent[number]);
		}
	}
	// 대표가 자기 자신이면 자신으로 하고 아니면 자신이 대표포기하고 다른 사람 밑으로 들어가기
	public static void union(int num1, int num2) {
		int parent1 = find(num1);
		int parent2 = find(num2);
		
		if(parent1!=parent2) {
			parent[parent2] = parent1;
		}	
	}
}
