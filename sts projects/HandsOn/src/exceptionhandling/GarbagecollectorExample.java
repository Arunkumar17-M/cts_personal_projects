package exceptionhandling;

public class GarbagecollectorExample {
	
	static void add(int i, int j) {
		System.out.println("First method");
	}
	
	static void add(long i, int j) { System.out.println("Second Method");}

	public static void main(String[] args) {
		
		new GarbagecollectorExample(); // this is unreachable object so, garbage collect this object.
		GarbagecollectorExample.add(0, 0);
		GarbagecollectorExample.add(2L, 5);
		System.gc(); // this method is garbage collection.
		//If we comment the above statement finalize method won't work
	}
	
	@Override
	protected void finalize() {
		System.out.println("Finished garbage collection");
	}
}
