package com.fns.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Aug_search_wrt_owned_content {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//login
		driver.get("http://mcaas-prod-icm-fns-portal-ui.mybluemix.net/#/login");
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("bhavana.gavade@happiestminds.com");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		//login successful and Owned any
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")));
		Thread.sleep(10000);
		System.out.println(driver.getTitle());
		WebElement radioBtn1 = driver.findElement(By.id("radio2"));
		((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtn1);
		radioBtn1.click();
	    Thread.sleep(10000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/select")));
	    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/select")).click();
	    //driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[2]/div[2]/div")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")));
		String Owned_Research_count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		System.out.println(Owned_Research_count);   
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/input")).sendKeys("IP Trends");
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/span/button")).click();
		
	}

}
