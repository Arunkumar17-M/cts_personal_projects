package collections.comparable;

public class Employee implements Comparable<Employee>{

	int id;

	String name;

	public Employee(int id, String name) {

		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Employee o) {
		int i1=this.id;
		int i2=o.id;
		if(i1<i2) return -1;
		else if(i1>i2) return 1;
		else return 0;
	}

}
