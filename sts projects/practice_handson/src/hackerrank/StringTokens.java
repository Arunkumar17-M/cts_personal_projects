package hackerrank;

import java.util.Scanner;

public class StringTokens {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String s = "              ";
		System.out.println(s.isEmpty());
		s = s.trim();
		System.out.println();
		String[] arraystr = s.split("[!,?._@ ]+");
		System.out.println(arraystr.length);
		for(String str : arraystr) System.out.println(str);
	}
}
