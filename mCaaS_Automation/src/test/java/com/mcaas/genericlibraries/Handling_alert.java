package com.mcaas.genericlibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_alert {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.99acres.com/");
		driver.findElement(By.linkText("CUSTOMER SERVICE")).click();
		driver.findElement(By.xpath("html/body/div[2]/section/form/div/section/div[1]/div[3]/div/div/div[2]/div[1]/div[1]/div/input")).sendKeys("Hi");
	}

}
