
public class DigitTest2 {
	public static void main(String[] args) {
		
		int line = 3; //중간부분 +1인 line의 넘버로 생각함 
		
		int count = 1;
		  for (int i = 0 ; i < line ; i++) {
		   for (int j = 0 ; j < i ; j++)
		    System.out.print("   ");
		   
		   for (int j = 0 ; j < (line+(line-1))-(2*i) ; j++) {
		    System.out.printf("%3d", count);
		    count++;
		   }
		   
		   for (int j = 0 ; j < i ; j++)
		    System.out.print("   ");
		   
		   System.out.println();
		  }
		 
		  for (int i = line-1 ; i > 0 ; i--) {
		   for (int j = 0 ; j < i-1 ; j++)
		    System.out.print("   ");
		   
		   for (int j = (line+(line-1)) ; j > (i-1)*2 ; j--) {
		    System.out.printf("%3d", count);
		    count++;
		   }
		   
		   for (int j = 0 ; j < i ; j++)
		    System.out.print("   ");
		   
		   System.out.println();
		  }
		}

		
}
