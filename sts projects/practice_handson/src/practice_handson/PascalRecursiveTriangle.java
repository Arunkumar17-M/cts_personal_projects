package practice_handson;

public class PascalRecursiveTriangle {
	
	public static int pascalValue(int i, int j) {
		
		if(j == 0 || i == j) return 1;
		
		return pascalValue(i-1, j-1) + pascalValue(i-1, j);
	}

	public static void pascalTriangle(int rows) {
		
		for(int i = 0; i< rows; i++) {
			for(int k = 0; k<=rows-i; k++) {System.out.print(" ");}
			for(int j = 0; j<=i; j++)
				System.out.print(pascalValue(i,j)+" ");
			System.out.println();
		}
	}
	
	public static void anotherPrintPascal(int rows) {
		
		for(int line = 1; line <= rows; line++) {
			
			for(int space = 0; space <= rows-line ; space++) System.out.print(" ");
			
			int C = 1;
			for(int k = 1; k <= line; k++) {
				
				System.out.print(C+" ");
				C = C * (line-k) / k;
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		pascalTriangle(20);
//		anotherPrintPascal(5);
	}
}
