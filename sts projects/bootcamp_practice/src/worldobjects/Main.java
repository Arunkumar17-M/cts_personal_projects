package worldobjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
 
	public static void main(String[] args) {

		Car car = new Car("rayan", "India", "01﻿/﻿01﻿/﻿1111",
				new String[] { "Rayan Slim", "Canadian", "01﻿/﻿01﻿/﻿1111" }, 5);
//		car.name = "rayan";
//		car.nationality = "India";
//		car.dateOfBirth = "01﻿/﻿01﻿/﻿1111";
//		car.passport = new String[] {"Rayan Slim", "Canadian", "01﻿/﻿01﻿/﻿1111"};
//		car.seat = 5;

		String[] seat = car.getPassport();
		seat[0] = "kumar";

		Car see = car;
		see.setName("asdf");

		System.out.println(car.getName());
		System.out.println(car.getNationality());
		System.out.println(car.getDateOfBirth());
		System.out.println(Arrays.toString(car.getPassport()));
		System.out.println(car.getSeat());

		Map<Car, Integer> hashMap = new HashMap<>();
		hashMap.put(car, 1);

		Car car2 = new Car("asdf", "India", "01﻿/﻿01﻿/﻿1111",
				new String[] { "kumar", "Canadian", "01﻿/﻿01﻿/﻿1111" }, 5);
		hashMap.put(new Car("rayan", "India", "01﻿/﻿01﻿/﻿1111",
				new String[] { "Rayan Slim", "Canadian", "01﻿/﻿01﻿/﻿1111" }, 5), 2);

		System.out.println(car2.hashCode());
		System.out.println(new Car("rayan", "India", "01﻿/﻿01﻿/﻿1111",
				new String[] { "Rayan Slim", "Canadian", "01﻿/﻿01﻿/﻿1111" }, 5).hashCode());
		System.out.println(hashMap.get(car2));
		

	}
}

//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		String str = "abcd";
//		System.out.println(str.substring(4,4));
////		permute(str, "");
//	}
//
//	static void permute(String str, String prefix) {
//		if (str.length() == 0) {
//			System.out.println(prefix);
//		} else {
//			for (int i = 0; i < str.length(); i++) {
//				String rem = str.substring(0, i) + str.substring(i + 1);
//				permute(rem, prefix + str.charAt(i));
//			}
//		}
//	}
//}
