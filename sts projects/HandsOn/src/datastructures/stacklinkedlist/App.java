package datastructures.stacklinkedlist;

public class App {

	public static void main(String[] args) {
		
		Stack<String> names = new Stack<>();
		names.push("Adam");
		names.push("Ana");
		names.push("Kevin");
		names.push("Michael");
		
		while(!names.isEmpty()) {
			System.out.println(names.pop());
		}
	}
}
