package com.stta.Inheritance;

import static org.junit.Assert.*;

import org.junit.Test;

public class Bike extends Vehicles {

	String typeBike;
	
	@Test
	public void test() {
		typeBike = "2wheels";
		getNumberOfWheel();
	}
	
	public void getNumberOfWheel(String type)
	{
		if (type=="2wheels")
			System.out.println("The bike has two wheels");
		else if (type=="3wheels")
			System.out.println("The bike has three wheels");
	}
	

}
