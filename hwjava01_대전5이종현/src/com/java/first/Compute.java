package com.java.first;

import java.util.*;

public class Compute {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		int multiply = num1 * num2;
		try {
			int quotient = num1 / num2;
			System.out.println("��=" + multiply);
			System.out.println("��=" + quotient);
		} catch (ArithmeticException e) {
			System.out.println("�ι�° ������ 0�� �Է��Ͻ� �� �����ϴ�.");
		}

	}
}
