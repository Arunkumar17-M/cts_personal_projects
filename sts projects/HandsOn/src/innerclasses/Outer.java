package innerclasses;

public class Outer {
	
	
	void f1() {
		System.out.println("f1 Outer method");
	}
	
	void f3() {
		System.out.println("Outer method f3()");
		
		class Inner{
			void f1() {
				System.out.println("Inner class of f3 function");
			}
		}
		Inner inner = new Inner();
		inner.f1();
	}
	
	class Inner{
		
		void f2() { // we cannot able to make any method to static if the class is non static.
			System.out.println("f2 Inner method");
			Outer.this.f1(); // this is to access the outer class method or variables
		}
	}
	
	public static void main(String[] args) {
		
		Outer outer = new Outer();
		outer.f1();
		
		outer.f3();
		
//		new Outer().f1();
		
		Outer.Inner inner = outer.new Inner();
		inner.f2();
		
		AnonymousConnection con = AnonymousDriverManager.getconnection();
		con.createStatement();
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("Anonymous Runnable Implementation");
			}
		});
		t.start();
	}

}
