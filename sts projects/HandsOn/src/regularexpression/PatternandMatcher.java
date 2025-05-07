package regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternandMatcher {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("abc");
		Matcher matcher = pattern.matcher("abcohigabckuhsidufabcijoidrabc");
		
		while(matcher.find()) {
			System.out.println(matcher.start());
			System.out.println(matcher.end());
			System.out.println(matcher.group());
		}
		
		Pattern p1= Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9_.-]+$");
		Matcher m1 = p1.matcher("arun@gamil.com");
		
//		String email = "arun@gmail.com";
//		if(email.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9_.-]+$"))
		if(m1.matches())
			System.out.println("Valid Email");
		else
			System.out.println("Invalid Email");
		
	}
}
