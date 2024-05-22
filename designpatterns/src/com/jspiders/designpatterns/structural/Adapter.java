package com.jspiders.designpatterns.structural;

public class Adapter extends Player implements Team {

	@Override
	public void event() {
		
		System.out.println(getName() + " is a manager for the event");

	}

}
