package IM대비;

import java.util.Arrays;
import java.util.Scanner;
 
public class Solution_테네스의소수 {
  
    //소수를 어떻게 구하지?? =구한 값들을 primeNum배열에 넣는다. 도저히 구하다가 못봐서 소수 구하는 법 구하는 개념을 검색해서 가져
    //primeNum 배열들로 String.valueof(primeNum).contains(D)이면 카운트 ++;
	//아니면 while문 소수 %10이 D이면 cnt++ break;,소수/10 
    //카운트 출력 
     
    public static void main(String[] args) {
        int MAX = 1000000; //범위 10의6승 
        int[] primeNum = new int[MAX+1]; //1번부터 사용하려 MAX+1 선언 
        Arrays.fill(primeNum, 1);
        primeNum[0] = 0;
        primeNum[1] = 0;
        for(int i=2; i<=Math.sqrt(MAX); i++) {
            for(int j=i*2; j<=MAX; j+=i) primeNum[j] = 0;
        }
        //도저히 생각을 못함, 생각난건 골든바흐의 정리만 생각나고 에라토스테네스의 체를 구현하는 법을 몰랐
         
         
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            String D = sc.next();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int count = 0;
            for(int index=A; index<=B; index++) {
                if( primeNum[index] == 0 ) continue;
                if( String.valueOf(index).contains(D) ) count++;
            }
            System.out.println("#"+tc+" "+count);
        }
        sc.close();
    }
}