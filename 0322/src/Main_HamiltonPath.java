import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
//해밀턴 경로 순열 문제에 파라미터 넘겨서 처리하기
 
public class Main_HamiltonPath {
    static int N;
    static int map[][];
    static boolean visit[];
    static int result;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1]; 
        visit = new boolean[N+1];
 
        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                 
            }
        }
         
        result = Integer.MAX_VALUE;
 
        perm(0,1,0);
        System.out.println(result);
    }
 
    static void perm(int cnt, int index, int sum ) { //파라미터 하나 더 있어야겠는 데??? 지금 뽑힌 값의 번호를 알기 위해서
        //cnt : 여태까지 뽑은 개수, index : 뽑은 출발점의 index, sum : 경로 합 
        //기저조건
        //1 :cnt값이 N-1일 때
        if(cnt==N-1) {
        	if(map[index][1]!=0) { //마지막에 돌아가는 경로가 없으면 안됨
        		result = Math.min(result, sum+map[index][1]);
        	} //마지막에 회사로 돌아가는 값 처리  
             // => 계속sum+map[index][0]으로 계산하고 있었음....
            return;
        }
        //2 :sum이 기존 result보다 클 때, 가지치기 하기 위해
        if(sum>result) {
            return;
        }
         
        //구현
        for (int i = 2; i < N+1; i++) {
            if(map[index][i]!=0&&!visit[i]) { //갈 수 있는 경우 : 값이 0이 아니고 방문한적 없을 때 
                visit[i] = true;
                perm(cnt+1,i,sum+map[index][i]);
                visit[i] = false;           
            }   
        }   
    }
}