package com.stta.ExampleCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Assertion {
	
	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void loadWebPage()
	{
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	}

	// 1. ASSERT.AssertEQUALs: Check Pass
	@Test
	public void Assert_Method_1()
	{
		String expectedVal = "Test";
		Assert.assertEquals(expectedVal, "Test");
		System.out.println("1. CHECK PASSED: Two values are the same");
	}
	
	// 2. ASSERT.AssertEQUALs: Check Fail
	@Test
	public void Assert_Method_2()
	{
		String expectedVal = "Test";
		Assert.assertEquals(expectedVal, "Test1");
		System.out.println("2. CHECK FAILED: Two values are not the same");
	}
	
	// 3. ASSERT.AssertNotEQUALs: Check Fail
	@Test
	public void Assert_Method_3()
	{
		String actualVal = driver.findElement(By.xpath("//h2/span")).getText();
		
		Assert.assertNotEquals(actualVal, "Tuesday, 28 January 2014", "Expected and Actual are match");
		System.out.println("3. CHECK FAILED: Expected and Actual are match");
	}
	
	// 4. ASSERT.AssertNotEQUALs: Check Pass
	@Test
	public void Assert_Method_4()
	{
		String actualVal = driver.findElement(By.xpath("//h2/span")).getText();
		
		Assert.assertNotEquals(actualVal, "Tuesday, 29 January 2014", "Expected and Actual are not match");
		System.out.println("4. CHECK PASSED: Expected and Actual are not match");
	}
	
	// 5. ASSERT.AssertTrue: Check Pass
		@Test
		public void Assert_Method_5()
		{
			WebElement firstChk = driver.findElement(By.xpath(".//*[@value='Bike']"));
			
			Assert.assertTrue(firstChk.isSelected(), "Bike checkbox is selected");
			System.out.println("5. CHECK PASSED: Bike checkbox is currently selected");
		}
		
		
	// 6. ASSERT.AssertTrue: Check Fail
		@Test
		public void Assert_Method_6()
		{
			WebElement firstChk = driver.findElement(By.xpath(".//*[@value='Car']"));
				
			Assert.assertTrue(firstChk.isSelected(), "Car checkbox is not selected");
			System.out.println("6. CHECK FAILED: Car checkbox is not currently selected");
		}
	
	@AfterTest
	public void exitBrowser()
	{
		driver.close();
	}
	
	
}
