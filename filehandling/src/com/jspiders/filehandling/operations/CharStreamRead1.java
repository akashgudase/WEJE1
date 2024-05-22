package com.jspiders.filehandling.operations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamRead1 {

	public static void main(String[] args) {

		File file = new File("demo.txt");
		if (file.exists()) {
			try {
				FileReader fileReader = new FileReader(file);
				int ch = fileReader.read();
				System.out.println((char)ch);
				System.out.println("Data is fetched from the file");
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File does not exist");
		}

	}

}
