package com.newfns.testing;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
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

public class Quantum_Read_research_testing {

	public static void main(String[] args) throws InterruptedException {
		String downloadPath = "C:\\Users\\sudhakar.koduri\\Downloads";
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Latest_27120217\\Download-PDF.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		System.out.println(rowCount);
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parentwindow =null;
		//String Reserach_heading=null;
		String option_value=null;
		int j=2;
		//login
		//try{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("https://member.frost.com/#/login");
		WebDriverWait wait=new WebDriverWait(driver,20);
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
		for(int i=2;i<=rowCount;i++){
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
		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/span")).click();
		Thread.sleep(6000);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/h2/span")));
		                                                                                                 
		WebElement title = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/h2/span"));
		String research_title_portal = title.getText();
		System.out.println(research_title_portal);
		xl.setCellData("Sheet1", "Portal_Research_title", i, research_title_portal);
		if(cattitle.equals(research_title_portal)){
			xl.setCellData("Sheet1", "Title_Match", i, "Pass");
		}
		else{
			xl.setCellData("Sheet1", "Title_Match", i, "Fail");
		}
		
		//Subtitle
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[2]/div/div/h3")));
	    WebElement sub_title = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[2]/div/div/h3"));
		String research_subtitle_portal = sub_title.getText();
		System.out.println(research_subtitle_portal);
		xl.setCellData("Sheet1", "Portal_Research_subtitle", i, research_subtitle_portal);
		}
        
		catch(ElementNotVisibleException e){
			
		}
		catch(NoSuchElementException e){
			
		}
		catch(WebDriverException e){
			
		}
		catch(NullPointerException e){
			
		}
		//published date
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]/div[1]/div/button")));
		    WebElement Pub_date = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]/div[1]/div/button"));
			String published_date_portal = Pub_date.getText();
			System.out.println(published_date_portal);
			xl.setCellData("Sheet1", "Publisheddate", i, published_date_portal);
			}
	        
			catch(ElementNotVisibleException e){
				
			}
			catch(NoSuchElementException e){
				
			}
			catch(WebDriverException e){
				
			}
			catch(NullPointerException e){
				
			}
		//Market and delivery types
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]/div[2]/div")));
		WebElement Mark_deltype = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]/div[2]/div"));
		
		String Market_delivertype = Mark_deltype.getText();
		System.out.println(Market_delivertype);
		xl.setCellData("Sheet1", "Portal_Mark_deltyp", i, Market_delivertype);
		}
        
		catch(ElementNotVisibleException e){
			
		}
		catch(NoSuchElementException e){
			
		}
		catch(WebDriverException e){
			
		}
		catch(NullPointerException e){
			
		}
		//option
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a")));
		
		WebElement option = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a"));
		option_value = option.getText();
		xl.setCellData("Sheet1", "Option", i, option_value);
        System.out.println(option_value);
        if(option_value.equals("DOWNLOAD PDF")){
        	/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/h2/span")));
    		
    		String Title_pdf = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/h2/span")).getText();
    		xl.setCellData("Sheet1", "Portal_Research_title", i, Title_pdf);
    		System.out.println(Title_pdf);
    		if(cattitle.equals(Title_pdf)){
    			xl.setCellData("Sheet1", "Title_Match", i, "Pass");
    		}
    		else{
    			xl.setCellData("Sheet1", "Title_Match", i, "Fail");
    		}*/
            option.click();
            Thread.sleep(50000);
            File getLatestFile = getLatestFilefromDir(downloadPath);
    		String fileName = getLatestFile.getName();
    		System.out.println(fileName);
    		xl.setCellData("Sheet1", "Downloaded_filename", i, fileName);
    		if(fileName.contains(assetid)){
    		System.out.println("Downloaded file is matching with expected file name");
    		System.out.println("Pass");
    		xl.setCellData("Sheet1", "PDF_match", i, "Pass");
    		}
    		else{
    			System.out.println("Fail");
    			xl.setCellData("Sheet1", "PDF_match", i, "Fail");
    		}
          }
            
       /* else if(option_value.equals("READ RESEARCH")){
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
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='report-title']/div/div/div/h2")));
	    		String Reserach_heading = driver.findElement(By.xpath(".//*[@id='report-title']/div/div/div/h2")).getText();
	    		xl.setCellData("Sheet1", "Research_UI_title", i, Reserach_heading);
	    		System.out.println(Reserach_heading);
	    		driver.close();
	    		driver.switchTo().window(parentwindow);
	    		}
	            catch(ElementNotFoundException e){
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
	    		}*/
        	
	          //}     
        else{
        	System.out.println("No Action");
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
	private static File getLatestFilefromDir(String dirPath){
 	    File dir = new File(dirPath);
 	    File[] files = dir.listFiles();
 	    if (files == null || files.length == 0) {
 	        return null;
 	    }
 	
 	    File lastModifiedFile = files[0];
 	    for (int i = 1; i < files.length; i++) {
 	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
 	           lastModifiedFile = files[i];
 	       }
 	    }
 	    return lastModifiedFile;
 	}

}
