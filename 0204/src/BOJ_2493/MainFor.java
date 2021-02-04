package BOJ_2493;

import java.util.Scanner;

public class MainFor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TowerCnt = sc.nextInt();
		int[] tower = new int[TowerCnt+1];
		int[] receiver = new int[TowerCnt+1];

		for (int i = 1; i <= TowerCnt; i++) {
			tower[i] = sc.nextInt();
		}
		
		//�Էº�
		
		for (int i = 1; i <= TowerCnt; i++) {
			for (int j = i; j > 0; j--) {
				if (tower[j] > tower[i]) {
					receiver[i] = j;
					break;
				}
			}
		}
		//������
		
		for (int i = 1; i <=TowerCnt; i++) {
			System.out.print(receiver[i]+" ");
		}				

	}
}