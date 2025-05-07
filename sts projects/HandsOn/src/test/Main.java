package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String args[]) throws IOException {
		
		StringJoiner strJoiner = new StringJoiner(":","[","]");
		strJoiner.add("Peter");
		strJoiner.add("kumar");
		strJoiner.add("john");
		System.out.println(strJoiner);
		
		LocalDate date = LocalDate.ofYearDay(2020, 255);
		LocalDate dateof = LocalDate.of(2020, Month.MARCH, 31);
		
		System.out.println(date+" "+dateof);
		
		Circle circle = (double area) -> 3.14*area*area;
		System.out.println(circle.calculatearea(1d));
		
//		Path source = Paths.get("C:/Users/2159998/Arun Folder/need_data.txt/");
//		Path destination = Paths.get("C:/Users/2159998/Arun Folder/h2 database/change_data.txt/");
//		
//		Files.move(destination, source, StandardCopyOption.REPLACE_EXISTING);
		
		String url = "C:/Users/2159998/Arun Folder/need_data.txt/";
		
		Stream<String> stream = Files.lines(Paths.get(url));
		stream.forEach(System.out::println);
		
		List<String> list = Arrays.asList("Arun", "kumar", "goa");
		System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(",", "{", "}")));
	}
}
