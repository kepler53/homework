package com.ssafy.algo;

import java.util.*;
import java.io.*;

/*
 * 델타 방식으로 짜지 않은 방식 => 추후에 다시 짜보기
 * */
public class Solution22 {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {

//			StringTokenizer st = new StringTokenizer(br.readLine()); // exception 던지기
//			int N = Integer.parseInt(st.nextToken());
//			int wsNum = Integer.parseInt(st.nextToken());
			
			int N = sc.nextInt();
			int wsNum = sc.nextInt();

			

			boolean[][] pondUsed = new boolean[N][N];
			int[][] wsPosition = new int[N][N];

			for (int j = 0; j < wsNum; j++) {
//				int a = Integer.parseInt(st.nextToken());
//				int b = Integer.parseInt(st.nextToken());
//				int c = Integer.parseInt(st.nextToken());
				
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();

				wsPosition[a][b] = c;
				pondUsed[a][b] = true;
				// 소금쟁이 위치 받기
			}
			// line 34부터 다시 델타로 짜보기
			for (int d = 0; d < N; d++) {
				for (int e = 0; e < N; e++) {
					
					
					// 위 방향
					if (wsPosition[d][e] == 1) {
						
						if (d - 3 < 0 || d - 3 >= N || pondUsed[d - 3][e]) {
							wsNum--;
						} else if (d - 5 < 0 || d - 5 >= N || pondUsed[d - 5][e]) {
							wsNum--;
						} else if (d - 6 < 0 || d - 6 >= N || pondUsed[d - 6][e]) {
							wsNum--;
						} else {
							pondUsed[d - 6][e] = true;
						}
					}
					// 아래방향
					if (wsPosition[d][e] == 2) {
						
						if (d + 3 < 0 || d + 3 >= N || pondUsed[d + 3][e]) {
							wsNum--;
						} else if (d + 5 < 0 || d + 5 >= N || pondUsed[d + 5][e]) {
							wsNum--;
						} else if (d + 6 < 0 || d + 6 >= N || pondUsed[d + 6][e]) {
							wsNum--;
						} else {
							pondUsed[d + 6][e] = true;
						}
					}
					// 왼쪽
					if (wsPosition[d][e] == 3) {
						
						if (e - 3 < 0 || e - 3 >= N || pondUsed[d][e - 3]) {
							wsNum--;
						} else if (e - 5 < 0 || e - 5 >= N || pondUsed[d][e - 5]) {
							wsNum--;
						} else if (e - 6 < 0 || e - 6 >= N || pondUsed[d][e - 6]) {
							wsNum--;
						} else {
							pondUsed[d][e - 6] = true;
						}
					}
					// 오른쪽
					if (wsPosition[d][e] == 4) {
						
						if (e + 3 < 0 || e + 3 >= N || pondUsed[d][e + 3]) {
							wsNum--;
						} else if (e + 5 < 0 || e + 5 >= N || pondUsed[d][e + 5]) {
							wsNum--;
						} else if (e + 6 < 0 || e + 6 >= N || pondUsed[d][e + 6]) {
							wsNum--;
						} else {
							pondUsed[d][e + 6] = true;
						}
					}
				}
			}
			System.out.println("#"+i+" "+wsNum);
		}
	}
}