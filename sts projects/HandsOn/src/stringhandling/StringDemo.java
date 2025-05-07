package stringhandling;

public class StringDemo {

	public static void main(String[] args) {

		byte b[] = { 65, 66, 67 };

		String s1 = new String(b);
		System.out.println(s1);
		
		Integer i = new Integer(1341);
		System.out.println(i); // Integer wrapper type not printing reference name instead it print number
		
		String s2 = "abc";
		String s3 = "xas";
		String s4 = "abc";
		
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		
		StringBuffer sb = new StringBuffer("asdasd");
		StringBuffer sb1 = new StringBuffer();
		System.out.println(sb1.capacity());
		sb1 = sb;
		sb.reverse();
		System.out.println(sb);
		System.out.println(sb1);
		
		StringBuilder sbu = new StringBuilder("Arun");
		StringBuilder sbu1 = new StringBuilder();
		System.out.println(sbu1.capacity());
		sbu1 = sbu;
		sbu.reverse();
		System.out.println(sbu);
		System.out.println(sbu1);
		
	}
}
