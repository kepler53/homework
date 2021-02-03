package SWA_SanghoTank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] di = { 0, 1, 0, -1 };
		int[] dj = { -1, 0, 1, 0 };
		char[] pointer = { '<', 'v', '>', '^' };

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			char[][] map = new char[R][C];

			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			int lineLength = Integer.parseInt(br.readLine());
			String line = br.readLine();
			char[] action = new char[lineLength];
			for (int i = 0; i < lineLength; i++) {
				action[i] = line.charAt(i);
			}
			int dir = 0;
			int tankX = 0;
			int tankY = 0;

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					for (int d = 0; d < pointer.length; d++) {
						if (map[i][j] == pointer[d]) {
							tankX = i;
							tankY = j;
							dir = d;
						}
					}
				}
			}
			
			for (int i = 0; i < lineLength; i++) {

				switch (action[i]) {
				case 'U':
					dir = 3;
					break;
				case 'R':
					dir = 2;
					break;
				case 'D':
					dir = 1;
					break;
				case 'L':
					dir = 0;
					break;
				}

				map[tankX][tankY] = pointer[dir]; //탱크의 위치 초기화하기, 이부분에서 1시간 반 걸림

				if (action[i] == 'S') {
					for (int k = 1; k <= 20; k++) {
						int nx = tankX + k * di[dir];
						int ny = tankY + k * dj[dir];

						if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '#')
							break;
						else if (map[nx][ny] == '*') {
							map[nx][ny] = '.';
							break;
						}
					}

				} else {
					int nx = tankX + di[dir];
					int ny = tankY + dj[dir];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') { 
						map[tankX][tankY] = '.';
						map[nx][ny] = pointer[dir];
						tankX = nx;
						tankY = ny;
					}
				}

			}

			System.out.print("#" + (tc + 1) + " ");
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					System.out.print(map[j][k]);
				}
				System.out.println();
			}

		}
	}
}
/* 	이 문제에서 실수한 점 : 탱크의 초기화를 안해서 test case에서 대부분은 돌아가지만 안 돌아간 점
 * 	그리고 input받을 때 어떻게 받을지 계속 고민하기 buffered_reader를 통한 공백 부분
 */
