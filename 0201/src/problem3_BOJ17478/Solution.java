package problem3_BOJ17478;

import java.util.Scanner;

public class Solution {
	
	static Scanner sc = new Scanner(System.in);
	static int input = sc.nextInt();
	static int underbarCnt = 0;
	
	public static void main(String[] args) {
		
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		chatBot(input);
	}
	
	public static void chatBot(int n) {
		underbarAdd(underbarCnt);
		System.out.println("\"����Լ��� ������?\"");
		if(n==0) {
			underbarAdd(underbarCnt);
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");			
			for(int i=underbarCnt+1;i>0;i--) {
				underbarAdd(underbarCnt);
				System.out.println("��� �亯�Ͽ���." +"");
				underbarCnt--;
			}
			return;
		}
		
		underbarAdd(underbarCnt);
		System.out.println("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		underbarAdd(underbarCnt);
		System.out.println("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		underbarAdd(underbarCnt);
		System.out.println("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		underbarCnt++;
		
		chatBot(n-1);
	}
	
	public static void underbarAdd(int a) {
		for(int i=0; i<a ;i++) {
			System.out.print("____");
		}
	}
}
