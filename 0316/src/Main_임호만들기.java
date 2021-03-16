import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//조합 문제 => 따지자면 dfs?
public class Main_임호만들기 {
	
		static int L,C;
		static char[] alphabet; //알파벳 담을 원소들
		static char[] result; //원소의 결과를 담을 배열
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		L = Integer.parseInt(st.nextToken()); //조합 개수      수식으로 나타내면 c Combination l
		C = Integer.parseInt(st.nextToken()); //알파벳 수자
		
//		String str = br.readLine();
//		
//		alphabet = str.toCharArray(); => 이렇게 하면 빈 문자열 들어와서 length가 공백만큼 들어오게 됨
		
		
		alphabet = new char[C];
		result = new char[C];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0); // 이 부분 입력받는거 조심하기
//			System.out.println(alphabet[i]);
		}
		
//		for (int i = 0; i < alphabet.length; i++) {
//			System.out.print(alphabet[i]);
//		}
		Arrays.sort(alphabet);
		
		combination(0, 0, "");
	}
	
	static void combination(int cnt, int target, String letter) {
		//기저조건
		if(cnt == L) {
			int consonant = 0;
			int vowel = 0;
			
			for (int i = 0; i < letter.length(); i++) {
				if(letter.charAt(i)=='a'||letter.charAt(i)=='e'||letter.charAt(i)=='i'||letter.charAt(i)=='o'||letter.charAt(i)=='u') {
					vowel++;
				}else {
					consonant++;
				}	
			}
			if(vowel>=1 && consonant >=2) {
				System.out.println(letter);
			}			
			return;	
		}
		if(target == C) {
			return;
		}
		//넣었을 때
		combination(cnt+1,target+1,letter+alphabet[target]);
		//안넣었을때
		combination(cnt,target+1,letter);
	}
	//문제 풀면서 틀렸던 점
	//1. 공백으로 값을 받아서 저장될 때 길이가 초과되었던점
	//2. 70번 line에 alphabet[target]이 아니라 alphabet[cnt]를 해서 틀린점 => index 사용할 때 주의하자.....
}
