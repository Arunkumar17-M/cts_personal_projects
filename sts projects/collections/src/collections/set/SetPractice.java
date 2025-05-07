package collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetPractice {

	public static void main(String[] args) {

		Set<Integer> set = new HashSet<>();
		// hashset will not maintain the order the way we insert in the set
		// but Linkedhashset will maintain the order the way we insert in the set.
		set.add(4);
		set.add(3);
		set.add(6);
		set.add(10);
//		set.add(null);
		set.add(54);
		System.out.println(set);
		
		Set<Integer> treeset = new TreeSet<>(set);

		System.out.println(treeset);
		
		Set<String> strset=new TreeSet<>();
		
		strset.add("asd");
		strset.add("aad");
		strset.add("xyz");
		strset.add("bcd");
		
		System.out.println(strset);
		
		Set<StringBuffer> sbset=new TreeSet<>();
		
		sbset.add(new StringBuffer("asd"));
		sbset.add(new StringBuffer("aasd"));
		sbset.add(new StringBuffer("zxcvdsd"));
		sbset.add(new StringBuffer("hasdif"));
		System.out.println(sbset);
	}
}
