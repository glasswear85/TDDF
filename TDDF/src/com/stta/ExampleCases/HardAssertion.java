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


public class HardAssertion {
	
	public static WebDriver driver=null;
	
	@BeforeTest
	public void loadWebPage()
	{
		System.setProperty("webdriver.ie.driver","\\Git\\TDDF\\BrowserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	}

	// 1. ASSERT.AssertEQUALs: Check Pass
	@Test
	public void Assert_Method_1()
	{
		String expectedVal = "Test";
		Assert.assertEquals(expectedVal, "Test");
		System.out.println("1. ASSERT.AssertEQUAL - CHECK PASSED: Two values are the same");
	}
	
	// 2. ASSERT.AssertEQUALs: Check Fail
	@Test
	public void Assert_Method_2()
	{
		String expectedVal = "Test";
		Assert.assertEquals(expectedVal, "Test1");
		System.out.println("2. ASSERT.AssertEQUAL - CHECK FAILED: Two values are not the same");
	}
	
	// 3. ASSERT.AssertNotEQUALs: Check Fail
	@Test
	public void Assert_Method_3()
	{
		String actualVal = driver.findElement(By.xpath("//h2/span")).getText();
		
		Assert.assertNotEquals(actualVal, "Tuesday, 28 January 2014", "Expected and Actual are match");
		System.out.println("3. ASSERT.AssertNotEQUALs - CHECK FAILED: Expected and Actual are match");
	}
	
	// 4. ASSERT.AssertNotEQUALs: Check Pass
	@Test
	public void Assert_Method_4()
	{
		String actualVal = driver.findElement(By.xpath("//h2/span")).getText();
		
		Assert.assertNotEquals(actualVal, "Tuesday, 29 January 2014", "Expected and Actual are not match");
		System.out.println("4. ASSERT.AssertNotEQUALs - CHECK PASSED: Expected and Actual are not match");
	}
	
	// 5. ASSERT.AssertTrue: Check Pass
		@Test
		public void Assert_Method_5()
		{
			WebElement firstChk = driver.findElement(By.xpath(".//*[@value='Bike']"));
			
			Assert.assertTrue(firstChk.isSelected(), "Bike checkbox is selected");
			System.out.println("5. ASSERT.AssertTrue - CHECK PASSED: Bike checkbox is currently selected");
		}
		
		
	// 6. ASSERT.AssertTrue: Check Fail
		@Test
		public void Assert_Method_6()
		{
			WebElement firstChk = driver.findElement(By.xpath(".//*[@value='Car']"));
				
			Assert.assertTrue(firstChk.isSelected(), "Car checkbox is not selected");
			System.out.println("6. ASSERT.AssertTrue - CHECK FAILED: Car checkbox is not currently selected");
		}
	
	// 7. ASSERT.AsserFalse: Check Fail
		@Test
		public void Assert_Method_7()
		{
			WebElement firstChk = driver.findElement(By.xpath(".//*[@value='Bike']"));
				
			Assert.assertFalse(firstChk.isSelected(), "Bike checkbox is selected");
			System.out.println("7. ASSERT.AsserFalse - CHECK FAILED: Bike checkbox is currently selected");
		}
		
	// 8. ASSERT.AsserFalse: Check Pass
		@Test
		public void Assert_Method_8()
		{
			WebElement firstChk = driver.findElement(By.xpath(".//*[@value='Car']"));
				
			Assert.assertFalse(firstChk.isSelected(), "Car checkbox is not selected");
			System.out.println("8. ASSERT.AsserFalse - CHECK PASSED: Car checkbox is not currently selected");
		}
		
	// 9. ASSERT.AsserNull: Check Pass
		@Test
		public void Assert_Method_9()
		{
			WebElement textbox = driver.findElement(By.xpath(".//*[@name='fname']"));
			
			Assert.assertNull(textbox.getAttribute("disabled"));
			System.out.println("9. ASSERT.AsserNull - CHECK PASSED: First Name textbox is enabled within the first 10s");
		}
		
	// 10. ASSERT.AsserNull: Check Fail
		@Test
		public void Assert_Method_10()
		{
			WebElement textbox = driver.findElement(By.xpath(".//*[@name='lname']"));
			
			Assert.assertNull(textbox.getAttribute("disabled"));
			System.out.println("10. ASSERT.AsserNull - CHECK FAILED: Last Name textbox is disbaled within the first 10s");
		}
		
	// 11. ASSERT.AssertNotNull: Check Fail
		@Test
			public void Assert_Method_11()
			{
				WebElement textbox = driver.findElement(By.xpath(".//*[@name='fname']"));
					
				Assert.assertNotNull(textbox.getAttribute("disabled"));
				System.out.println("11. ASSERT.AsserNotNull - CHECK FAILED: First Name textbox is enabled within the first 10s");
			}
				
	// 12. ASSERT.AssertNotNull: Check Pass
		@Test
			public void Assert_Method_12()
			{
				WebElement textbox = driver.findElement(By.xpath(".//*[@name='lname']"));
					
				Assert.assertNotNull(textbox.getAttribute("disabled"));
				System.out.println("12. ASSERT.AsserNotNull - CHECK PASSED: Last Name textbox is disabled within the first 10s");
			}	
		
		
	@AfterTest
	public void exitBrowser()
	{
		driver.close();
	}
	
	
}
