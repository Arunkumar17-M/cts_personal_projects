package practice_handson;

public class ReverseString {

	public static void main(String[] args) {

		String s = "asdsdfgf";
		char[] array = s.toCharArray();
		int n = s.length();
		for (int i = 0; i < n / 2; i++) {

			char temp = array[i];
			array[i] = array[n - 1 - i];
			array[n - 1 - i] = temp;
		}
		String result = "";
		for(char ch : array) result +=ch;
		System.out.println(result);
	}

}
