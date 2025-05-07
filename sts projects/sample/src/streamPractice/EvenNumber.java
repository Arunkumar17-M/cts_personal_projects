package streamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();

		for (int i = 0; i <= 10; i++)
			l.add(i);
		System.out.println(l);

		List<Integer> collect = l.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(collect);

		collect = l.stream().map(i -> (i + 2)).collect(Collectors.toList());
		System.out.println(collect);

		Comparator<Integer> comp = (i1, i2) -> i1.compareTo(i2);

		collect = l.stream().sorted().collect(Collectors.toList());
		System.out.println(collect);

		Integer i = l.stream().max(comp).get();
		System.out.println(i);

		i = l.stream().min(comp).get();
		System.out.println(i);
		
		l.stream().forEach(k -> System.out.println(k));
		
		System.out.println("Total summ: "+l.stream().reduce(0, (x,y) -> x+y));
		
		System.out.println(Arrays.asList(1,2,3).stream().reduce(0, Integer::sum));
		
		
		Arrays.stream(new int[] {1,2,4,4}).forEach(as -> System.out.println(as));
		
		System.out.println(l.stream().reduce(0,(a,b) -> a+b));
		
		System.out.println(l.stream().max(Integer::compareTo).get());
		
		System.out.println(l.stream().sorted(Integer::compareTo).collect(Collectors.toList()));
				
		for(Integer d : l.stream().toArray(Integer[]::new)) System.out.println(d);
		
		List<String> asd = Arrays.asList("apple", "banana", "chiko");
		
		String result = asd.stream().collect(Collectors.joining(", ", "[", "]"));
		System.out.println(result);
		
	
		
	}

}
