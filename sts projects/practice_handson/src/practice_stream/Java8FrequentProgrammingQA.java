package practice_stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8FrequentProgrammingQA {
	
	static String input = "findAllDuplicateElementFromAGivenString";
	
	public static void countNumberOfCharacterWithoutStream() {
		
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : input.toLowerCase().toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		map.keySet().stream().forEach(s -> System.out.println(s+"="+map.get(s)));
	}

	public static void countNumberOfCharacter() {
		
		Map<String,Long> map = Arrays.stream(input.toLowerCase().split(""))
//				.collect(Collectors.groupingBy(s -> s))  --> this will return the Strin and List<String> like a = [a, a]
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.keySet().stream().forEach(s -> System.out.println(s+"="+map.get(s)));
	}
	
	public static void findAllDuplicateElementFromAGivenString() {
		
		Arrays.stream(input.toLowerCase().split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(r -> r.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList())
				.forEach(s -> System.out.print(s+" "));
	}
	
	public static void main(String[] args) {
		
//		countNumberOfCharacterWithoutStream();
		countNumberOfCharacter();
		findAllDuplicateElementFromAGivenString();
	}
}
