package com.stta.Inheritance;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVehicles {

	String[] publicHoliday = {"30-04-2016","01-05-2016","02-09-2016","01-01-2017"};
	
	@Test
	public void test() {
		//Test Inheritance via Vehicle
		Vehicles veh = new Vehicles(4, "Black", (float)100.0);
		assertTrue(veh.numOfWheel==4);
		System.out.println(veh.vehColor);
		
		//AS exercise
		System.out.println(getworkingday("10-04-2016"));
	}

	public boolean getworkingday(String inputDate)
	{
		for (int index=0;index<publicHoliday.length;index++)
		{
			if (inputDate == publicHoliday[index])
			{
				System.out.println(inputDate + " is a holiday date");
				return false;
			}
		}
		System.out.println(inputDate + " is a working date");
		return true;
	}
}
