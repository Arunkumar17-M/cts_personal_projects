package iostreams;

import java.util.Scanner;

public class HasNextDemo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		System.out.println("Enter the Nummber to calculate");
		while(scan.hasNextInt()) {// until read the value from console if give input is not an integer
			sum+=scan.nextInt();
		}
		System.out.println(sum);
	}
}
