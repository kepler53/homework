package BOJ_2493;

import java.util.Scanner;
import java.util.Stack;

public class MainStack {

	static class Tower {
		public Tower(int index, int height) {
			this.index = index;
			this.height = height;
		}

		int index;
		int height;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TowerCnt = sc.nextInt();
		int[] result = new int[TowerCnt + 1];
		Stack<Tower> tower = new Stack<>();

		for (int i = 1; i <= TowerCnt; i++) {
			int h = sc.nextInt();
			// 입력부
			while (!tower.isEmpty()) {
				if (h > tower.peek().height)
					tower.pop();
				else {
					result[i] = tower.peek().index;
					break;
				}
			}
			if (tower.isEmpty())
				result[i] = 0;

			tower.push(new Tower(i, h));
			// 구현부
		}
		for (int i = 1; i <= TowerCnt; i++) {
			System.out.printf(result[i] + " ");
		}
		// 출력부
		sc.close();

	}

} //메모리 초과 뜸 왜 메모리 초과일까
