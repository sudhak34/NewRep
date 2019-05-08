package com.newfns.testing;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.antlr.grammar.v3.ANTLRv3Parser.exceptionGroup_return;
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

public class Read_Research_02_latest {
	public static void main(String[] args) throws InterruptedException {
		//String downloadPath = "C:\\Users\\sudhakar.koduri\\Downloads";
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Prod_Read_Research_auto_05012018\\Latest.xlsx");
		int rowCount = xl.getRowCount("Sheet2");
		System.out.println(rowCount);
		System.setProperty("webdriver.chrome.driver", "D:\\driver_new\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		//WebDriver driver  = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parentwindow =null;
		//String Reserach_heading=null;
		String option_value=null;
		int j=2;
		//login
		//try{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("https://quantum.frost.com/#/login");
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebDriverWait wait1=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("namrata.desai@happiestminds.com");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("password");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		Thread.sleep(10000);
		try{
			driver.findElement(By.xpath(".//*[@id='step-0']/div[3]/button")).click();
		}
		catch(Exception e){
			
		}
		//Search asset id
		for(int i=2;i<=150;i++){
			System.out.println(i);
		String assetid = xl.getCellData("Sheet2", "CATID", i);
		String cattitle = xl.getCellData("Sheet2", "CATTITLE", i);
		//Asset id
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")));
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")).sendKeys(assetid);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/form/span")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/span")).click();
		Thread.sleep(9000);
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
			Thread.sleep(5000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/a/h2/span")));
		                                                                                                 
		WebElement title = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/a/h2/span"));
		String research_title_portal = title.getText();
		System.out.println(research_title_portal);
		xl.setCellData("Sheet2", "Portal_Research_title", i, research_title_portal);
		/*if(cattitle.contains(research_title_portal)){
			xl.setCellData("Sheet1", "Title_Match", i, "Pass");
			
		}
		else{
			xl.setCellData("Sheet1", "Title_Match", i, "Fail");
		}*/
		
		//Subtitle
		/*try{
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[2]/div/div/h3")));
	    WebElement sub_title = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[2]/div/div/h3"));
		String research_subtitle_portal = sub_title.getText();
		//System.out.println(research_subtitle_portal);
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
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]")));
		WebElement Mark_deltype = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]"));
		
		String Market_delivertype = Mark_deltype.getText();
		//System.out.println(Market_delivertype);
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
		//option
		try{
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a")));
		
		WebElement option = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a"));
		option_value = option.getText();
		xl.setCellData("Sheet2", "Option", i, option_value);
        //System.out.println(option_value);
                   
         if(option_value.equals(" DOWNLOAD XLS")){
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
	    		String currentUrl = driver.getCurrentUrl();
	    		System.out.println(currentUrl);
	    		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='report-title']/div/div/div/h2")));
	    		Thread.sleep(5000);
	    		String Reserach_heading = driver.findElement(By.xpath(".//*[@id='report-title']/div/div/div/h2")).getText();
	    		xl.setCellData("Sheet2", "Research_UI_title", i, Reserach_heading);
	    		System.out.println(Reserach_heading);
	    		if(Reserach_heading.contains(cattitle)){
	    			xl.setCellData("Sheet2", "Title_Match", i, "Pass");
	    			System.out.println("Pass");
	    		}
	    		else{
	    			xl.setCellData("Sheet2", "Title_Match", i, "Fail");
	    			System.out.println("Fail");
	    		}*/
	    		
	    		//driver.close();
	    		driver.switchTo().window(parentwindow);
	    		
	    		}
	            
	    		catch(ElementNotVisibleException e){
	    			/*xl.setCellData("Sheet2", "Title_Match", i, "Fail");
	    			System.out.println("Fail");
	    			driver.close();*/
	    			driver.switchTo().window(parentwindow);
	    		}
	    		catch(NoSuchElementException e){
	    			/*xl.setCellData("Sheet2", "Title_Match", i, "Fail");
	    			System.out.println("Fail");
	    			driver.close();*/
	    			driver.switchTo().window(parentwindow);
	    		}
	    		catch(WebDriverException e){
	    			/*xl.setCellData("Sheet2", "Title_Match", i, "Fail");
	    			System.out.println("Fail");
	    			driver.close();*/
	    			driver.switchTo().window(parentwindow);
	    		}
	    		catch(NullPointerException e){
	    			/*xl.setCellData("Sheet2", "Title_Match", i, "Fail");
	    			System.out.println("Fail");
	    			driver.close();*/
	    			driver.switchTo().window(parentwindow);
	    		}
        	catch(POIXMLException e){
        		/*xl.setCellData("Sheet2", "Title_Match", i, "Fail");
    			System.out.println("Fail");
        		driver.close();*/
    			driver.switchTo().window(parentwindow);
    		}
    		catch(Exception e){
    			/*xl.setCellData("Sheet2", "Title_Match", i, "Fail");
    			System.out.println("Fail");
    			driver.close();*/
    			driver.switchTo().window(parentwindow);
    		}
        	
	          }    
         else{
 			xl.setCellData("Sheet2", "Title_Match", i, "Fail");
 			System.out.println("Fail");
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
		catch(POIXMLException e){
			
		}
		catch(Exception e){
			
		}
		if(i==150){
			break;
		}
		continue;
		}


	}
}
