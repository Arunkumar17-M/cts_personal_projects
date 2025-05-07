package iostreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	
	// Serialization is process of writing object to stream.

	public static void main(String[] args) {

		try (FileOutputStream fos = new FileOutputStream("/Users/2159998/Arun Folder/FileReadAndWrite/test.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			Employee emp = new Employee(1, "Arun", "Developer", 12334);
			oos.writeObject(emp);
			System.out.println("File written");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (FileInputStream fis = new FileInputStream("/Users/2159998/Arun Folder/FileReadAndWrite/test.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			Object obj = ois.readObject();
			Employee emp = (Employee) obj;
			System.out.println(emp.id);
			System.out.println(emp.name);
			System.out.println(emp.role);
			System.out.println(emp.ssn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
