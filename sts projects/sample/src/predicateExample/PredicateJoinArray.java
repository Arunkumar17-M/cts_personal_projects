package predicateExample;

import java.util.function.Predicate;

public class PredicateJoinArray {
	
	public static void main(String[] args) {
		
		int x[]= {0,7,10,20,30,40,50,60,70,73};
		Predicate<Integer> p= i -> i>10;
		Predicate<Integer> p1= i -> i%2==0;
		
		
		System.out.println(p.negate().test(3));
		
		System.out.println("Greater than 10:");
		method1(p, x);
		
		System.out.println("Even Numbers:");
		method1(p1,x);
		
		System.out.println("Odd numbers:");
		method1(p1.negate(), x);
		
		System.out.println("Greater than 10 and Even Numbers:");
		method1(p.and(p1),x);
		
		System.out.println("Greater than 10 or Even Numbers:");
		method1(p.or(p1), x);
		
	}
	
	static void method1(Predicate<Integer> p,int x[]) {
		for(int a: x) {
			if(p.test(a)) System.out.println(a);
		}
	}

}
