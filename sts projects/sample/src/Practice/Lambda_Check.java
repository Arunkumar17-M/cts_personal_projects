package Practice;

public class Lambda_Check {
	
	public static void main(String[] args) {
		Thread t1=new Thread(() ->{
			for(int i=0;i<=10;i++) {
				if(i%2==0) System.out.println("Even Number: "+i);
			}
		});
		Thread t2=new Thread(() ->{
			for(int i=0;i<=10;i++) {
				if(i%2!=0) System.out.println("Odd Number: "+i);
			}
		});
		Thread t3=new Thread(() ->{
			for(int i=0;i<=10;i++) System.out.println("Number: "+i);
		});
		
		t1.start();
		t2.start();
		t3.start();
			try {
				t3.join();
				t2.join();
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
