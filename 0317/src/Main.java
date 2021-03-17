import java.util.Scanner;

//순열인지 조합인지 헷갈림 => 생각자체가 줄 세우는거여서 순열로 풀었는데 조합 문제였음 시간초과됨 => 경우의수가 최대 20P10 드럽게 크네.....
//20C10 

public class Main {
	private static int[][] map;
	private static boolean[] used;
	private static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		used = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		min = Integer.MAX_VALUE;
//		Permutation(0);
		Combination(0, 0);
		System.out.println(min);
	}

//    public static void Permutation(int index) {
//    	//기저조건
//        if (index == map.length / 2) {
//            int startTeam = 0; //스타트팀 점수
//            int linkTeam = 0; //링크팀 점수
//            for (int i = 0; i < map.length - 1; i++) {
//                for (int j = i + 1; j < map.length; j++) {
//                    if (used[i] && used[j]) { //사용중이면 스타트팀에 배정
//                        startTeam += (map[i][j] + map[j][i]);
//                    } else if (!used[i] && !used[j]) { //아니면 링크팀에 배정 , 순서는 상관없는 것 같음, 어차피 절대값으로 구할거여서
//                        linkTeam += (map[i][j] + map[j][i]);
//                    }
//                }
//            }
//            min = Math.min(min, Math.abs(startTeam - linkTeam));
//            return;
//        }
//        for (int i = 0; i < map.length; i++) {
//            if (!used[i]&&index!=i) {
//                used[i] = true;
//                Permutation(index + 1);
//                used[i] = false;
//            }
//        }
//
//    }

	// 조합버젼 1 사용해보기

	public static void Combination(int start, int cnt) {
		if (cnt == map.length / 2) {
			int startTeam = 0;
			int linkTeam = 0;
			for (int i = 0; i < map.length - 1; i++) {
				for (int j = i + 1; j < map.length; j++) {
					if (used[i] && used[j]) {
						startTeam += (map[i][j] + map[j][i]);
					} else if (!used[i] && !used[j]) {
						linkTeam += (map[i][j] + map[j][i]);
					}
				}
			}
			min = Math.min(min, Math.abs(startTeam - linkTeam));
			return;
		}
		for (int i = start; i < map.length; i++) {
			if (!used[i]) {
				used[i] = true;
				Combination(i + 1, cnt + 1);
				used[i] = false;
			}
		}
	}
}