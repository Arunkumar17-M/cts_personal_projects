package functions;

@FunctionalInterface
public interface MyInterface {

	public void method();
	
	default public void f1() {
		System.out.println("sdfs");
	}
	// in functional interface we can perform many default methods
}
