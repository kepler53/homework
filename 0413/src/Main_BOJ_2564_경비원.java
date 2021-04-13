import java.util.Scanner;

public class Main_BOJ_2564_경비원 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt(); //가로길이
		int col = sc.nextInt(); //세로길이
		
		int N = sc.nextInt(); //상점수
		
		int[] arr = new int[N+1]; // 0~N-1 : 상점, N : 동근이 위치 , 직선상에서 절대적인 위치
		
//		System.out.println(row +" "+ col + " " + N);
		
		for (int i = 0; i <= N; i++) {
			
			int dir = sc.nextInt();
			int distance = sc.nextInt(); // 북,남쪽이면 왼쪽에서 떨어진 거리이고 서,동쪽이면 북쪽에서 떨어진 거리
			
			if(dir==1) {//북
				arr[i] = distance;
			}else if(dir==2) {//남
				arr[i] = row + col + row - distance;
			}else if(dir==3) {//서
				arr[i] = row + col + row + col -distance;
			}else if(dir==4) {//동
				arr[i] = row + distance;
			}
			
//			System.out.println(i +" " + arr[i]);
		}
		
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			
			int clockwise = Math.abs(arr[i]-arr[N]);
//			System.out.println(clockwise);
			int counterclockwise = 2*row + 2*col - clockwise;
//			System.out.println(counterclockwise);
			
			min = Math.min(clockwise, counterclockwise);
			result += min;
		}
		
		System.out.println(result);
	}

}
