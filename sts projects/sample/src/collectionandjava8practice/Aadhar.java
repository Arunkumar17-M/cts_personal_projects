package collectionandjava8practice;

public class Aadhar implements Comparable<Aadhar> {

	private int aadharno;
	private String name;
	private Address address;

	public Aadhar(int aadharno, String name, Address address) {

		this.aadharno = aadharno;
		this.name = name;
		this.address = address;
	}

	public Aadhar() {
	}

	public int getAadharno() {
		return aadharno;
	}

	public void setAadharno(int aadharno) {
		this.aadharno = aadharno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Aadhar [aadharno=" + aadharno + ", name=" + name + ", address=" + address + "]\n";
	}

	@Override
	public int compareTo(Aadhar o) {
		int n1 = this.aadharno;
		int n2 = o.aadharno;

		return n1 - n2;
	}

}
