package geeksforgeekspractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		
		String name = "Arun Kumar";
		
		Map<Character, Integer> map = new HashMap<>();
		name = name.toLowerCase();
		for(Character ch : name.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		map.entrySet().forEach(k -> System.out.println(k));
		
	}
}
