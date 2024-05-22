package com.jspiders.serializationanddeserialization.operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.jspiders.serializationanddeserialization.object.User;

public class Deserialzation {

	public static void main(String[] args) {

		File file = new File("demo.txt");
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
	 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			User user = (User) objectInputStream.readObject();
			System.out.println(user);
			System.out.println("Object is deserialized");
			objectInputStream.close();
			fileInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
