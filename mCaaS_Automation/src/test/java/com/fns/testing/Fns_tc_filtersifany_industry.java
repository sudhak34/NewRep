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

public class Fns_tc_filtersifany_industry {

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
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[5]/div[2]/span")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("allIndustryCheckbox")));
		WebElement allindustries = driver.findElement(By.id("allIndustryCheckbox"));
		allindustries.click();
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")));
		String allindustries_research_count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		System.out.println("Research count for all industries"+"---"+allindustries_research_count);
		allindustries.click();
		Thread.sleep(20000);
		String industry_list=" , ,Aerospace & Defense,Automotive & Transportation,Business & Financial Services,Career Research,Chemicals Materials & Foods,Consumer Products,Education,Electronics and Security,Energy & Power Systems,Environment & Building Technologies,Healthcare,Industrial Automation,Information & Communication Tech,Measurement & Instrumentation,Metals & Minerals,";
		ArrayList aList= new ArrayList(Arrays.asList(industry_list.split(",")));
		for(int i=11;i<=16||i<aList.size();i++){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[5]/ul["+i+"]/li/input")));
		WebElement Industry = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[5]/ul["+i+"]/li/input"));
		if(i>=11){
		jse.executeScript("scroll(0, 250)");
		}
		Thread.sleep(5000);
		Industry.click();
		Thread.sleep(20000);
		String industry_research_count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		System.out.println(aList.get(i)+"----"+industry_research_count);
		if(i>=11){
			jse.executeScript("scroll(0, 250)");
		}
		Industry.click();
		Thread.sleep(20000);
		
		
		}		
				
	}
}
