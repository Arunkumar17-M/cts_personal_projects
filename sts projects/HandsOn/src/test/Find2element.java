package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Find2element {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(3, 6, 32, 1, 8, 5, 31, 22, null));
//		below statement work without null.
//		System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
		System.out.println(list.stream().findFirst().get());
	}

}
