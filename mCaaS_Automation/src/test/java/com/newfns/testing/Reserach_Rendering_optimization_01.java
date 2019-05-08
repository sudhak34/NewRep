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

//import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.mcaas.genericlibraries.Xls_Reader;

public class Reserach_Rendering_optimization_01 {

	public static void main(String[] args) throws InterruptedException {
		//String downloadPath = "C:\\Users\\sudhakar.koduri\\Downloads";
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Short_url\\1k_ids_01_01.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		int rowCount_02 = xl.getRowCount("Sheet2");
		//rowCount_02=20;
		System.out.println(rowCount);
		System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Latest_2000_KE\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		//WebDriver driver  = new FirefoxDriver();
		//WebDriver driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parentwindow =null;
		//String Reserach_heading=null;
		String option_value=null;
		String Reserach_heading=null;
		WebElement option =null;
		//int j=2;
		//login
		//try{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("https://memberuat.frost.com");
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebDriverWait wait1=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='emailid']")));
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='emailid']")).sendKeys("namrata.desai@happiestminds.com");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("Password@123");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		Thread.sleep(20000);
		
		//Search asset id
		int k=500;
		for(int i=501;i<=rowCount;i++){
			System.out.println(i);
			if( i%5==0){
				driver.navigate().refresh();
				Thread.sleep(30000);
			}
		String assetid = xl.getCellData("Sheet1", "CATID", i);
		String asset_01 = assetid.replaceAll("00","").replaceAll("-","").replaceAll("  ","").replaceAll(" ","");
		System.out.println(asset_01);
			try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")));
			driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")).sendKeys(assetid);
			xl.setCellData("Sheet2", "Asset_ID", k, assetid);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/form/span")));
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/span")).click();
			Thread.sleep(5000);
		}
        
		catch(ElementNotVisibleException e){
			
		}
		catch(NoSuchElementException e){
			
		}
		catch(WebDriverException e){
			
		}
		catch(NullPointerException e){
			
		}
		catch(Exception e){
			
		}
		//Research title
		try{
			Thread.sleep(3000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/a/h2/span")));
		if(driver.findElement(By.xpath("//research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/a/h2/span")).isDisplayed()){
		
		                                                                                                 
		WebElement title = driver.findElement(By.xpath("//research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/a/h2/span"));
		String research_title_portal = title.getText();
		System.out.println(research_title_portal);
		xl.setCellData("Sheet2", "Portal_Research_title", i, research_title_portal);
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
		catch(POIXMLException e){
			
		}
		catch(Exception e){
			
		}
		try{
		if(driver.findElement(By.xpath("//research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/button")).isDisplayed()){
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/button")));
            
			WebElement title = driver.findElement(By.xpath("//research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/button"));
			String research_title_portal = title.getText();
			System.out.println(research_title_portal);
			xl.setCellData("Sheet2", "Portal_Research_title", i, research_title_portal);
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
		catch(POIXMLException e){
			
		}
		catch(Exception e){
			
		}
		try{
		if(driver.findElement(By.xpath("html/body/div[3]/div[3]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[1]")).isDisplayed()){	
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[3]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[1]")));
			
			 String No_result = driver.findElement(By.xpath("html/body/div[3]/div[3]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[1]")).getText();
			System.out.println(No_result);
			xl.setCellData("Sheet2", "Option_No_result", i, No_result);
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
		catch(POIXMLException e){
			
		}
		catch(Exception e){
			
		}
		
		try{
			if(driver.findElement(By.xpath("//research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a")).isDisplayed()){	
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a")));
		
		option = driver.findElement(By.xpath("//research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a"));
		option_value = option.getText();
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
		catch(POIXMLException e){
			
		}
		catch(Exception e){
			
		}
		try{  
		if(driver.findElement(By.xpath("//research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/button")).isDisplayed()){	
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/button")));
				
				option = driver.findElement(By.xpath("//research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/button"));
				option_value = option.getText();
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
		catch(POIXMLException e){
			
		}
		catch(Exception e){
			
		}
		try{
			
		xl.setCellData("Sheet2", "Option", i, option_value);
        System.out.println(option_value);
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
	    		Thread.sleep(6000);
	    		//driver.findElement(By.xpath("html/body/div[3]/div/div[13]/div/span")).isDisplayed();
	    		    boolean contains = driver.getPageSource().contains("Please wait research is loading");
	    		    if(contains==false){
	    			System.out.println(contains);
	    			Thread.sleep(2000);
	    			//contains = driver.getPageSource().contains("Please wait research is loading");
	    			}
	    		    long start = System.currentTimeMillis();
	    		    contains = driver.getPageSource().contains("Please wait research is loading");
	    		      if(contains==false){
		    			//System.out.println(contains);
		    			Thread.sleep(2000);
		    			//contains = driver.getPageSource().contains("Please wait research is loading");
		    			}
	    		      contains = driver.getPageSource().contains("Please wait research is loading");
	    		      if(contains==false){
		    			//System.out.println(contains);
		    			Thread.sleep(3000);
		    			//contains = driver.getPageSource().contains("Please wait research is loading");
		    			}
	    		      contains = driver.getPageSource().contains("Please wait research is loading");
	    		      if(contains==false){
		    			//System.out.println(contains);
		    			Thread.sleep(4000);
		    			//contains = driver.getPageSource().contains("Please wait research is loading");
		    			}
	    		      contains = driver.getPageSource().contains("Please wait research is loading");
	    		      if(contains==false){
		    			//System.out.println(contains);
		    			Thread.sleep(5000);
		    			//contains = driver.getPageSource().contains("Please wait research is loading");
		    			}
	    			for(int m=1;m<=30;m++){
	    			contains = driver.getPageSource().contains("Please wait research is loading");
	    			if(contains==true){
	    			//System.out.println(contains);
	    			Thread.sleep(2000);
	    			//contains = driver.getPageSource().contains("Please wait research is loading");
	    			}
	    			
	    				//Thread.sleep(2000);
	    			else if(contains!=true){
	    				System.out.println(contains);
	    				break;
	    			}
	    			
	    			
	    		}
	    		
	    			    			  		
	    			long finish = System.currentTimeMillis();
					long totalTime = finish - start; 
					String s=String.valueOf(totalTime/1000);
					System.out.println(s);
					 xl.setCellData("Sheet2", "Response_Time", i, s);
					 Thread.sleep(5000);
	    		try{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='report-title']/div/div/div/h2")));
	    		Reserach_heading = driver.findElement(By.xpath(".//*[@id='report-title']/div/div/div/h2")).getText();
	    		xl.setCellData("Sheet2", "Research_UI_title", k, Reserach_heading);
	    		xl.setCellData("Sheet2", "Asset_ID", k, assetid);
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
	    		
	    		
	    		System.out.println(Reserach_heading);
	    		//h3_01
	    		try{
	    			List<WebElement> element = driver.findElements(By.xpath("//div[1]/h3"));
					StringBuilder sb = new StringBuilder();
					
	    			 for(WebElement x:element){
	    				sb.append(x.getText());
						}
 		             
	    			// System.out.println(sb.toString());	
	    			 xl.setCellData("Sheet2", "h3_headers", i, sb.toString());
	    			
 		
						
					
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
	    		
	    		//System.out.println(k);
	    		driver.close();
	    		driver.switchTo().window(parentwindow);
	    		
	    		}
	            
	    		catch(ElementNotVisibleException e){
	    			//driver.close();
	            	driver.switchTo().window(parentwindow);
	    		}
	    		catch(NoSuchElementException e){
	    			//driver.close();
	            	driver.switchTo().window(parentwindow);
	    		}
	    		catch(WebDriverException e){
	    			//driver.close();
	            	driver.switchTo().window(parentwindow);
	    		}
	    		catch(NullPointerException e){
	    			//driver.close();
	            	driver.switchTo().window(parentwindow);
	    		}
        	catch(POIXMLException e){
        		//driver.close();
            	driver.switchTo().window(parentwindow);
    		}
    		catch(Exception e){
    			//driver.close();
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
        catch(POIXMLException e){
			
		}
		catch(Exception e){
			
		}
		
		try{
		String id = driver.findElement(By.xpath("html/body/div[3]/div[3]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]/div[2]/div/span[3]")).getText();
	     String id_01 = id.replaceAll("00","").replaceAll("/","").replaceAll("  ","").replaceAll(" ","");
	     System.out.println(id_01);
	     if(asset_01.contains(id_01)){
		 //
	     }
	     else {
	    	 
	    	 driver.navigate().refresh();
	    	 Thread.sleep(30000);
	    	 
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
        catch(POIXMLException e){
			
		}
		catch(Exception e){
			
		}
		k+=1;
	    continue;
		}


	}


}
