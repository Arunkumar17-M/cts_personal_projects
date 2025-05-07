package iostreams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BufferedReaderDemo {

	public static void main(String[] args) {

		int count = 0;

		FileReader fr = null;
		BufferedReader br=null;

		try {
			fr = new FileReader("/Users/2159998/Arun Folder/FileReadAndWrite/text.txt");
			br = new BufferedReader(fr);
			String line;

			StringTokenizer st;
			while ((line = br.readLine()) != null) {
				st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					System.out.println(st.nextToken());
					count++;
				}
			}
			System.out.println(count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try(FileReader f = new FileReader("/Users/2159998/Arun Folder/FileReadAndWrite/text.txt");
				BufferedReader b = new BufferedReader(f);){
			//  this above statement we don't want to close the filereader and bufferedreader
			// JVM automatically close.
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
