package com.jspiders.designpatterns.main;

import java.util.Scanner;

import com.jspiders.designpatterns.creational.Baleno;
import com.jspiders.designpatterns.creational.Car;
import com.jspiders.designpatterns.creational.Polo;
import com.jspiders.designpatterns.creational.Thar;
import com.jspiders.designpatterns.creational.XUV700;

public class CarMain {

	public static void main(String[] args) {
		System.out.println(
				"Enter 1 to order Thar\nEnter 2 order Baleno\nEnter 3 to order Polo\n" + "Enter 4 to order XUV700");
		System.out.println("Enter your choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.close();
		try {
			carFactory(choice).order();
		} catch (NullPointerException e) {
			System.out.println("Car is not ordered");
		}
	}

	private static Car carFactory(int choice) {
		Car car = null;
		switch (choice) {
		case 1:
			car = new Thar();
			break;
		case 2:
			car = new Baleno();
			break;
		case 3:
			car = new Polo();
			break;
		case 4:
			car = new XUV700();
			break;
		default:
			System.out.println("Invalid choice");
		}
		return car;
	}

}
