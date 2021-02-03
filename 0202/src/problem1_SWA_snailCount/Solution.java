package problem1_SWA_snailCount;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=0;tc<TC;tc++) {

			int N = sc.nextInt();
			int array[][] = new int[N][N];
			
			int length = N;
			int R = 0, C=-1; //여기서 C를 0으로 뒀더니 ArrayIndexOutOfBounds 뜸, 생각못햇음 C에서 바로 더해서 0이 되어야하는데 1이되버리는 걸 생각 못함, 오답 노트에 무조건 적기
			// 조건 값을 항상 머리속으로 돌려보기
			int direction =1;
			int number =1;
			
			while(true){
				if(length==0)
					break;
				for (int i = 0; i < length; i++) {
					C+=direction;
					array[R][C] = number;
					number++;
				}
				length--;
				for (int i = 0; i<length; i++) {
					R+=direction;
					array[R][C] = number;
					number++;
				}
				direction*=(-1);
			}
			
			System.out.println("#" +(tc+1));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(array[i][j]+" "); //출력할 때 똑바로 출력하기(요구된 조건 사항 무조건 제대로 읽기) => 이 때문에 5개 맞게 됨 
				}
				System.out.println();
			}
		}			
	}
}
