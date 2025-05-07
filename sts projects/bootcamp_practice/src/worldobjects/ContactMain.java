package worldobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactMain {

	static Scanner scan = new Scanner(System.in);

	public static Contact[] contactData() {
		return new Contact[] { new Contact("John Doe", "555-123-4567", "1985-01-01"),
				new Contact("Jane Smith", "555-987-6543", "1990-02-14"),
				new Contact("Alice Johnson", "555-345-6789", "1975-03-30"),
				new Contact("Bob Brown", "555-567-8910", "2000-12-25"),
				new Contact("Charlie Davis", "555-111-2222", "1983-07-04"),
				new Contact("Diana White", "555-333-4444", "1997-11-18"),
				new Contact("Ethan Green", "555-555-6666", "1988-05-22"),
				new Contact("Fiona Black", "555-777-8888", "2002-10-31") };
	}

	public static void displayContacts(ContactManager contactManager) {
		for (int i = 0; i < 8; i++) {
			Contact contact = contactManager.getContact(i);
			System.out.println(contact);
			System.out.println("\n");
		}
	}

	public static Contact editedContact() {

		Contact contact = new Contact();
		System.out.print("\tName: ");
		// pick up name
		contact.setName(scan.next());

		System.out.print("\tPhone Number: ");
		// pick up number
		contact.setPhoneNumber(scan.next());

		System.out.print("\tBirth Date: ");
		// pick up birth date
		contact.setBirthDate(scan.next());

		// return a Contact object
		return contact;
	}

	public static void main(String[] args) {

		ContactManager contactManager = new ContactManager(contactData());
		displayContacts(contactManager);

		System.out.print("\nYou have 8 contacts. Enter 'continue' to edit them: ");
		String status = scan.nextLine();

		while (status.equals("continue")) {
			System.out.print("\nChoose an index from 0 to 7: ");
			int index = scan.nextInt();
			contactManager.setContact(editedContact(), index);
			System.out.println("\n\nUPDATED CONTACTS\n\n");
			displayContacts(contactManager);
			scan.nextLine();
			System.out.print("Enter 'continue' to make more changes: ");
			status = scan.nextLine();

		}
		
		String str = "asdf";
		System.out.println(str.substring(4).length());

//		Contact contact1 = new Contact("Alice", "123-456-7890", "1990-01-01");
//	    Contact contact2 = new Contact("Bob", "234-567-8901", "1992-02-02");
//	    Contact contact3 = new Contact("Charlie", "345-678-9012", "1994-03-03");
//	    Contact contact4 = new Contact("David", "456-789-0123", "1996-04-04");
//	    
//	    Contact copyContact1 = new Contact(contact1);
//	    Contact copyContact2 = new Contact(contact3);  
//	    
//	    contact1.setBirthDate("1989-01-01");

//		Contact contact1 = new Contact("Alice", "123-456-7890", "1990-01-01");
//		Contact contact2 = new Contact("Bob", "234-567-8901", "1992-02-02");
//
//		Contact[] contacts = { contact1, contact2 };
//		ContactManager contactManager = new ContactManager(contacts);
//
//		// Test the getContact method
//		Contact retrievedContact = contactManager.getContact(0);
//		System.out.println(retrievedContact.getName());
//
//		// Test the setContact method
//		Contact newContact = new Contact("Charlie", "345-678-9012", "1994-03-03");
//		contactManager.setContact(newContact, 0);
//
//		// Verify that the contact was updated
//		retrievedContact = contactManager.getContact(0);
//		System.out.println(retrievedContact.getName());

	}

}
