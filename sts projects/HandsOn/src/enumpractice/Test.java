package enumpractice;

public class Test {
	
	public static void main(String[] args) {
		
		EnumExample e = EnumExample.ATM;
		System.out.println(e);
		
		AbstractExample ab = new AbstractExample() {
			
			@Override
			void b() {
				// TODO Auto-generated method stub
				System.out.println("A");
			}
			
			@Override
			void a() {
				// TODO Auto-generated method stub
				System.out.println("B");
			}
		};
		
		ab.a();
		ab.b();
	}
	

}
