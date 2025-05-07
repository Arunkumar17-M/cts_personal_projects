package practice_handson;

import java.util.Map;
import java.util.TreeMap;

public class CountNumberOfCharacterinString {
	
	public static void countNumCharInStr(String name) {
		
		Map<Character, Integer> map = new TreeMap<>();
		for(int i = 0; i<name.length(); i++) {
			
			char ch = name.charAt(i);
			if(map.get(ch) == null)
				map.put(ch, 1);
			else
				map.put(ch, map.get(ch)+1);
		}
		
		for(char ch : map.keySet()) {
			System.out.println(ch+"="+map.get(ch));
		}
	}

	public static void main(String[] args) {
		
		CountNumberOfCharacterinString.countNumCharInStr("malayalam");
	}
}
