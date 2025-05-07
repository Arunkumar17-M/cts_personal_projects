package static_and_nonstatic;

public class StaticAndNonStatic {
	
	static {
		System.out.println("Static Block");
	}

	{
		System.out.println("NonStatic Block");
	}
	
	public StaticAndNonStatic() {

		System.out.println("Constructor block");
	}
	
	static int iu;
	
	int l;
	
	static void staticfunc() {
		System.out.println("StaticFunction");
		StaticAndNonStatic f=new StaticAndNonStatic();
		f.nonstaticfunc();
	}
	
	void nonstaticfunc() {
		System.out.println("out");
		staticfunc();
		System.out.println(iu+""+l);
	}
	
	public static void main(String[] args) {
		
		new StaticAndNonStatic();
		new StaticAndNonStatic();
		
		int i; // if i not initialized then we can't print it
		
		i=45;
		Integer it = Integer.valueOf(i);
		System.out.println(it);// convert primitives to object
		
		System.out.println(it.intValue());// convert object to primitives
		
		String s = Integer.toString(i);
		System.out.println(s);
		
		Long l = Long.valueOf(s);
		System.out.println(l);
		
		l =new Long(s);System.out.println(l);
		
		i = Integer.parseInt(s);System.out.println(i);
		
		Runnable r = () -> System.out.println("asd");
		Thread t = new Thread(r);
		t.start();
	}
}
