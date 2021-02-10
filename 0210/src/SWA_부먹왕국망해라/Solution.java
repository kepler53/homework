package SWA_부먹왕국망해라;

import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc =new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); //도시 수
            int D = sc.nextInt(); //최대 거리
             
            int[] city = new int[N];
             
            for (int i = 0; i < N; i++) {
                city[i] = sc.nextInt();
            }
             
            int distance =0; //거리측정기
            int portalCnt =0; // 포탈 수
            for (int i = 0; i < N; i++) {
            	distance++;
                if(distance==D&&city[i]==0) {
                    distance =0;
                    portalCnt++;
                }
                else if(city[i]==1)
                    distance=0;
            }
            System.out.println("#"+tc+" "+portalCnt);
        }
    }
}