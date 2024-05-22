package com.jspiders.filehandling.operations;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamWrite {

	public static void main(String[] args) {

		File file = new File("demo.txt");
		if (file.exists()) {
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(257);
				System.out.println("Data is written to the file");
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				file.createNewFile();
				System.out.println("File is created");
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(257);
				System.out.println("Data is written to the file");
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
