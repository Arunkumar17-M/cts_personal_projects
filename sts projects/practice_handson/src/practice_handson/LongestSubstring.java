package practice_handson;

public class LongestSubstring {

	public static int[] findLongestUniformSubstring(String str) {

		if (str.length() == 0)
			return new int[] { -1, 0 };
		if (str.length() == 1)
			return new int[] { 0, 1 };

		int index = 0;
		int maxCharCount = 0;
		int count = 1;
		int i;
		for (i = 1; i < str.length(); i++) {

			if (str.charAt(i) == str.charAt(i - 1))
				count++;
			else {
				if (count > maxCharCount) {
					maxCharCount = count;
					index = i - count;
				}
				count = 1;
			}
		}
		if (count > maxCharCount) {
			return new int[] { i - count, count };
		}

		return new int[] { index, maxCharCount };
	}

	public static void main(String[] args) {

		String s = "110000000011";
		int[] printlong = findLongestUniformSubstring(s);
		System.out.println(printlong[0] + " " + printlong[1]);
		
		System.out.println((int)(Math.random() * 10));
		
		
	}
}
