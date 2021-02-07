package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2910 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int lineLength = Integer.parseInt(br.readLine());
		String str = br.readLine();
		char[] line = new char[lineLength];
		int sCount = 0;
		int lCount = 0;
		int cupCnt = 0;
		for (int i = 0; i < lineLength; i++) {
			line[i] = str.charAt(i);
			if(line[i]=='S')
				sCount++;
			else if(line[i]=='L')
				lCount++;
		}
		
		cupCnt = 1+sCount+lCount/2;
		
		int person =0;
		if(lineLength<cupCnt)
			person = lineLength;
		else
			person = cupCnt;
		
		System.out.println(person);
		
	}

}