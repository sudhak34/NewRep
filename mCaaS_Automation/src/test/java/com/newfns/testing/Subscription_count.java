package com.newfns.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.mcaas.genericlibraries.Xls_Reader;

public class Subscription_count {

	public static void main(String[] args) throws InterruptedException {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Quantum_count.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		System.out.println(rowCount);
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("https://quantumportal.frost.com/#/login");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("namrata.desai@happiestminds.com");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("password");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		Thread.sleep(40000);
        driver.findElement(By.xpath("html/body/div[2]/div[1]/nav/div/div[1]/div/ul/li/a/div")).click();
        Thread.sleep(20000);
        driver.findElement(By.xpath(" html/body/div[2]/div[1]/nav/div/div[1]/div/ul/li/ul/li[4]/span[2]/a")).click();
        Thread.sleep(20000);
        /*jse.executeScript("scroll(0, 2000)");
		WebElement Items_per_page = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[26]/div/div/select"));
		Select slc=new Select(Items_per_page);
		slc.selectByVisibleText("100");
		Thread.sleep(5000);
		jse.executeScript("scroll(2000, 0)");*/
		int j=1;
		for(int i=369;i<=572;i++){
			System.out.println(i);
		
		//Thread.sleep(7000);
			if(j==26){
				j=j-25;
				//driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[4]/a")).click();
		Thread.sleep(10000);
			}
			
			try{
				if(i>=27 && i<=51){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[4]/a")).click();
				Thread.sleep(5000);
				}
				if(i>=52 && i<=176){
					driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
					Thread.sleep(5000);
					}
				if(i>=77 && i<=101){
					driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
					Thread.sleep(5000);
					}
				if(i>=102 && i<=126){
					driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
					Thread.sleep(5000);
					}
				if(i>=127 && i<=151){
					driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
					Thread.sleep(5000);
					}
			
			if(i>=152 && i<=176){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			if(i>=177 && i<=201){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			if(i>=202 && i<=226){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			if(i>=227 && i<=251){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			if(i>=252 && i<=276){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			if(i>=277 && i<=301){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			if(i>=302 && i<=326){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			if(i>=327 && i<=351){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			if(i>=352 && i<=376){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			if(i>=377 && i<=401){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			if(i>=402 && i<=426){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			if(i>=452 && i<=476){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			if(i>=427 && i<=451){
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/dir-pagination-controls/ul/li[8]/a")).click();
				Thread.sleep(5000);
			}
			}
			
			catch(ElementNotVisibleException e){
				
			}
			catch(NoSuchElementException e){
				
			}
			catch(WebDriverException e){
				
			}
			catch(NullPointerException e){
				
			}
			
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div["+j+"]/div/div/div[1]/div/button")));
		String Sub_id = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div["+j+"]/div/div/div[1]/div/button")).getText();
		System.out.println(Sub_id);
		xl.setCellData("Sheet1","Prod_sub_id", i,Sub_id);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div["+j+"]/div/div/div[3]/div/div/a")));
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div["+j+"]/div/div/div[3]/div/div/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='demo7']/ul[2]/li/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='demo7']/ul[3]/li/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='demo7']/ul[4]/li/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='demo7']/ul[5]/li/input")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")));
		String count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		xl.setCellData("Sheet1","Quant_count", i,count);
		System.out.println(count);
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(5000);
		j+=1;
		}
        
		catch(ElementNotVisibleException e){
			
		}
		catch(NoSuchElementException e){
			
		}
		catch(WebDriverException e){
			
		}
		catch(NullPointerException e){
			
		}
		continue;
			
			}
		}
		
	}


