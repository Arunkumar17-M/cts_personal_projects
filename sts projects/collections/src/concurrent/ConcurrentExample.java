package concurrent;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentExample {

	public static void main(String[] args) {
		
		CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<>();
		// for set use CopyOnWriteArraySet
		// this will allow concurrent read and write but write will be allowed 1 or 2 only
		// Normal arraylist will create exception.
		
		al.add("Java");
		al.add("python");
		al.add("AWS");
		al.add("Spring");
		
		Iterator<String> i = al.iterator();
		
		while(i.hasNext()) {
			String course = i.next();
			System.out.println(course);
			if(course.equals("AWS"))
				al.remove(course);
		}
		System.out.println(al);
		
		CopyOnWriteArraySet<String> as = new CopyOnWriteArraySet<>();
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
	}
}

