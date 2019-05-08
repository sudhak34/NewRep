package com.net.test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login_details{
	public WebDriver driver;
 public login_details(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void txt_UserName(String username){
	driver.findElement(By.id("emailid")).sendKeys(username);
	}
	public void txt_Password(String password){
		driver.findElement(By.id("password")).sendKeys(password);
		}
	public void btn_Login(){
		driver.findElement(By.id("login")).click();
		}
	
	public WebDriver getdriver(){
		return driver;
	}	
	
}
