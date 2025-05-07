package iostreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileHandling {

	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("/Users/2159998/Arun Folder/FileReadAndWrite/text.txt");
			fos = new FileOutputStream("/Users/2159998/Arun Folder/FileReadAndWrite/copytext.txt");
			// this is used to read or write binary data of the file.
			System.out.println("File Opened");
			int i;
			while ((i = fis.read()) != -1) {
				System.out.print((char) i);
				fos.write(i); // this is write the data of the another file to new file
				// we can write or read any type extension of file eg .jpg, .txt, .pdf, etc,.
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
				System.out.println("\nFile Closed");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
