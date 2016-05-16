package com.stta.Inheritance;

import static org.junit.Assert.*;

import org.junit.Test;




public class Vehicles{
	
	int numOfWheel;
	String vehColor;
	float vehPrice;
	
	public Vehicles ()
	{}
	
	public Vehicles (int wheel, String color, float price)
	{
		numOfWheel = wheel;
		vehColor = color;
		vehPrice = price;
	
		System.out.println("Number of wheel is: " + numOfWheel);
		System.out.println("Its color is: " + vehColor);
		System.out.println("Its price is: " + vehPrice);
	}
	
	protected int getNumberOfWheel()
	{
		System.out.println("Number of wheels is: " + numOfWheel);
		return numOfWheel;

	}
	
}
