package com.fns.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fns_tc_published_year {

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
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[4]/div[2]/div")));
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[4]/div[2]/div")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[8]/div[2]/div")));
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[8]/div[2]/div")).click();
		jse.executeScript("scroll(0, 250)");
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[9]/div[2]/span")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("allPublishYearCheckbox")));
		WebElement allpublishedyears_types = driver.findElement(By.id("allPublishYearCheckbox"));
		allpublishedyears_types.click();
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")));
		String allindustries_research_count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		System.out.println("Research count for all published years"+"---"+allindustries_research_count);
		allpublishedyears_types.click();
		Thread.sleep(20000);
		String Published_year_list=" , ,2017,2016,2015,2014,2013,2012,2011,2010,2009,2008,2007,2006,2005,2004,2003,2002,2001,2000,1999,1998,1997,1996,1995,1975,";
		ArrayList aList= new ArrayList(Arrays.asList(Published_year_list.split(",")));
		for(int i=1;i<=24||i<aList.size();i++){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[9]/ul["+i+"]/li/input")));
			WebElement published_year = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[9]/ul["+i+"]/li/input"));
			if(i>=4 && i<=15){
			jse.executeScript("scroll(0, 250)");
			}
			else{
				jse.executeScript("scroll(0, 450)");	
			}
			Thread.sleep(5000);
			published_year.click();
			Thread.sleep(15000);
			String published_year_research_count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
			System.out.println(aList.get(i)+"----"+published_year_research_count);
			if(i>=4 && i<=15){
				jse.executeScript("scroll(0, 250)");
			}
			else{
				jse.executeScript("scroll(0, 450)");	
			}
			published_year.click();
			Thread.sleep(10000);
			
		}
		
	}

}
