package com.stta.ExampleCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CaptureScreenshot {
	
	@Test
	public static void main() throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("D:\\TestCaptureScreenShot.jpg"));
		System.out.println("Capture entire page screenshot and then store it to destination drive");
	}

}
