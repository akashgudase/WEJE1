package com.jspiders.filehandling.operations;

import java.io.File;

public class DeleteFile {
	
	public static void main(String[] args) {
		
		File file = new File("D:\\File\\demo.java");
		if(file.exists()) {
			boolean status = file.delete();
			if(status) {
				System.out.println("File is deleted");
			}else {
				System.out.println("File is not deleted");
			}
		}else {
			System.out.println("File does not exist");
		}
		
	}

}
