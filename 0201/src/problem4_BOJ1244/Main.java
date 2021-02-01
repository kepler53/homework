package problem4_BOJ1244;

import java.util.Scanner;

public class Main {

	static int bulbCnt, stuNum;
	static int[] status;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		bulbCnt = sc.nextInt() + 1;

		status = new int[bulbCnt]; //�������� �迭
		for (int i = 1; i < bulbCnt; i++) {
			status[i] = sc.nextInt();
		}

		stuNum = sc.nextInt(); // �л� ��
		for (int i = 1; i <= stuNum; i++) {
			int sex = sc.nextInt(); // ����
			int key = sc.nextInt(); // Ű��ȣ

			// ����
			if (sex == 1) {				
				for (int j = key; j < bulbCnt; j += key) {
					if(status[j]==0)
						status[j] = 1;
					else if(status[j]==1)
						status[j] = 0;
					//���� 0�̸� 1 1�̸� 0���� �ٲٱ�
				}
			}
			// ����
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
				//�ϴ� key���� �ϳ� ������ �� ����� if ù��°�� ������ ��  ���ڿ��� ������ ���� �����.
				// if�� �ι�°�� ���� �Ÿ��� ������ ������ ���°� ��ġ���� ������ stop
				// ���� ���ؼ� ��ġ�ϴ� �� �߿� ���� �� ���� ã�´�.
				

				leftBulb++;
				rightBulb--;
				//�ִ뿡�� �ϳ��� ���ΰ�
				
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
			} //���� ���ǻ��� ������ �б� , if �� �κп��� ���ؼ� ������� ������ �� 
		}
	}
}
