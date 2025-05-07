package worldobjects;

import java.util.Arrays;
import java.util.Objects;

public class Car {

	String name;
	private String nationality;
	private String dateOfBirth;
	private String[] passport;
	private int seat;

	public Car(String name, String nationality, String dateOfBirth, String[] passport, int seat) {
		super();
		this.name = name;
		this.nationality = nationality;
		this.dateOfBirth = dateOfBirth;
		this.passport = passport;
		this.seat = seat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String[] getPassport() {
		return passport;
	}

	public void setPassport(String[] passport) {
		this.passport = passport;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(passport);
		result = prime * result + Objects.hash(dateOfBirth, name, nationality, seat);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(name, other.name)
				&& Objects.equals(nationality, other.nationality) && Arrays.equals(passport, other.passport)
				&& seat == other.seat;
	}
	
	

}
