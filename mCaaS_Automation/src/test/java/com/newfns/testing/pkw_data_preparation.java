package com.newfns.testing;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.POIXMLException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.mcaas.genericlibraries.Xls_Reader;

public class pkw_data_preparation {
	public static void main(String[] args) throws InterruptedException {
		//String downloadPath = "C:\\Users\\sudhakar.koduri\\Downloads";
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\KE_New_Approach_4k\\PKW_set_01_1700.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		int rowCount_02 = xl.getRowCount("Sheet2");
		//rowCount_02=20;
		System.out.println(rowCount);
		System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Latest_2000_KE\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		//WebDriver driver  = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parentwindow =null;
		//String Reserach_heading=null;
		String option_value=null;
		String Reserach_heading=null;
		int j=2;
		//login
		//try{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//driver.get("https://quantum.frost.com/#/login");
		//driver.get("https://memberuat.frost.com/login");
		driver.get("https://mcaas-uat-icm-fns-portal-ui-v2.mybluemix.net/login");
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
		Thread.sleep(10000);
		
		//Search asset id
		int k=2;
		for(int i=2;i<=4000;i++){
			System.out.println(i);
			if( i%10==0){
				driver.navigate().refresh();
				Thread.sleep(20000);
			}
		String assetid = xl.getCellData("Sheet1", "CATID", i);
		xl.setCellData("Sheet2", "Asset_ID", i, assetid);
		//String cattitle = xl.getCellData("Sheet2", "CATTITLE", i);
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
		catch(Exception e){
			
		}
		//Research title
		try{
			Thread.sleep(5000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/a/h2/span")));
		                                                                                                 
		WebElement title = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/a/h2/span"));
		String research_title_portal = title.getText();
		System.out.println(research_title_portal);
		xl.setCellData("Sheet2", "Portal_Research_title", i, research_title_portal);
		
		try{
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a")));
		
		WebElement option = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a"));
		option_value = option.getText();
		//xl.setCellData("Sheet2", "Option", i, option_value);
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
	    		Thread.sleep(10000);
	    		//driver.findElement(By.xpath("html/body/div[3]/div/div[13]/div/span")).isDisplayed();
	    		if(driver.getPageSource().contains("Please wait research is loading")){
	    				System.out.println("Element is Visible1");
	    				Thread.sleep(10000);
	    				}else{
	    				System.out.println("Element is InVisible1");
	    				Thread.sleep(5000);
	    				}
	    			
	    				if(driver.getPageSource().contains("Please wait research is loading")){
	    				System.out.println("Element is Visible2");
	    				Thread.sleep(10000);
	    				}else{
	    				System.out.println("Element is InVisible2");
	    				}
	    				if(driver.getPageSource().contains("Please wait research is loading")){
	    				System.out.println("Element is Visible3");
	    				Thread.sleep(10000);
	    				}else{
	    				System.out.println("Element is InVisible3");
	    				}
	    				if(driver.getPageSource().contains("Please wait research is loading")){
	    				System.out.println("Element is Visible4");
	    				Thread.sleep(10000);
	    				}else{
	    				System.out.println("Element is InVisible4");
	    				}
	    			
	    			if(driver.getPageSource().contains("Please wait research is loading")){
	    				System.out.println("Element is Visible5");
	    				Thread.sleep(10000);
	    				}else{
	    				System.out.println("Element is InVisible5");
	    				}
	    			if(driver.getPageSource().contains("Please wait research is loading")){
	    				System.out.println("Element is Visible6");
	    				Thread.sleep(10000);
	    				}else{
	    				System.out.println("Element is InVisible6");
	    				}
	    			  		
	    		
	    		try{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='report-title']/div/div/div/h2")));
	    		Reserach_heading = driver.findElement(By.xpath(".//*[@id='report-title']/div/div/div/h2")).getText();
	    		xl.setCellData("Sheet2", "Research_UI_title", k, Reserach_heading);
	    		xl.setCellData("Sheet2", "Asset_ID", k, assetid);
	    		k+=1;
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
	    		
	    		/*try{
		    		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='step-0']/div[3]/button")));
		    		Thread.sleep(5000);
		    		driver.findElement(By.xpath(".//*[@id='step-0']/div[3]/button")).click();
	        	     }
                catch(ElementNotFoundException e){
	    			
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
		    		}*/
	    		xl.setCellData("Sheet2", "h3_headers", k, Reserach_heading);
	    		System.out.println(Reserach_heading);
	    		//h3_01
	    		try{
	    		 
	    			List<WebElement> element = driver.findElements(By.xpath("//div[1]/h3"));
					//System.out.println(h3_header.getText());
	    			 //String p="7";
	    			 for(WebElement x:element){
	    				 //System.out.println(x.getSize());
						System.out.println(x.getText());
						String h3 = x.getText();
						String color = x.getCssValue("color");
						String Hex = Color.fromString(color).asHex();
						//xl.setCellData("Sheet2", "CATID", k, assetid);
						
						xl.setCellData("Sheet2", "h3_headers", k, h3);
						//xl.setCellData("Sheet2", "color", k, Hex);
						if(Hex.equals("#01172f")){
							System.out.println("Black");
							xl.setCellData("Sheet2", "color", k, "Black");
							xl.setCellData("Sheet2", "Toc", k, "heading");
							}
							else if (Hex.equals("#119da4")) {
								System.out.println("Blue");
								xl.setCellData("Sheet2", "color", k, "Blue");
								xl.setCellData("Sheet2", "Toc_sub_heading", k, "Sub_heading");
							}
							else{
								
							}
						k+=1;
						
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
		continue;
		}


	}
}

