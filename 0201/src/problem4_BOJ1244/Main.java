package problem4_BOJ1244;

import java.util.Scanner;

public class Main {

	static int bulbCnt, stuNum;
	static int[] status;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		bulbCnt = sc.nextInt() + 1;

		status = new int[bulbCnt]; //전구상태 배열
		for (int i = 1; i < bulbCnt; i++) {
			status[i] = sc.nextInt();
		}

		stuNum = sc.nextInt(); // 학생 수
		for (int i = 1; i <= stuNum; i++) {
			int sex = sc.nextInt(); // 성별
			int key = sc.nextInt(); // 키번호

			// 남자
			if (sex == 1) {				
				for (int j = key; j < bulbCnt; j += key) {
					if(status[j]==0)
						status[j] = 1;
					else if(status[j]==1)
						status[j] = 0;
					//전구 0이면 1 1이면 0으로 바꾸기
				}
			}
			// 여자
			else if (sex == 2) {				
				int leftBulb = key - 1;
				int rightBulb = key + 1;

				while (true) {
					if (leftBulb < 1 || rightBulb >= bulbCnt)
						break;
					if (status[leftBulb] != status[rightBulb]) {
						break;
					}
					leftBulb--;
					rightBulb++;
				} 
				//일단 key에서 하나 떨어진 값 만들고 if 첫번째는 끝까지 긴  문자열의 끝까지 가게 만든다.
				// if문 두번째는 같은 거리에 떨어진 전구의 상태가 일치하지 않으면 stop
				// 둘을 통해서 일치하는 것 중에 가장 먼 것을 찾는다.
				

				leftBulb++;
				rightBulb--;
				//최대에서 하나씩 줄인거
				
				for (; leftBulb <= rightBulb; leftBulb++) {
					if(status[leftBulb]==0)
						status[leftBulb] = 1;
					else if(status[leftBulb]==1)
						status[leftBulb] = 0;	
				}
				
			}
		}
		
		for (int j = 1; j < bulbCnt; j++) {
			System.out.print(status[j]+" ");
			if(j%20==0) {
				System.out.println("");
			} //문제 유의사항 끝까지 읽기 , if 이 부분에서 안해서 출력형식 오류가 남 
		}
	}
}
