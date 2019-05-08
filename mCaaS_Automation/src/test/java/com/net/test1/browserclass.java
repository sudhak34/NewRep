package com.net.test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserclass {
	 public WebDriver driver;
	
	public browserclass(){
		
		driver=new ChromeDriver();
		driver.get("https://memberuat.frost.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public WebDriver getdriver(){
		return driver;
	}
	
}
