package collections.list;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ArrayAndLinkedListMethods {
	
	public static void main(String[] args) {
		List<Integer> list= new ArrayList<>();
		//Ease Access, insert and delete is time consume
		//initial capacity is 10
		//if data increase the value of arraylist, it create new arraylist with more capacity
		// and those data will change to new Arraylist
		
		Random r= new Random();
		
		for(int i=0;i<=10;i++)
			list.add(r.nextInt(100));
		
		System.out.println(list);
		
		//add the value into the specific location of list
		list.add(3, 43);
		System.out.println(list);
		
		List<Integer> secondlist=new ArrayList<>();
		
		secondlist.add(111);
		secondlist.add(222);
		secondlist.add(333);
		
		//list.addAll(secondlist);// add the list at the end
		//add the list in to the specific location
		list.addAll(3, secondlist);
//		list.remove(3);
//		list.remove(list.indexOf(111));
		System.out.println(list);
		list.set(8, 88);// replace the value in the specific location
		System.out.println(list);
		
		//contain check the value is in the list
		if(list.contains(111)) System.out.println("contains 111");;
		
		//containsall check the list present in another list
		if(list.containsAll(secondlist)) System.out.println("present");
		
		// size and get method
		System.out.println(list.size()+" "+list.get(4));
		
		//to replace the value
		list.set(3, 5555);
		System.out.println(list);
		
		List<String> linkedlist=new LinkedList<>();
		// Slow Random Access , insert and delete is fast
		// more memory consume
		// to test time System.currentTimeMillis() for start and end and find the difference will give the 
		// milliseconds value.
		
		linkedlist.add("asda");
		linkedlist.add("dgsdf");
		
		ListIterator<String> itr = linkedlist.listIterator();
		
		
		System.out.println(itr.next());
		System.out.println(itr.next());
		System.out.println(itr.previous());
	}

}
