package problem3_BOJ17478;

import java.util.Scanner;

public class Solution {
	
	static Scanner sc = new Scanner(System.in);
	static int input = sc.nextInt();
	static int underbarCnt = 0;
	
	public static void main(String[] args) {
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		chatBot(input);
	}
	
	public static void chatBot(int n) {
		underbarAdd(underbarCnt);
		System.out.println("\"재귀함수가 뭔가요?\"");
		if(n==0) {
			underbarAdd(underbarCnt);
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");			
			for(int i=underbarCnt+1;i>0;i--) {
				underbarAdd(underbarCnt);
				System.out.println("라고 답변하였지." +"");
				underbarCnt--;
			}
			return;
		}
		
		underbarAdd(underbarCnt);
		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		underbarAdd(underbarCnt);
		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		underbarAdd(underbarCnt);
		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		underbarCnt++;
		
		chatBot(n-1);
	}
	
	public static void underbarAdd(int a) {
		for(int i=0; i<a ;i++) {
			System.out.print("____");
		}
	}
}
