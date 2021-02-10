package SWA_삼성시버스정류장;

import java.util.Scanner;

public class Solution {
     
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int tc = 1; tc <= T; tc++) {
             
             
            int[] busStop = new int[5001]; //이거 설정안해서 런타임 에러남 1번 인덱스부터 쓸거면 무조건 N+1하기, 까먹지말기
            int N = sc.nextInt(); //버스 수 
             
            for (int i = 0; i < N; i++) {
                int start = sc.nextInt(); //출발점 
                int end = sc.nextInt();  //종점
                 
                for (int j = start; j <= end; j++) {
                    busStop[j]++;
                }
            }
             
            int P =sc.nextInt();
             
            int[] busStopNum = new int[P]; //정류장 번호 받기 
             
            for(int i=0;i<P;i++) {
                busStopNum[i] = sc.nextInt();
            }
             
             
             
            System.out.print("#"+tc+" ");
            for (int i = 0; i < busStopNum.length-1; i++) {
                System.out.print(busStop[busStopNum[i]]+" ");               
            }
            System.out.print(busStop[busStopNum[P-1]]);
            System.out.println();
        }
    }
 
}