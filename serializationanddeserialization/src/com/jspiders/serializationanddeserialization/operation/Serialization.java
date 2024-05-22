package com.jspiders.serializationanddeserialization.operation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.jspiders.serializationanddeserialization.object.User;

public class Serialization {

	public static void main(String[] args) {

		File file = new File("demo.txt");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
   ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			User user = new User();
			user.setUserName("Ram");
			user.setEmail("ram@gmail.com");
			user.setMobileNumber(9876543210l);
			user.setPassword("Ram@1234");
			objectOutputStream.writeObject(user);
			System.out.println("Object is serialized");
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
