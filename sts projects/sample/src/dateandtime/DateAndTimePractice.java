package dateandtime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimePractice {
	public static void main(String[] args) {
		//display date
		LocalDate date=LocalDate.now();
		System.out.println("normal date using now() method: "+date);
		
		date=LocalDate.of(2019, 05, 20);
		System.out.println("change the date using of() method: "+date);
		
		//display time
		LocalTime time=LocalTime.now();
		System.out.println("normal Time using now() method: "+time);
		
		//display date and time
		LocalDateTime datetime=LocalDateTime.now();
		System.out.println("normal Date and Time using now() method: "+datetime);
		
		//zoned Date and Time
		ZonedDateTime zoned=ZonedDateTime.now();
		System.out.println("normal zoned date and time using now() method: "+zoned);
		
		//datetime formatter
		DateTimeFormatter format=DateTimeFormatter.ofPattern("E, dd-MMM-yyyy");
		
		String formattedDate=date.format(format);
		System.out.println("Formatted date: "+formattedDate);
		
		//age calculation using Period
		date=LocalDate.now();
		LocalDate dob=LocalDate.of(2001, 05, 17);
		int age=Period.between(dob, date).getYears();
		System.out.println("Age: "+age);
		
		//Duration between two time
		LocalTime finaltime=LocalTime.parse("19:00");
		int hour=(int)Duration.between(time, finaltime).getSeconds()/3600;
		System.out.println("Hour difference using Duration: "+hour);
	}
}
