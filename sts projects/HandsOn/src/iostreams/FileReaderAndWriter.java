package iostreams;

import java.io.FileReader;
import java.io.FileWriter;


public class FileReaderAndWriter {

	public static void main(String[] args)throws Exception {
		
		FileReader fr = new FileReader("/Users/2159998/Arun Folder/FileReadAndWrite/filereaderdemo.txt");
		FileWriter fw = new FileWriter("/Users/2159998/Arun Folder/FileReadAndWrite/filewriterdemo.txt");
		
		//file Reader and writer is used for efficient using of read or write file of character.
		int data;
		while((data=fr.read())!=-1) {
			fw.write(data);
		}
		
		fr.close();
		fw.close();
	}
}
