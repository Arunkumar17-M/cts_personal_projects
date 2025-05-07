package com.cts.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderTest {
	
	public static void test() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		for(int i=0;i<10;i++) {
			String encoded = encoder.encode("Password#123#@#$");
			System.out.println(encoded);
		}
		
	}
//	public static void main(String[] args) {
//
//		BCryptEncoderTest.test();
//	}

}
