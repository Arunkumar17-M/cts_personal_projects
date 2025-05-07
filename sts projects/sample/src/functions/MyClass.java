package functions;

public class MyClass {
	
	public static void method1() {
		System.out.println("Method Reference");
	}
	
	 public static void main(String[] args) {
		MyInterface f=MyClass::method1;
		
		f.method();
		
		MyInterface f1 = () -> System.out.println("MyInterface method");
		f1.method();
		
		f1 =MyClass::method1;
		f1.method();
	}

}
