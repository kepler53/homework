package problem1_SWA_snailCount;

import java.util.Scanner;

public class Fail_Solution {
	 public static void main(String[] args) {
         
	        Scanner sc = new Scanner(System.in);
	         
	        int TC = sc.nextInt();
	        for(int tc=0;tc<TC;tc++) {
	 
	            int N = sc.nextInt();
	            int array[][] = new int[N][N];
	             
	            int length = N;
	            int R = 0, C=0; //���⼭ C�� 0���� �״��� ArrayIndexOutOfBounds ��, ���������� C���� �ٷ� ���ؼ� 0�� �Ǿ���ϴµ� 1�̵ǹ����� �� ���� ����
	            int direction =1;
	            int number =1;
	             
	            while(true){
	                if(length==0)
	                    break;
	                for (int i = 0; i < length; i++) {
	                    C+=direction;
	                    array[R][C] = number;
	                    number++;
	                }
	                length--;
	                for (int i = 0; i<length; i++) {
	                    R+=direction;
	                    array[R][C] = number;
	                    number++;
	                }
	                direction*=(-1);
	            }
	             
	            System.out.println("#" +(tc+1));
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < N; j++) {
	                    System.out.print(array[i][j]);
	                }
	                System.out.println();
	            }
	        }           
	    }
}
