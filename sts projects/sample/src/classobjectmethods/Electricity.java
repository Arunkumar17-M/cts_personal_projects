package classobjectmethods;

public class Electricity {
	
	private int meterNo;
	private String name;
	private String address;
	
	public Electricity() {
	}
	
	public Electricity(int meterNo, String name, String address) {
		super();
		this.meterNo = meterNo;
		this.name = name;
		this.address = address;
	}

	public int getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(int meterNo) {
		this.meterNo = meterNo;
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
	
	@Override
	public int hashCode() {
		return this.meterNo;
	}

	@Override
	public boolean equals(Object obj) {
		Electricity e=(Electricity) obj;
		return (this.hashCode()==e.hashCode())?true:false;
	}
	
	@Override
	public String toString() {
		return "Electricity [meterNo=" + meterNo + ", name=" + name + ", address=" + address + "]";
	}
	
}
