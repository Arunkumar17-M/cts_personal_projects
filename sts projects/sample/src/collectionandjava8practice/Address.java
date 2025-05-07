package collectionandjava8practice;

public class Address {

	private String doorno;
	private String street;
	private String district;
	private String state;

	public Address(String doorno, String street, String district, String state) {

		this.doorno = doorno;
		this.street = street;
		this.district = district;
		this.state = state;
	}

	public Address() {
	}

	public String getDoorno() {
		return doorno;
	}

	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [doorno=" + doorno + ", street=" + street + ", district=" + district + ", state=" + state + "]\n";
	}

}
