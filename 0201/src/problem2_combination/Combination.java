package problem2_combination;



public class Combination {
	static String[] arr = {"A","B","C","D"};
	static boolean used[] = new boolean[arr.length];
	static int R =2;
	public static void main(String[] args) {
		comb(0,0);
	}
	
	static void comb(int target, int count) {
		if(count == R) {
			for(int i=0;i<used.length;i++) {
				if(used[i])
					System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
	}
	
		if(target == arr.length)
			return;
		//ArrayIndexOutOfBounds를 막기 위해
		
		used[target] = true;
		comb(target+1,count+1);
		used[target] = false;
		comb(target+1,count);
		
		//다시 그림 그려서 해보기
	}
}
