package com.mcaas.icmtestcases;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import com.mcaas.genericlibraries.Xls_Reader;
import com.sun.jna.Function;

public class Sanity_Prod_icm_Chrome {
	@Test
	@SuppressWarnings("finally")
	public static void main(){
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\Sudhakar_mCaaS\\DQA\\Latest\\chrome_Forrester_Prod_Urls_Automation_Test results.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		System.out.println(rowCount);
		/*Browser_Handler g=new Browser_Handler("Firefox");
		WebDriver driver = g.getdriver();*/
		System.setProperty("webdriver.chrome.driver", "D:\\driver_new\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
			for(int i=680;i<=rowCount;i++){
				//System.out.println(i);
			String url = xl.getCellData("Sheet1","prodURL", i);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  	driver.get(url);
			    	
		     	  WebDriverWait wait = new WebDriverWait(driver,10);
				  
				  try {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='report-desc-head-header'][@class='header-heading ng-binding']")));
		  		  if(driver.findElement(By.xpath(".//*[@id='report-desc-head-header'][@class='header-heading ng-binding']")).isDisplayed()){
		  		  driver.findElement(By.xpath(".//*[@id='report-desc-head-header'][@class='header-heading ng-binding']")).click();
				  System.out.println(+ i + "Report Heading:"+driver.findElement(By.xpath(".//*[@id='report-desc-head-header'][@class='header-heading ng-binding']")).getText());
				  String Report_Heading = driver.findElement(By.xpath(".//*[@id='report-desc-head-header'][@class='header-heading ng-binding']")).getText();
				  xl.setCellData("Sheet1", "Heading",i,Report_Heading);
				  xl.setCellData("Sheet1", "Comments",i,"Pass");
				  if( i%10 == 0){
				       driver.navigate().refresh();
				       System.out.println("Page has been refreshed");
				       Thread.sleep(30000);
				      }
				  
				  
		  		  }  
		           }
			
		     	catch(NoSuchElementException e){
		     		  if(driver.findElement(By.xpath("//img[@src='templates/images/404_error.png']")).isDisplayed()){
		     			   xl.setCellData("Sheet1", "Comments",i, "Report expired,404 Error");
						   System.out.println(i + "Report expired,404 Error");
			           }
			     }
				  catch(ElementNotVisibleException e){
					  if(driver.findElement(By.xpath("//img[@src='templates/images/404_error.png']")).isDisplayed()){
		     			   xl.setCellData("Sheet1", "Comments",i, "Report expired,404 Error");
						   System.out.println(i + "Report expired,404 Error");
			           }
						        
					  
				  }
				  
	              catch(WebDriverException e){
	            	  if(driver.findElement(By.xpath("//img[@src='templates/images/404_error.png']")).isDisplayed()){
		     			   xl.setCellData("Sheet1", "Comments",i, "Report expired,404 Error");
						   System.out.println(i + "Report expired,404 Error");
			           }
				  }
				  catch(NullPointerException e){
					  if(driver.findElement(By.xpath("//img[@src='templates/images/404_error.png']")).isDisplayed()){
		     			   xl.setCellData("Sheet1", "Comments",i, "Report expired,404 Error");
						   System.out.println(i + "Report expired,404 Error");
			           }
					  	  }
				  catch(Exception e){
					  if(driver.findElement(By.xpath("//img[@src='templates/images/404_error.png']")).isDisplayed()){
		     			   xl.setCellData("Sheet1", "Comments",i, "Report expired,404 Error");
						   System.out.println(i + "Report expired,404 Error");
			           }
				  }
				  
		            // continue;
		    
		  	finally {
		   		 	continue;
	 	          } 
		  	   }
	         }
}
