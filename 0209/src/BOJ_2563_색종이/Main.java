package BOJ_2563_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dfs 아님 , bfs 아님, stack,queue 아님,list나 트리로 풀 문제도 아님 

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int paperCnt = Integer.parseInt(br.readLine());
		
		boolean[][] whitePaper = new boolean[101][101];
		
		for (int i = 0; i < paperCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int paperX = Integer.parseInt(st.nextToken());
			int paperY = Integer.parseInt(st.nextToken());
			
			for (int j = paperX; j < paperX+10; j++) {
				for (int k = paperY; k < paperY+10; k++) {
					whitePaper[j][k] = true;
				}				
			}
		}
		
		int areaCnt =0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j <100; j++) {
				if(whitePaper[i][j])
					areaCnt++;	
			}			
		}
		System.out.println(areaCnt);
	}

}
