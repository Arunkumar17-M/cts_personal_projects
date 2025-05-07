package collections.comparator;

import java.util.Comparator;

public class Employee implements Comparator<Employee>{

	int id;

	String name;
	
	public Employee() {
	}

	public Employee(int id, String name) {

		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.name.compareTo(o2.name);
	}


}
