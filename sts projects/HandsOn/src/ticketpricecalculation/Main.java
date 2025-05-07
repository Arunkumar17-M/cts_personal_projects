package ticketpricecalculation;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Ticket t=new Ticket();
		System.out.println("Enter no of bookings:");
		int bookings=sc.nextInt();
		System.out.println("Enter the available Tickets:");
		Ticket.setAvailableTickets(sc.nextInt());
		int nooftickets;
		for(int i=0;i<bookings;i++) {
			System.out.println("Enter the ticketid");
			t.setTicketid(sc.nextInt());
			System.out.println("Enter the price:");
			t.setPrice(sc.nextInt());
			System.out.println("Enter the no of tickets:");
			nooftickets=sc.nextInt();
			System.out.println("Available Tickets: "+Ticket.getAvailableTickets());
			System.out.println("Total amount: "+t.calculateTicketCost(nooftickets));
			System.out.println("Available ticket after booking:"+Ticket.getAvailableTickets());
		}
	}

}
