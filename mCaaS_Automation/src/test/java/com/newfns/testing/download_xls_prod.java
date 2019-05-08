package com.newfns.testing;


import java.io.File;
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


import com.mcaas.genericlibraries.Xls_Reader;

public class download_xls_prod {
	public static void main(String[] args) throws InterruptedException {
		String downloadPath = "C:\\Users\\sudhakar.koduri\\Downloads";
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Production_testing\\Excel_download_prod.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		System.out.println(rowCount);
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*String parentwindow =null;
		String Reserach_heading=null;*/
		int j=2;
		//login
		//try{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("https://quantum.frost.com/#/login");
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("namrata.desai@happiestminds.com");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("password");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		Thread.sleep(10000);
		//Search asset id
		for(int i=25;i<=rowCount;i++){
			System.out.println(i);
		String assetid = xl.getCellData("Sheet1", "CATID", i);
		String xl_linkname=xl.getCellData("Sheet1", "xlsxlink", i);
		
		//Asset id
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")));
			driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")).sendKeys(assetid);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[2]/form/span")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[2]/form/span")).click();
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
		//title
		   try{
			   //Thread.sleep(6000);
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/h2/span")));
               
				String research_title_portal = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/h2/span")).getText();
				System.out.println(research_title_portal);
				xl.setCellData("Sheet1", "Portal_Research_title", i, research_title_portal);
		    }
		   
			catch(ElementNotVisibleException e){
				
			}
			catch(NoSuchElementException e){
				
			}
			catch(WebDriverException e){
				
			}
			catch(NullPointerException e){
				
			}
		   
			//Subtitle
			/*try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[2]/div/div/h3")));
			WebElement sub_title = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[2]/div/div/h3"));
			String research_subtitle_portal = sub_title.getText();
			System.out.println(research_subtitle_portal);
			xl.setCellData("Sheet1", "Portal_Research_subtitle", i, research_subtitle_portal);
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
			//Market and delivery types
			try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]")));
			WebElement Mark_deltype = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]"));
			String Market_delivertype = Mark_deltype.getText();
			System.out.println(Market_delivertype);
			xl.setCellData("Sheet1", "Portal_Mark_deltyp", i, Market_delivertype);
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
				
			}*/
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/span")));
				
				WebElement option = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/span"));
				String option_value = option.getText();
				xl.setCellData("Sheet1", "Option", i, option_value);
	        System.out.println(option_value);
	        if(option_value.equals("DOWNLOAD XLS")){
			option.click();
			Thread.sleep(2000);
			WebElement xls_file = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/div/ul/li/a/span[1]"));
			String xls_name = xls_file.getText();
			System.out.println(xls_name);
			xl.setCellData("Sheet1", "Portal_XLS_file_name", i, xls_name);
			xls_file.click();
			Thread.sleep(20000);
			
			//option.click();
			//driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/div/ul/li/a/span[1]")).click();
			//Thread.sleep(20000);
			File getLatestFile = getLatestFilefromDir(downloadPath);
			String fileName = getLatestFile.getName();
			System.out.println(fileName);
			xl.setCellData("Sheet1", "Downloaded_filename", i, fileName);
	        
			if(xls_name.contains(fileName)){
			System.out.println("Downloaded file is matching with expected file name");
			xl.setCellData("Sheet1", "Result", i, "Pass");
			}
			else{
				System.out.println("Fail");
				xl.setCellData("Sheet1", "Result", i, "Fail");
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
		driver.navigate().refresh();
		Thread.sleep(10000);
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
