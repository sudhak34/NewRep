package com.newfns.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cob {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("https://memberuat.frost.com/#/login");
		driver.get("https://mcaas-uat-icm-fns-customeronboarding-ui.mybluemix.net/#/login");
		driver.findElement(By.id("username")).sendKeys("HMAdmin");
		driver.findElement(By.id("password")).sendKeys("password");
		Thread.sleep(2000);
		driver.findElement(By.id("login")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div/div[2]/ul/li[3]/a/span[2]")).click();
		Thread.sleep(5000);
		WebElement edit = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/show-table-pagination/div[1]/div[2]/div/table/tbody/tr[1]/td[5]/span[2]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", edit);
	}

}
