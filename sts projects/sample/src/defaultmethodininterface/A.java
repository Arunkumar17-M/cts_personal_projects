package defaultmethodininterface;

public interface A {
	
	default void m1() {
		System.out.println("inside interface A");
	}

}
