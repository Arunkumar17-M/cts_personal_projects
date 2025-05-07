package threadexample;

public class ThreadImplementation extends Thread{

	public static void main(String[] args) throws InterruptedException{
		
		Thread t = new Thread(()-> {
			System.out.println("run");
		});
		
		t.start();
		
		long start = System.currentTimeMillis();
		ThreadImplementation td = new ThreadImplementation();
		td.setPriority(MIN_PRIORITY);
		td.setName("td");
		td.start();
		
		td.interrupt();
		
		/*
		 * ThreadImplementation td1 = new ThreadImplementation();
		 * td1.setPriority(MAX_PRIORITY); td1.setName("td1"); td1.start();
		 */
		
//		td.join();
		System.out.println(Thread.currentThread().getName());
		for(int i=1; i<=10;i++) {
			System.out.print("i="+i+"\t");
//			Thread.sleep(1000);
		}
		long end = System.currentTimeMillis();
		System.out.println("\nTotal time taken "+(end - start)/1000f+" Seconds");
	}
	
	public void run() {
//		Thread.currentThread().setName("Check");
		System.out.println(Thread.currentThread().getName());
		for(int i=1; i<=10;i++) {
			System.out.print("j="+i+"\t");
//			Thread.yield();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Child thread Exiting");
			}
		}
	}
}
