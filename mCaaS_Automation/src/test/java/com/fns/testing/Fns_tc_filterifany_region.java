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

public class Fns_tc_filterifany_region {

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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")));
		Thread.sleep(10000);
		String Research_count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		System.out.println("Research count for any"+"---"+Research_count);
		System.out.println(driver.getTitle());
		//Filter---Industry
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[4]/div[2]/div")).click();
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[6]/div[2]/div")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[7]/div[2]/span")));
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[7]/div[2]/span")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("allRegionCheckbox")));
		WebElement allregions = driver.findElement(By.id("allRegionCheckbox"));
		allregions.click();
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")));
		String allindustries_research_count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		System.out.println("Research count for all Regions"+"---"+allindustries_research_count);
		allregions.click();
		Thread.sleep(20000);
		String Region_list=" , ,Africa,Asia Pacific,Europe,Latin America,North America,South Asia & Middle East & North Africa,World,";
		ArrayList aList= new ArrayList(Arrays.asList(Region_list.split(",")));
		for(int i=2;i<=8||i<aList.size();i++){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[7]/ul["+i+"]/li/input")));
		WebElement Region = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[7]/ul["+i+"]/li/input"));
		if(i>=4){
		jse.executeScript("scroll(0, 250)");
		}
		Thread.sleep(5000);
		Region.click();
		Thread.sleep(15000);
		String Region_research_count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		System.out.println(aList.get(i)+"----"+Region_research_count);
		if(i>=4){
			jse.executeScript("scroll(0, 250)");
		}
		Region.click();
		Thread.sleep(10000);
		
		
		}		

	}

}
