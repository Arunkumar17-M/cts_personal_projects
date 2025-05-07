package filehandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDemo {
	public static void main(String[] args) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File("/Users/2159998/Arun Folder/FileReadAndWrite/text.txt"));
			
			int i;
			while ((i = fis.read()) != -1) {
				System.out.print((char) i);
			}
			fis.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
