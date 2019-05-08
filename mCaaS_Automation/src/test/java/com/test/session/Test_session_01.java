package com.test.session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_session_01 {
public static void main(String[] args) {
	String expected_result="2,27,00,000";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.bing.com/");
	driver.findElement(By.id("sb_form_q")).sendKeys("Selenium");
	driver.findElement(By.id("sb_form_go")).click();
	String Actual_result = driver.findElement(By.className("sb_count")).getText();
	String[] Actual_result_01 = Actual_result.split(" ");
	String Final_actual_result=Actual_result_01[0];
	System.out.println(Final_actual_result);
	if(Final_actual_result.equals(expected_result)){
		System.out.println("Test case is pass");
	}
	else{
		System.out.println("Test case is fail");
	}
	driver.close();
}
}
