import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution_SWEA1868_파핑파핑지뢰찾기 {
    
    static int[] ni = {-1,-1,-1,0,1,1,1,0};
    static int[] nj= {-1,0,1,1,1,0,-1,-1};
    
    static char[][] map;
    static boolean[][] visit;
    static int N;
    static int count=0;
    
    
    static Queue<Point> queue;
    
    static class Point{
        int i,j;
        public Point(int i,int j) {
            this.i=i;this.j=j;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        
        for(int tc=1;tc<=T;tc++) {
            N=Integer.parseInt(br.readLine());
            map=new char[N][N];
            visit= new boolean[N][N];
            queue=new LinkedList<>();
            
            for(int i=0;i<N;i++) {
                String str=br.readLine();
                for(int j=0;j<N;j++) {
                    map[i][j]=str.charAt(j);
                }
            }
            
            count=0;
            bfs();
            System.out.println("#"+tc+" "+count);
        }
        
        
    }
    
    static boolean checkZero(int i,int j) {
        boolean zero=true;
    
        for(int d=0;d<8;d++) {
            int nextX= i+ni[d];
            int nextY= j+nj[d];
            
            if(nextX<0 || nextX>=N || nextY<0 || nextY>=N)
                continue;
            
            if(map[nextX][nextY]=='*') {
                zero=false;
                break;
            }
        }
        return zero;
    }
    
    static void bfs() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]=='.' && visit[i][j]==false && checkZero(i, j)==true) {
                    queue.offer(new Point(i, j));
                    visit[i][j]=true;
                    count++;
                    
                    while(!queue.isEmpty()) {
                        Point now =queue.poll();
                        
                        for(int d=0;d<8;d++) {
                            int nextX= now.i+ni[d];
                            int nextY= now.j+nj[d];
                            
                            if(nextX<0 || nextX>=N || nextY<0 || nextY>=N)
                                continue;
                            
                            if(map[nextX][nextY]=='.' && visit[nextX][nextY]==false) {
                                if(checkZero(nextX, nextY)) {
                                    queue.add(new Point(nextX, nextY));
                                    visit[nextX][nextY]=true;
                                }else
                                    visit[nextX][nextY]=true;
                            }
                        }
                    }
                }
                
            }
        }
        
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]=='.' && visit[i][j]==false) {
                    count++;
                }
            }
        }
    }
}