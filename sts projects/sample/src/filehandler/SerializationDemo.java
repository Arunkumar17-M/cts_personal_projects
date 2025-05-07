package filehandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) {

		StudentDemo so = new StudentDemo(12, "kannan", "delhi", true);
		StudentDemo si;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			fos = new FileOutputStream("/Users/2159998/Arun Folder/FileReadAndWrite/test.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(so);
			System.out.println("Write Done");

			fis = new FileInputStream("/Users/2159998/Arun Folder/FileReadAndWrite/test.ser");
			ois = new ObjectInputStream(fis);
			si = (StudentDemo) ois.readObject();
			System.out.println(si);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
