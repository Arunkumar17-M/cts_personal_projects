package datastructures.doublelinkedlist;

public class DoubleLinkedList<T extends Comparable<T>> {

	private Node<T> head;
	private Node<T> tail;

	public void insert(T data) {

		Node<T> newNode = new Node<>(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.setPreviousNode(tail);
			tail.setNextNode(newNode);
			tail = newNode;
		}
	}

	public void travasalForward() {

		Node<T> actualNode = head;

		while (actualNode != null) {
			System.out.println(actualNode);
			actualNode = actualNode.getNextNode();
		}
	}

	public void travasalBackward() {

		Node<T> actualNode = tail;

		while (actualNode != null) {
			System.out.println(actualNode);
			actualNode = actualNode.getPreviousNode();
		}
	}

}
