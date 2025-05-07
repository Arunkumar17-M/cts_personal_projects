package datastructures.stackinjava;

import java.util.Stack;

public class App {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<>();
		stack.push("Adam");
		stack.push("Bill");
		stack.push("Jeff");
		stack.push("Ana");
		
//		System.out.println(stack.peek());
		
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}

}
