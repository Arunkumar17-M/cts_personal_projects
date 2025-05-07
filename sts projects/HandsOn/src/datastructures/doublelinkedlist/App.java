package datastructures.doublelinkedlist;

public class App {

	public static void main(String[] args) {
		
		DoubleLinkedList<String> names = new DoubleLinkedList<>();
		names.insert("Adam");
		names.insert("Kevin");
		names.insert("Ana");
		names.insert("Daniel");
		
		names.travasalBackward();

	}
}
