package problem1_SWA1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWA_1249 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		int TC = Integer.parseInt(br.readLine());
		//int TC = sc.nextInt();
		// ���� �����ٽ� ��� ����¿��� nextInt() �κа� next()�κ��� ������, �����ؼ� �ٿ������� ���� ��� �ȵǰ� ������ϸ� ��

		for (int i = 0; i < TC; i++) {
			// int[] array = br.readLine();
			// ��� ��� ���߿� �ٲܰ�����
			// array�޾ƿ°� ��� �ϳ��� �����°�
			// StringTokenizer�� ��������
			char[] array = br.readLine().toCharArray();
			// �����ؾ��� ���� ����� �Ϻ��ϰ� �ϱ�(��� ���� ���� �� �κ�)
			char init = '0';
			int count = 0;

			for (int j = 0; j < array.length; j++) {
				if (init != array[j]) {
					count++;
					init = array[j];
				}
			}
//			System.out.println(i);
//			System.out.println(array);
			System.out.println("#" + (i + 1) + " " + count);
		}
	}
}
