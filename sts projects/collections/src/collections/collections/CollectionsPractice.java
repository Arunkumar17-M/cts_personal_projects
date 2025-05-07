package collections.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsPractice {

	public static void main(String[] args) {
				
		List<String> list=new ArrayList<>();
		
		list.add("D");
		list.add("A");
		list.add("Z");
		list.add("B");
		
		System.out.println(list);
//		Collections.sort(list); // normal sort without comparator
		Collections.sort(list, (i1,i2) -> i2.compareTo(i1)); // with comparator for descending order
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
		
		Integer a[]= {3,4,1,7,2,5,4};
		Arrays.sort(a);
		for(int i:a) System.out.print(i);
		System.out.println();
		
		Arrays.sort(a, (i1, i2) -> i2.compareTo(i1));
		//System.out.println(Collections.max(Arrays.asList(a)));
		// we can find the minimum and maximum of array using this above statement
		for(int i:a) System.out.print(i);
		System.out.println();
		
		List<Integer> al=Arrays.asList(a);
		System.out.println(al);
		a[2]=9; // we can change the value of array that reflect in list
		//but change the value in the list will raise an exception
		System.out.println(al);
		
	}
}
