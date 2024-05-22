package com.jspiders.contactmanager.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.jspiders.contactmanager.operations.ContactOperations;

public class ContactMain {

	private static boolean loop = true;
	private static ContactOperations operations = new ContactOperations();

	public static void main(String[] args) {
		while (loop) {
			menu();
		}
	}

	private static void menu() {

		System.out.println("Welcome to Contact Manager");
		System.out.println("1. View all contacts\n" + "2. Add new contact\n" + "3. Edit contact\n"
				+ "4. Remove contact\n" + "5. Search contact\n" + "6. Exit");
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		try {
		choice = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input! Please enter a number!");
			menu();
		}
		switch (choice) {
		case 1:
			operations.viewAllContacts();
			break;

		case 2:
			operations.addContact();
			break;

		case 3:
			operations.editContact();
			break;

		case 4:
			operations.removeContact();
			break;

		case 5:
			System.out.println("Search Menu\n"
					+ "1. Search by first name\n"
					+ "2. Search by last name\n"
					+ "3. Search by mobile number\n"
					+ "4. Search by email\n"
					+ "5. Search by company\n"
					+ "6. Search by group\n"
					+ "7. Go back");
			Scanner scanner2 = new Scanner(System.in);
			int choice2 = scanner2.nextInt();
			switch (choice2) {
			case 1:
				operations.searchByFirstName();
				break;
			case 2:
				operations.searchByLastName();
				break;
				
			case 3:
				operations.searchByMobileNumber();
				break;
				
			case 4:
				operations.searchByEmail();
				break;
				
			case 5:
				operations.searchByCompany();
				break;
				
			case 6:
				operations.searchByGroup();
				break;
				
			case 7:
				menu();
				break;

			default:
				System.out.println("Invalid choice. Please try again!");
				break;
			}
			break;

		case 6:
			loop = false;
			scanner.close();
			System.out.println("Thank you! See you again!");
			break;
		default:
			System.out.println("Invalid choice. Please try again!");
			break;
		}

	}

}
