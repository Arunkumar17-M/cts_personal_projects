package iostreams;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {

		String s = "Your, destiny, is, on, your, hand";

		StringTokenizer st = new StringTokenizer(s);
		StringTokenizer st1 = new StringTokenizer(s, ",");

		while (st.hasMoreTokens())
			System.out.println(st.nextToken());
		
		while (st1.hasMoreTokens())
			System.out.println(st1.nextToken());
	}
}
