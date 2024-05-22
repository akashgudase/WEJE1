package com.jspiders.designpatterns.main;

import com.jspiders.designpatterns.creational.User;

public class UserMain {
	
	public static void main(String[] args) {
		
		User user1 = User.getObject();
		System.out.println(user1);
		User user2 = User.getObject();
		System.out.println(user2);
		User user3 = User.getObject();
		System.out.println(user3);
		User user4 = User.getObject();
		System.out.println(user4);
		
	}

}
