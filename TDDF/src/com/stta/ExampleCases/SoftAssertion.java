package com.stta.ExampleCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert; 

public class SoftAssertion {
	
	public static WebDriver driver=null;
	SoftAssert s_assert = new SoftAssert();
	
	@BeforeTest
	public void loadWebPage()
	{
		//System.setProperty("webdriver.ie.driver","D:\\Git\\TDDF\\BrowserDrivers\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver","\\Git\\TDDF\\BrowserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void HardAssert_Method()
	{
		String actualVal = driver.findElement(By.xpath("//h2/span")).getText();
			
		Assert.assertNotEquals(actualVal, "Tuesday, 28 January 2014", "Expected and Actual are match");
		System.out.println("3. ASSERT.AssertNotEQUALs - CHECK FAILED: Expected and Actual are match");
	}
	
	@Test
	public void SoftAssert_Method()
	{
		
		String actualText = driver.findElement(By.xpath("//h2/span")).getText();
		
		s_assert.assertEquals(actualText,"Tuesday, 1 January 2014","1st test failed: Actual and Expected Strings are not match");
		System.out.println("1. FAILED: The 1st test is executed");
		
		s_assert.assertEquals(actualText,"Tuesday, 28 January 2014","2nd test failed: Actual and Expected Strings are not match");
		System.out.println("2. PASSED: The 2nd test is executed");
		
		driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
		String alertText= driver.switchTo().alert().getText();
		s_assert.assertEquals(alertText, "Alert Failed Message", "The content on alert does not match");
		System.out.println("3. FAILED: The 3rd test is executed");
		
		s_assert.assertEquals(alertText, "Hi.. This is alert message", "The content on alert matched");
		System.out.println("4. PASSED: The 4th test is executed");
		
		driver.switchTo().alert().accept();
		
		s_assert.assertAll();
	}
	
	@Test
	public void ClickAndWait()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='submitButton']")));
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
	}
	
	@AfterTest
	public void exitBrowser()
	{
		driver.quit();
	}

}
