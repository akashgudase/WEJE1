package com.jspiders.filehandling.operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamWrite {

	public static void main(String[] args) {
		
		File file = new File("demo.txt");
		if(file.exists()) {
			try {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write("Data from the java program");
				System.out.println("Data is written to a file");
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				file.createNewFile();
				System.out.println("File is created");
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write("Data from the java program");
				System.out.println("Data is written to a file");
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
