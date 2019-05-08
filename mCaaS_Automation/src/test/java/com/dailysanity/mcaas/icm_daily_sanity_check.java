package com.dailysanity.mcaas;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.mail.SendFailedException;


import org.fusesource.jansi.AnsiConsole;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;




public class icm_daily_sanity_check {
	public static void main(String[] args) {
		Timer timer = new Timer(); 
	    TimerTask task = new TimerTask(){
	    @SuppressWarnings("static-access")
		
	    @Test
	    public void run(){
	    	
	    //Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\Sudhakar_mCaaS\\DQA\\Autoamtion_Testdata\\sanity test\\Sanity_testing_results.xlsx");
	    //int rowCount = xl.getRowCount("Sheet1");
	    String Report_Heading=null;
	    String Report_Heading1=null;
	    String Basic_Report_url_rendered=null;
	    String Premium_Report_url_rendered=null;
	    String parentwindow1=null;
	    String Result_01=null;
	    String Result_02=null;
	    String Result_03=null;
	    String Result_04=null;
	    String Result_05=null;
		mail02 test=new mail02();
		
		//WebDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\Sudhakar_mCaaS\\DQA\\Latest\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		//System.setProperty("webdriver.ie.driver", "D:\\Sudhakar_Data\\Backup\\E\\Sudhakar_mCaaS\\DQA\\Drivers\\IEDriverServer.exe");
		//WebDriver driver  = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//Digital Reprints//
		try {
			driver.get("https://reprints.forrester.com/#/assets/2/184/'RES118088'/reports?DummyParameter=TEST");
	        //Thread.sleep(50000);
	        WebDriverWait wait2 = new WebDriverWait(driver,240);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("header-wrapper")));
	        if(driver.findElement(By.className("header-wrapper")).isDisplayed()){
	   	    driver.findElement(By.className("header-wrapper")).click();
			System.out.println("Report Heading:"+driver.findElement(By.xpath("//div[@class='header-heading ng-binding']")).getText());
			Report_Heading = driver.findElement(By.xpath("//div[@class='header-heading ng-binding']")).getText()+" - <span style=color:green> Reprint has rendered successfully - PASS </span>";
			//xl.setCellData("Sheet1", "Result_Pass", 2, Report_Heading01);
			//Report_Heading = xl.getCellData("Sheet1", "Result_Pass", 2);
			//test.sendemail(Report_Heading);
			Result_01="Pass";
			}
	        else{
	        	   Report_Heading="<span style=color:red> Reprints are not rendering,Please look into this issue on priority  - FAIL </span> ";
				   System.out.println(Report_Heading);
				   Result_01="Fail";
	        }
		  }
	        catch(RuntimeException e){
				   Report_Heading="<span style=color:red> Reprints are not rendering,Please look into this issue on priority  - FAIL </span> ";
				   Result_01="Fail";
			  }
		
		
		
				   //test.sendemail(Report_Heading1);
		
		//TEI Report//
		try{
			driver.get("https://studies.totaleconomicimpact.com/#/assets/5/servicenow/costsavings/tei?DummyParameter=TEST");	
			/*WebDriverWait wait3 = new WebDriverWait(driver,240);
			wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div/div[2]/div[1]/div/div/div[3]/button")));
			driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[2]/div[1]/div/div/div[3]/button")).click();*/
			WebDriverWait wait1 = new WebDriverWait(driver,240);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div/div[2]/div/div[1]/div/div[3]")));
			if(driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[2]/div/div[1]/div/div[3]")).isDisplayed()){
			driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[2]/div/div[1]/div/div[3]")).click();
			System.out.println("Report Heading:"+driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[2]/div/div[1]/div/div[3]")).getText());
			Report_Heading1 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[2]/div/div[1]/div/div[3]")).getText()+" - <span style=color:green> TEI report has rendered successfully - PASS </span> ";
			Result_02="Pass";
			}
			 else{
				   Report_Heading1="<span style=color:red> TEI report is not rendering,Please look into this issue on priority - FAIL </span>";
				   System.out.println(Report_Heading1);
				   //test.sendemail(Report_Heading);
				   Result_02="Fail";
					  }
				} catch(NoSuchElementException e){
			 Report_Heading1="<span style=color:red> TEI report is not rendering,Please look into this issue on priority - FAIL </span>";
			 Result_02="Fail";
		  }
		  
		  catch(ElementNotVisibleException e){
			  Report_Heading1="<span style=color:red> TEI report is not rendering,Please look into this issue on priority - FAIL </span>";
			  Result_02="Fail";
		  }
		  
	     catch(WebDriverException e){
	    	 Report_Heading1="<span style=color:red> TEI report is not rendering,Please look into this issue on priority - FAIL </span>";
	    	 Result_02="Fail";
		  } 
		//MindFields Basic Report//
		try{
			//http://www.mindfields.net.au/login
			driver.get("http://www.mindfields.net.au/");
			WebDriverWait wait = new WebDriverWait(driver,240);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='btl-panel-login']")));
			driver.findElement(By.xpath(".//*[@id='btl-panel-login']")).click();
		}
		catch(ElementNotVisibleException e){
		}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebDriverWait wait33 = new WebDriverWait(driver,240);
			wait33.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='btl-input-username']")));
			driver.findElement(By.xpath(".//*[@id='btl-input-username']")).sendKeys("Grant.Crawford@ventia.com.au");
			WebDriverWait wait44 = new WebDriverWait(driver,240);
			wait44.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='btl-input-password']")));
			driver.findElement(By.xpath(".//*[@id='btl-input-password']")).sendKeys("Grant.Crawford@ventia.com.au");
			driver.findElement(By.xpath(".//*[@id='btl-content-login']/div[1]/form/div[6]/input[1]")).click();
			WebDriverWait wait7 = new WebDriverWait(driver,240);
			wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='sp-component']/div/div[2]/ul/li[1]/div/div[3]/a/span")));
			driver.findElement(By.xpath(".//*[@id='sp-component']/div/div[2]/ul/li[1]/div/div[3]/a/span")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
				driver.findElement(By.xpath(".//*[@id='sp-bottom1']/div/div[2]/div/div[1]/div[2]")).click();
				
			}
			catch(NoSuchElementException e){
				
			}
			/*parentwindow1 = driver.getWindowHandle();
			driver.findElement(By.xpath("html/body/div[3]/section/div/div[2]/div[2]/div[2]/p[5]/a")).click();
			String childwindow1 = null;
			Set<String> windows1 = driver.getWindowHandles();
			  for(String x :windows1)
					{
				if(!x.equals(parentwindow1))
							{
								childwindow1 = x;
							}
						}*/
			try{
				driver.findElement(By.xpath(".//*[@id='sp-component']/div/div[2]/ul/li[1]/div/div[3]/a/span")).click();
			}
			catch(NoSuchElementException e){
				
			}
			
			  
			  try{
				   WebDriverWait wait11 = new WebDriverWait(driver,240);
				                                                                         
					wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='sp-component']/div/div[2]/div[5]/div[1]/div/div/form/div[2]/span[1]/a")));
					
					driver.findElement(By.xpath(".//*[@id='sp-component']/div/div[2]/div[5]/div[1]/div/div/form/div[2]/span[1]/a")).click();
					WebDriverWait wait12 = new WebDriverWait(driver,240);
					wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='top-nav']/div/div[2]/ul/li[1]/div/button")));
					String Upgareto_Premium = driver.findElement(By.xpath(".//*[@id='top-nav']/div/div[2]/ul/li[1]/div/button")).getText();
			//driver.switchTo().window(childwindow1);
			//Thread.sleep(50000);
				  
			
			//System.out.println(driver.findElement(By.xpath(".//*[@id='top-nav']/div/div[2]/ul/li[1]/div/button")).getText());
			//System.out.println(driver.getTitle());
			//String Basic_Report_tile = driver.getTitle();
			//System.out.println(driver.getCurrentUrl());
			
			System.out.println(Upgareto_Premium);
			System.out.println(driver.getCurrentUrl());
			Basic_Report_url_rendered = driver.getCurrentUrl()+
					"/n/n" + "  Basic Mindfields Report has rendered successfully - Pass ";
			System.out.println(driver.getTitle());
			Basic_Report_url_rendered = driver.getTitle()+ "<span style=color:green> Basic Mindfields Report has rendered successfully - PASS </span> ";
			Result_03="Pass";
			
			//Thread.sleep(10000);
			//driver.close();
			  }
			  catch(NoSuchElementException e){
				  Basic_Report_url_rendered ="<span style=color:red> Mindfields Basic Report is not rendering,Please look into this issue on priority  - FAIL </span> ";
				  Result_03="Fail";
			  }
			  
			  catch(ElementNotVisibleException e){
				  Basic_Report_url_rendered ="<span style=color:red> Mindfields Basic Report is not rendering,Please look into this issue on priority  - FAIL </span> ";
				  Result_03="Fail";
			  }
			 
	          catch(WebDriverException e){
	        	  Basic_Report_url_rendered ="<span style=color:red> Mindfields Basic Report is not rendering,Please look into this issue on priority  - FAIL </span> ";
	        	  Result_03="Fail";
			  }
			  catch(NullPointerException e){
				  Basic_Report_url_rendered ="<span style=color:red> Mindfields Basic Report is not rendering,Please look into this issue on priority  - FAIL </span> ";
				  Result_03="Fail";
			  }
			  try{
			  driver.navigate().back();
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("history.go(-1);", new Object[0]);
			  }
			  catch(NoSuchElementException e){
				  
			  }
			  try{
			  driver.findElement(By.xpath(".//*[@id='top-nav']")).click();
			  }
	          catch(NoSuchElementException e){
				 		  }
			  
			  try{
					driver.findElement(By.xpath(".//*[@id='sp-component']/div/div[2]/ul/li[1]/div/div[3]/a/span")).click();
				}
				catch(NoSuchElementException e){
					
				}
				
		    try{
			    //driver.switchTo().window(parentwindow1);
		    	
		    	
				WebDriverWait wait = new WebDriverWait(driver,240);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='sp-component']/div/div[2]/div[5]/div[1]/div/div/form/div[2]/span[2]/a")));
				                                                                   //.//*[@id='sp-component']/div/div[2]/div[5]/div[1]/div/div/form/div[2]/span[2]/a
				driver.findElement(By.xpath(".//*[@id='sp-component']/div/div[2]/div[5]/div[1]/div/div/form/div[2]/span[2]/a")).click();
				//String childwindow2 = null;
				//Set<String> windows2 = driver.getWindowHandles();
				 // for(String x :windows2)
						/*{
					if(!x.equals(parentwindow1))
								{
								//	childwindow2 = x;
								}
					
							}*/
		    
				  
				// try {	
				//driver.switchTo().window(childwindow2);
				WebDriverWait wait8 = new WebDriverWait(driver,240);
				wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div[9]/div[1]/div[2]/div/div[3]/div")));
				String Heading_Premium = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[9]/div[1]/div[2]/div/div[3]/div")).getText();
				//System.out.println(Heading_Premium);
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				
				Premium_Report_url_rendered = driver.getCurrentUrl()+
						 "/n/n" + " Premium Mindfields Report has rendered successfully - Pass ";
				Premium_Report_url_rendered = driver.getTitle()+" <span style=color:green> Premium Mindfields Report has rendered successfully  - PASS </span> ";
				Result_04="Pass";
				driver.close();
				//driver.switchTo().window(parentwindow1);
				  }
				  catch(NoSuchElementException e){
					  Premium_Report_url_rendered ="<span style=color:red> Mindfields Premium Report is not rendering,Please look into this issue on priority  - FAIL </span> "; 
					 Result_04="Fail";
				  }
				  
				  catch(ElementNotVisibleException e){
					  Premium_Report_url_rendered ="<span style=color:red> Mindfields Premium Report is not rendering,Please look into this issue on priority  - FAIL </span> "; 
					  Result_04="Fail";
				  }
				  
	              catch(WebDriverException e){
	            	  Premium_Report_url_rendered ="<span style=color:red> Mindfields Premium Report is not rendering,Please look into this issue on priority  - FAIL </span> "; 
	            	Result_04="Fail";
	              }
				  catch(NullPointerException e){
					  Premium_Report_url_rendered ="<span style=color:red> Mindfields Premium Report is not rendering,Please look into this issue on priority  - FAIL </span> "; 
					Result_04="Fail";
				  }
				 
		       // }
				
		       	
			finally {
			driver.quit();
			Result_05=Result_01+" "+Result_02+" "+Result_03+" "+Result_04;
			if(Result_05.contains("Fail Fail")){
			test.sendemail(Report_Heading,Report_Heading1,Basic_Report_url_rendered,Premium_Report_url_rendered);
			  }
			else if(Result_05.contains("Fail Pass")){
				test.sendemail(Report_Heading,Report_Heading1,Basic_Report_url_rendered,Premium_Report_url_rendered);
			}
			else if(Result_05.contains("Pass Fail")){
				test.sendemail(Report_Heading,Report_Heading1,Basic_Report_url_rendered,Premium_Report_url_rendered);
			}
					
			else{
				System.out.println("All urls rendered as expected");
			}
			} 	
		    
	   }	
		   	   
		 			
	    };
	    
	    //timer.schedule(task,0,10800000);
	    timer.schedule(task,0,5400000);
	    
	    }
}
