package com.java.first;

import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int height = sc.nextInt();
		int weight = sc.nextInt();
		int overWeight = weight+100-height;
		
		System.out.println("�񸸼�ġ��"+overWeight+"�Դϴ�.");
		
		if(overWeight>0) {
			System.out.println("����� ���̱���");
		}
		
		
	}
}
