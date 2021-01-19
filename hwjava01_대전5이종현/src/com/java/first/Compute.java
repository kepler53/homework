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
			System.out.println("곱=" + multiply);
			System.out.println("몫=" + quotient);
		} catch (ArithmeticException e) {
			System.out.println("두번째 값으로 0을 입력하실 수 없습니다.");
		}

	}
}
