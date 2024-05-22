package com.jspiders.contactmanager.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jspiders.contactmanager.entity.Contact;
import com.jspiders.contactmanager.jdbc.ContactJDBC;

public class ContactOperations {

	private static List<Contact> allContacts = new ArrayList<>();

	public void viewAllContacts() {
		if (allContacts.isEmpty()) {
			System.out.println("No contacts to display. Add contacts first?\n" + "1. Yes\n" + "2. No");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			if (choice == 1) {
				addContact();
			}

		}
		for (Contact contact : allContacts) {
			System.out.println(contact);
		}
	}

	public void addContact() {
		System.out.println("Enter the details of the contact");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter contact id : ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter first name : ");
		String firstName = scanner.nextLine();
		System.out.print("Enter last name : ");
		String lastName = scanner.nextLine();
		System.out.print("Enter mobile number : ");
		long mobileNumber = scanner.nextLong();
		scanner.nextLine();
		System.out.print("Enter email : ");
		String email = scanner.nextLine();
		System.out.print("Enter company name : ");
		String company = scanner.nextLine();
		System.out.print("Select group\n" + "1. Friends\n" + "2. Family\n" + "3. Colleague");
		int choice = scanner.nextInt();
		String group = "";
		switch (choice) {
		case 1:
			group = "Friends";
			break;
		case 2:
			group = "Family";
			break;
		case 3:
			group = "Colleague";
			break;
		default:
			System.out.println("Invalid choice.");
			break;
		}
		Contact contact = new Contact(id, firstName, lastName, mobileNumber, email, company, group);
		allContacts.add(contact);
		System.out.println("Contact added successfully!");
		ContactJDBC.addContact(id, firstName, lastName, mobileNumber, email, company, group);

	}

	public void editContact() {
		// TODO Auto-generated method stub

	}

	public void removeContact() {
		// TODO Auto-generated method stub

	}

	public void searchByFirstName() {
		// TODO Auto-generated method stub

	}

	public void searchByLastName() {
		// TODO Auto-generated method stub

	}

	public void searchByMobileNumber() {
		// TODO Auto-generated method stub

	}

	public void searchByEmail() {
		// TODO Auto-generated method stub

	}

	public void searchByCompany() {
		// TODO Auto-generated method stub

	}

	public void searchByGroup() {
		// TODO Auto-generated method stub

	}

}
