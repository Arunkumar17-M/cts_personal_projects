package classobjectmethods;

public class Test {

	public static void main(String[] args) {

		Electricity e1 = new Electricity(433, "murugasan", "salem");
		System.out.println("toString method:\n" + e1);
		System.out.println("Hashcode to show the meterNo:" + e1.hashCode());

		Electricity e2 = new Electricity(433, "Tharun", "salem");
		System.out.println("using equals method to check the meterNo same:" + e1.equals(e2));

		Electricity e3 = e1;

		System.out.println("put the object e1 to e3:" + e3.equals(e1));
	}

}
