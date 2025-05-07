package filehandler;

import java.io.Serializable;

public class StudentDemo implements Serializable {

	private int regno;
	private String name;
	private transient String address;
	private boolean pass;

	public StudentDemo() {
	}

	public StudentDemo(int regno, String name, String address, boolean pass) {
		super();
		this.regno = regno;
		this.name = name;
		this.address = address;
		this.pass = pass;
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "SerializationDemo [regno=" + regno + ", name=" + name + ", address=" + address + ", pass=" + pass + "]";
	}

}
