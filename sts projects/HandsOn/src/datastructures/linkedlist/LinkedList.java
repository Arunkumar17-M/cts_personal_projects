package datastructures.linkedlist;

public class LinkedList<T extends Comparable<T>> implements List<T> {

	private Node<T> root;
	private int numOfItems;

	@Override
	public void insert(T data) {
		if (root == null) {
			root = new Node<>(data);
			numOfItems++;
		} else {
			insertEnd(data, root);
			numOfItems++;
		}
	}

	private void insertBeginning(T data) {

		Node<T> newNode = new Node<>(data);
		newNode.setNextNode(root);
		root = newNode;
	}

	private void insertEnd(T data, Node<T> node) {

		if(node.getNextNode()!=null) {
			insertEnd(data, node.getNextNode());
		}else {
			Node<T> newNode = new Node<>(data);
			node.setNextNode(newNode);
			numOfItems++;
		}
	}

	@Override
	public void remove(T data) {

		if(root == null) return;
		
		if(root.getData().compareTo(data) == 0) {
			root = root.getNextNode();
			numOfItems--;
		}else {
			remove(data, root, root.getNextNode());
		}
	}

	private void remove(T data, Node<T> previousNode, Node<T> actualNode) {

		while(actualNode != null) {
			if(actualNode.getData().compareTo(data) == 0) {
				
				numOfItems--;
				previousNode.setNextNode(actualNode.getNextNode());
				actualNode = null;
			}
		}
	}

	@Override
	public void travasal() {
		
		if(root == null) return;
		
		Node<T> actualNode = root;
		
		while(actualNode != null) {
			System.out.println(actualNode);
			actualNode = actualNode.getNextNode();
		}
	}

	@Override
	public int size() {
		return numOfItems;
	}

}
