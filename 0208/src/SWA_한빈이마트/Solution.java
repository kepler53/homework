package SWA_한빈이마트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int TC;
    static int N;
    static int M;
    static int TWO = 2;
     
    static int[] weight;
     
    static int MAX;
     
    public static void main(String[] args) throws IOException {
         
//      Scanner sc =new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//       TC = sc.nextInt();
        TC = Integer.parseInt(br.readLine());
          
         for (int tc = 1; tc <= TC; tc++) {
              
//           N = sc.nextInt();
//           M = sc.nextInt();
              
             StringTokenizer st = new StringTokenizer(br.readLine());
              
             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());
              
              
             weight = new int[N];
              
//             MAX =0;
             
             StringTokenizer st2 = new StringTokenizer(br.readLine());
              
             for (int i = 0; i < N; i++) {
                weight[i] = Integer.parseInt(st2.nextToken());
            }
//           combination(0,0,0); 
//           combination2(0,0,0);
//           
//           if(MAX==0)
//               MAX=-1;
              
             // 재귀적으로 짰을 때 아무래도 O(N^2)인듯, 조합 두가지 방법 다 메모리 초과 
             // 하드코딩하기
             MAX =0;
             for (int i = 0; i < N; i++) {
                 for (int j = 0; j < N; j++) {
                     if(i==j)
                         continue;
                     else {
                         int sum = weight[i]+weight[j];
                         if(sum<=M&&sum>MAX)
                             MAX =sum;
                     }
                     
                }
            }
             if(MAX==0) MAX = -1;
              
             System.out.println("#"+tc+" "+MAX);
        }
    }
 
     
    //combination
    public static void combination(int cnt,int start,int weightSum) {
         
        if(cnt==TWO && weightSum<=M) {
            MAX = Math.max(MAX, weightSum);
            return;
        }
        if(start==N) {
            return;
        }
         
         
        //넣었을때 
         combination(cnt+1, start+1, weightSum+weight[start]);
         //안넣었을때
         combination(cnt,start+1,weightSum);
    }//메모리 너무 많이 사용
     
    static void combination2(int cnt,int start,int weightSum) {
         
        if(cnt==TWO && weightSum<=M) {
            MAX = Math.max(MAX, weightSum);
            return;
        }
        if(start==N) {
            return;
        }   
        for(int i = start;i<N;i++) {
            combination2(cnt+1,i+1,weightSum+weight[i]);
             
        }
         
    }//어떻게 linear하게 풀지? 걍 하드코딩
     
}

