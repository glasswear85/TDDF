package com.stta.SuiteOne;

import java.io.IOException;

import org.junit.Test;

public class Mytest{
 
String testString = "ABCD ABEF GHAB";
 String targetString = "";
 
 @Test
 public void test() throws IOException {	
		System.out.println("String removed duplicate: " + removeDuplicate(testString));
 }
 
 public String removeDuplicate(String inputStr)
 {
	 for(int i = 0;i<inputStr.length();i++)
	 {
		 if (!targetString.contains(String.valueOf(inputStr.charAt(i))))
		{
			 targetString += String.valueOf(inputStr.charAt(i));
		}
	 }	 
	 return targetString;
 }
}
