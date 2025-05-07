package worldobjects;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Contact {

	private String name;
	private String phoneNumber;
	private String birthDate;
	private int age;
	
	public Contact() {}

	public Contact(String name, String phoneNumber, String birthDate) {

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.age = toAge(birthDate);
	}

	public Contact(Contact contact) {

		this.name = contact.name;
		this.phoneNumber = contact.phoneNumber;
		this.birthDate = contact.birthDate;
		this.age = contact.age;
	}

	private int toAge(String birthDate) {

		Period period = Period.between(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
				LocalDate.now());
		return period.getYears();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	private void setAge(int age) {
		this.age = age;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
		setAge(toAge(birthDate));
	}

	public String toString() {
		return "Name: " + this.name + "\n" + "Phone number: " + this.phoneNumber + "\n" + "Birth Date: "
				+ this.birthDate + "\n" + "Age: " + this.age + " year old\n";
	}

}
