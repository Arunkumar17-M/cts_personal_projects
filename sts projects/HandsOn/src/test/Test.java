package test;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		String hello = "This is Hello World";
		int count = 0;
		
		for(int i = 0 ;i< hello.length(); i++) {
			char ch = hello.charAt(i);
			if(ch == 'l')
				count++;
//			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {}
//				System.out.print(ch);
//			
//			System.out.println();
			
			if("aeiouAEIUO".indexOf(ch) != -1)
				System.out.print(ch);
		}
//		Arrays.stream(hello.toCharArray()).
		System.out.println(count);
		
		Thread th = new Thread(() -> {
			for(int i = 0; i< 100 ; i++) {
				if(i%2 == 0)
					System.out.println("Even Thread"+i);
			}
		});
		
		Thread th1 = new Thread(() -> {
			for(int i = 0; i< 100 ; i++) {
				if(i%2 != 0)
					System.out.println("Odd Thread"+i);
			}
		});
		
//		th.start();
//		th1.start();
//		th.setName("Even");
//		th1.setName("Odd");
		System.out.println(th.getName()+" "+th1.getName());
		
	}
}
