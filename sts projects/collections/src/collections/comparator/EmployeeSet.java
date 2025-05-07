package collections.comparator;

import java.util.Set;
import java.util.TreeSet;

public class EmployeeSet{
	
	public static void main(String[] args) {
		Set<Employee> set=new TreeSet<>(new Employee());
		
		set.add(new Employee(100,"sas"));
		set.add(new Employee(300,"asf"));
		set.add(new Employee(200,"dgff"));
		set.add(new Employee(500,"arun"));
		
		for(Employee emp: set) {
			System.out.println(emp);
		}
		
	}

}
