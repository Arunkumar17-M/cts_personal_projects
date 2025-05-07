package collections.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashMapAndTreeMap {

	public static void main(String[] args) {
		Map<Integer, String> map=new HashMap<>();
		map.put(1, "arun");
		System.out.println(map);
		map.replace(1,"asd");
		System.out.println(map.containsValue("asd"));
		
		Map<String, String> treemap=new TreeMap<>();
		
		treemap.put("asd","asde");
		treemap.put("gas", "aaad");
		treemap.put("aaa", null);
		
		System.out.println(treemap);
		Set<String> keySet = treemap.keySet();
		System.out.println(keySet);
		
		for(String s : keySet) {
			System.out.println("Key:"+s+", Value:"+treemap.get(s));
		}
		
		Collection<String> values = treemap.values();
		System.out.println(values);
		
		Map<String, String> link=new LinkedHashMap<>();
		link.put("asd","asde");
		link.put("gas", "aaad");
		link.put("aaa", null);
		System.out.println(link);
	}
}
