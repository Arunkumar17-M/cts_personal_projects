package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {
		
	static{
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(new Employee("John", 25, 5000.0), new Employee("Alice", 22, 6000.0),
				new Employee("Bob", 30, 7000.0), new Employee("Charlie", 28, 6500.0), new Employee("Dave", 35, 8000.0),
				new Employee("Eve", 33, 7500.0), new Employee("Eve", 28, 7500.0), new Employee("Frank", 40, 9000.0),
				new Employee("Grace", 38, 8500.0), new Employee("Heidi", 45, 10000.0), new Employee("Ivan", 43, 9500.0),
				new Employee("Judy", 50, 11000.0));
		// we can't modify above Arrays.asList.
		employees.set(0, new Employee("Charlie", 28, 6500.0));
				
		List<Employee> empo = new ArrayList<>(employees);
		empo.remove(0);
		empo.stream().forEach(System.out::println);
		List.of(new Employee("John", 25, 5000.0), new Employee("John", 25, 5000.0));

		List<Employee> sort = employees.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		System.out.println(sort);

		// Sort by name (ascending order)

		employees.stream().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
				.forEach(System.out::println);
		System.out.println("//");

		// Sort by age (descending order)

		employees.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).forEach(System.out::println);
		System.out.println("//");

		// Sort by salary (ascending order)

		employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
		System.out.println("//");

		// Sort by name, but for employees with the same name, sort by age (ascending
		// order for both)

//		employees.stream().sorted((o1, o2) -> {
//			if(o1.getName().equalsIgnoreCase(o2.getName())) return o1.getAge()-o2.getAge();
//			return o1.getName().compareTo(o2.getName());
//		}).forEach(System.out::println); // this work good but below code is optimal.

		employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge))
				.forEach(System.out::println);
//		String s="";
		StreamPractice sa = new StreamPractice();
		
		System.out.println();
	}
}
