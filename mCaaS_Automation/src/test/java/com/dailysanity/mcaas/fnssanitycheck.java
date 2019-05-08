package com.dailysanity.mcaas;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class fnssanitycheck {
	 /*@Test
	public static void task() {
		Timer timer = new Timer(); 
	    TimerTask task = new TimerTask(){*/
	    //@SuppressWarnings("static-access")
	  @Test
	    public void run() throws Exception{
	    	System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Latest_2000_KE\\chromedriver.exe");
			WebDriver driver  = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://memberuat.frost.com");
			WebDriverWait wait=new WebDriverWait(driver,60);
			WebDriverWait wait1=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='emailid']")));
			driver.findElement(By.xpath(".//*[@id='emailid']")).sendKeys("namrata.desai@happiestminds.com");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			driver.findElement(By.id("password")).sendKeys("Password@123");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
			Thread.sleep(4000);
			driver.findElement(By.id("login")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
			String result="<span style=color:green>Portal launched successfully<span>";
			String testdata_aug="<span style=color:green>market<span>";
			String resp_time="<span style=color:green>13sec<span>";
			driver.close();
			mailfns.sendemail(result,testdata_aug, resp_time);
			
			System.out.println("completed");
	    }
	       
			
	   /* };*/
    
    //timer.schedule(task,0,10800000);
	    /* timer.schedule(task,0,5400000);*/
	
}

