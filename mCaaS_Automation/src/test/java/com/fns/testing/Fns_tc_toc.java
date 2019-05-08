package com.fns.testing;

import java.util.List;
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
import org.openqa.selenium.support.ui.WebDriverWait;



public class Fns_tc_toc {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Table of contents
		driver.get("https://mcaas-icm-prod-fns-report-ui.mybluemix.net/#/assets/1/413/1713/D79F-01-00-00-00/research?eui=12");
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='report-title']/div/div/div/h2")));
		WebElement values = driver.findElement(By.cssSelector("div[class='panel-body']"));
		int y=values.findElements(By.xpath("//div[contains(@class,'table-content-inner ng-scope')]")).size()/2;
		List<WebElement> findElements2 = values.findElements(By.tagName("li"));
		System.out.println(values.findElements(By.xpath("//div[contains(@class,'table-content-inner ng-scope')]")).size()/2);
		WebElement values3 = driver.findElement(By.cssSelector("div[class='col-md-12 section-height']"));
		List<WebElement> findElements3 = values3.findElements(By.tagName("h3"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for(WebElement z:findElements3){
			String expected = z.getText();
		for(WebElement x:findElements2){
       	//System.out.println(x.getText());
         }
		for(int k=1;k<=y;k++){
		   driver.findElement(By.xpath(".//*[@id='collapseOne']/div/div/div["+k+"]/span")).click();
		   Thread.sleep(5000);
		   driver.findElement(By.xpath(".//*[@id='collapseOne']/div/div/div["+k+"]/ul/li/a")).click();
		   Thread.sleep(5000);
		   
		   System.out.println(driver.findElement(By.xpath(".//*[@id='collapseOne']/div/div/div["+k+"]/ul/li/a")).getText());
		   WebElement element = driver.findElement(By.xpath(".//*[@id='collapseOne']/div/div/div["+k+"]/ul/li/a"));
		   try{
			   if(driver.findElement(By.tagName("h3")).isDisplayed()){
				Thread.sleep(10000);
			   driver.findElement(By.xpath("h3[text()='Executive Summary']")).click();
			   Thread.sleep(5000);
			   System.out.println("-----------"+driver.findElement(By.tagName("h3")).getText());
			   }
			   else{
				   System.out.println("element is not displayed");
			   }
			   }
			   catch(WebDriverException e){
				  
				   
			   }
		     for(int p=1;p<=8;p++){
	    	try{
		   driver.findElement(By.xpath(".//*[@id='collapseOne']/div/div/div["+k+"]/ul/li/div["+p+"]/ul/li/a")).click();
		   Thread.sleep(5000);
		   
		   
		   //Thread.sleep(3000);
	       System.out.println(driver.findElement(By.xpath(".//*[@id='collapseOne']/div/div/div["+k+"]/ul/li/div["+p+"]/ul/li/a")).getText());
	       try{
	    	   if(driver.findElement(By.tagName("h3")).isDisplayed()){
					Thread.sleep(10000);
				   driver.findElement(By.xpath("h3[text()='Research Scope']")).click();
				   Thread.sleep(5000);
				   System.out.println("-----------"+driver.findElement(By.tagName("h3")).getText());
				   }
				   else{
					   System.out.println("element is not displayed");
				   }
				   }
				   catch(WebDriverException e){
					  
					   
				   }
	       WebElement element1 = driver.findElement(By.xpath(".//*[@id='collapseOne']/div/div/div["+k+"]/ul/li/div["+p+"]/ul/li/a"));
	       Thread.sleep(3000);
	       String descriptionTextXPath = "//div[class='col-md-12 section-height']/h3";
	       WebElement h3Element = driver.findElement(By.xpath(descriptionTextXPath));
	       String descriptionText = h3Element.getText();
	       System.out.println(descriptionText);
	       //String result_01 = driver.findElement(By.xpath(".//*[@id='collapseOne']/div/div/div["+k+"]/ul/li/div["+p+"]/ul/li/a")).getText();
	       
	       }
	       
	       catch(ElementNotVisibleException e){
	   			
	   		}
	   		catch(NoSuchElementException e){
	   			
	   		}
	    			}
	       continue;
		}
		}

driver.close();
  
				  
	}
	
}
