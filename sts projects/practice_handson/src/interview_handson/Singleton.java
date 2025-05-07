package interview_handson;

public class Singleton implements Cloneable {
	private static Singleton instance;

	private Singleton() {
		// Private constructor to prevent instantiation
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) {
		try {
			Singleton instance1 = Singleton.getInstance();
			Singleton instance2 = (Singleton) instance1.clone();

			System.out.println("Instance 1 hashCode: " + instance1.hashCode());
			System.out.println("Instance 2 hashCode: " + instance2.hashCode());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
