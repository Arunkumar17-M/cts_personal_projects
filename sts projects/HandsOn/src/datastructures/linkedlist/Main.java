package datastructures.linkedlist;

public class Main {
	
	public static void main(String[] args) {
		
//		LinkedList<String> names = new LinkedList<>();
//		names.insert("Adam");
//		names.insert("Daniel");
//		names.insert("Ana");
//		
//		names.travasal();
//		
//		names.remove("Daniel");
//		names.travasal();
		
		LinkedList<Person> people = new LinkedList<>();
		Person p = new Person(23, "Adam");
		people.insert(p);
		people.insert(new Person(34, "Daniel"));
		people.insert(new Person(56, "Michale"));
		System.out.println(people.size());
		people.travasal();
		
		people.remove(p);
		people.travasal();
		System.out.println(people.size());

	}

}
