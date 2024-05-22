package com.jspiders.filehandling.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharStreamRead2 {

	public static void main(String[] args) {

		File file = new File("demo.txt");
		if (file.exists()) {
			try {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					System.out.println(scanner.nextLine());
				}
				System.out.println("Data is fetched from the file");
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File does not exist");
		}

	}

}
