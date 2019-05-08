package com.newfns.testing;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.POIXMLException;
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


import com.mcaas.genericlibraries.Xls_Reader;

public class Read_Reserach_01_latest {
	public static void main(String[] args) throws InterruptedException {
		//String downloadPath = "C:\\Users\\sudhakar.koduri\\Downloads";
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Prod_Read_Research_auto_05012018\\Prod_research_08062018\\New folder\\New_03.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		System.out.println(rowCount);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sudhakar.koduri\\Desktop\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		//WebDriver driver  = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parentwindow =null;
		//String Reserach_heading=null;
		String option_value=null;
		int j=2;
		int k=2;
		String finalString=null;
		//login
		//try{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("https://member.frost.com/#/login");
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("namrata.desai@happiestminds.com");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("Password@123");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		Thread.sleep(10000);
		//Search asset id
		for(int i=370;i<430;i++){
			System.out.println(i);
		String assetid = xl.getCellData("Sheet1", "CATID", i);
		String cattitle = xl.getCellData("Sheet1", "CATTITLE", i);
		//Asset id
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")));
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")).sendKeys(assetid);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/form/span")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/span")).click();
		Thread.sleep(10000);
		}
       
		catch(ElementNotVisibleException e){
			
		}
		catch(NoSuchElementException e){
			
		}
		catch(WebDriverException e){
			
		}
		catch(NullPointerException e){
			
		}
		//Research title
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/a/h2/span")));
		                                                                                                 
		WebElement title = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/a/h2/span"));
		String research_title_portal = title.getText().replaceAll("-"," ").replaceAll(":", " ").replaceAll("\\s{2,}"," ");
		System.out.println(research_title_portal);
		
		xl.setCellData("Sheet1", "Portal_Research_title", i, research_title_portal);
		//option
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a")));
		
		WebElement option = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a"));
		option_value = option.getText();
		xl.setCellData("Sheet1", "Option", i, option_value);
        //System.out.println(option_value);
                   
         if(option_value.equals("READ RESEARCH")){
        	try{
	        option.click();
	        	parentwindow = driver.getWindowHandle();
	    		String childwindow = null;
	    		
	    		Set<String> windows = driver.getWindowHandles();
	    		
	    		for(String x :windows)
	    		{
	    			//System.out.println(x);
	    			if(!x.equals(parentwindow))
	    			{
	    				childwindow = x;
	    			}
	    		}
	    		
	    		//System.out.println(childwindow);
	    		driver.switchTo().window(childwindow);
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div/div[10]/div/div/div/h2")));
	    		Thread.sleep(5000);
	    		String Reserach_heading = driver.findElement(By.xpath("html/body/div[3]/div/div[10]/div/div/div/h2")).getText().replaceAll("-","").replaceAll(":", " ").replaceAll("\\s{2,}"," ");
	    		xl.setCellData("Sheet1", "Research_UI_title", i, Reserach_heading);
	    		System.out.println(Reserach_heading);
	    		if(Reserach_heading.contains(research_title_portal)){
	    			xl.setCellData("Sheet1", "Title_Match", i, "Pass");
	    			System.out.println("Pass");
	    		}
	    		else{
	    			xl.setCellData("Sheet1", "Title_Match", i, "Fail");
	    			System.out.println("Fail");
	    		}
	    		Thread.sleep(20000);
	    		try{
		    		 
	    			List<WebElement> element = driver.findElements(By.xpath("//div[1]/h3"));
					StringBuilder sb = new StringBuilder();   
	    			 for(WebElement x:element){
	    				sb.append(x.getText());
						}
 		             
	    			 System.out.println(sb.toString());	
	    			 xl.setCellData("Sheet1", "h3_headers", i, sb.toString());
	    		}
	    		
	    		
	    		catch(ElementNotVisibleException e){
	    			
	    		}
	    		catch(NoSuchElementException e){
	    			
	    		}
	    		catch(WebDriverException e){
	    			
	    		}
	    		catch(NullPointerException e){
	    			
	    		}
	    		catch(POIXMLException e){
	    			
	    		}
	    		catch(Exception e){
	    			
	    		}
	    		driver.close();
	    		driver.switchTo().window(parentwindow);
	    		
	    		}
	            
	    		catch(ElementNotVisibleException e){
	    			driver.close();
	    			driver.switchTo().window(parentwindow);
	    		}
	    		catch(NoSuchElementException e){
	    			driver.close();
	    			driver.switchTo().window(parentwindow);
	    		}
	    		catch(WebDriverException e){
	    			driver.close();
	    			driver.switchTo().window(parentwindow);
	    		}
	    		catch(NullPointerException e){
	    			driver.close();
	    			driver.switchTo().window(parentwindow);
	    		}
        	
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
