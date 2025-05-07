package exceptionhandling;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

class Updation extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Updating..");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Printer extends Thread {
	public void run() {
		for (int i = 1; i < 6; i++) {
			System.out.println(i);
		}
	}
}

public class ThreadRunner {
	public static void main(String[] args) {
		Updation update = new Updation();
		Printer print = new Printer();
		update.start();
		print.start();
	}
}