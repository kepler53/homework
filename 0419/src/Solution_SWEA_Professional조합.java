import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SWEA_Professional조합 {
	
	
	static int N, R;
	static final long p = 1234567891;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			
			N = sc.nextInt();
			R = sc.nextInt();
			
			long[] factorial = new long[N+1];
			factorial[0] = 1;
			for (int i = 1; i <=N; i++) {
				factorial[i] = (factorial[i-1]*i)%p;	
			}
//			for (int i = 0; i < factorial.length; i++) {
//				System.out.println(factorial[i]);
//			}
//			System.out.println(p);
			long denomiator = factorial[N];
			long numerator = factorial[R]*factorial[N-R]%p;
			
//			System.out.println("denomi"+denomiator);
//			System.out.println(numerator);
//			System.out.println(power(numerator, 2));
//			System.out.println("power"+power(numerator, p-2));
//			
			long fermat = (denomiator%p*power(numerator, p-2))%p;
			
			System.out.println("#"+tc+" "+fermat%p);
		}
	}
	
	
	static long power(long a, long b) {
		if(b==0) return 1;
		if(b==1) return a;
		long temp = power(a, b/2)%p;
		long result = temp*temp%p;
//		System.out.println(a+" "+ b + " "+result);
		
		if(b%2==0) {
			return result%p;
		}else {
			return a*result%p;
		}
	}
}
