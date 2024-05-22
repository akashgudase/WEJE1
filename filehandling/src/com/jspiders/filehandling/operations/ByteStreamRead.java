package com.jspiders.filehandling.operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamRead {

	public static void main(String[] args) {

		File file = new File("demo.txt");
		if (file.exists()) {
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				int b = fileInputStream.read();
				System.out.println(b);
				System.out.println("Data is fetched from the file");
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File does not exist");
		}

	}

}
