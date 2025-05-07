package collections.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorPractice {
	
	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<>();
		
		list.add(3);
		list.add(4);
		list.add(2);
		list.add(6);
		System.out.println(list);
		Iterator<Integer> itr=list.iterator();// iterator can be used in both list and set
		
		while(itr.hasNext()) System.out.println(itr.next());
		
		itr.remove();
		System.out.println(list);
	}

}
