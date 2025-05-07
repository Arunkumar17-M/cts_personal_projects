package iostreams;

import java.io.Serializable;

public class Employee implements Serializable {

	int id;
	String name;
	String role;
	transient int ssn;

	Employee(int id, String name, String role, int ssn) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.ssn = ssn;
	}

}
