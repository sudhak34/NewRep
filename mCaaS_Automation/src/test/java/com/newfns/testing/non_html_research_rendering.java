package com.newfns.testing;

import java.util.List;
import java.util.Set;
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

public class non_html_research_rendering {

	public static void main(String[] args) throws InterruptedException {
		//String downloadPath = "C:\\Users\\sudhakar.koduri\\Downloads";
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\PKW\\PKW_249_03_01_2018\\PKW_249_latest.xlsx");
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
		//driver.get("https://mcaas-local-icm-fns-portal-ui.mybluemix.net/#/login");
		//driver.get("https://mcaas-dev-icm-fns-portal-ui.mybluemix.net/#/login");
		driver.get("https://quantum.frost.com/#/login");
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("namrata.desai@happiestminds.com");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("password");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		Thread.sleep(20000);
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[5]/div[3]/button")));
		driver.findElement(By.xpath("html/body/div[5]/div[3]/button")).click();*/
		Thread.sleep(10000);
		//Search asset id
		for(int i=2;i<=120;i++){
			System.out.println(i);
		String assetid = xl.getCellData("Sheet1", "CATID", i);
		//String cattitle = xl.getCellData("Sheet1", "CATTITLE", i);
		//Asset id
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")));
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input")).sendKeys(assetid);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[2]/form/span")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[2]/form/span")).click();
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
		//Research title
		
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/a/h2/span")));
		                                                                                                 
		WebElement title = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div/a/h2/span"));
		String research_title_portal = title.getText();
		//System.out.println(research_title_portal);
		xl.setCellData("Sheet1", "Portal_Research_title", i, research_title_portal);
		/*if(cattitle.contains(research_title_portal)){
			xl.setCellData("Sheet1", "Title_Match", i, "Pass");
			
		}
		else{
			xl.setCellData("Sheet1", "Title_Match", i, "Fail");
		}*/
		
		//Subtitle
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[2]/div/div/h3")));
	    WebElement sub_title = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[2]/div/div/h3"));
		String research_subtitle_portal = sub_title.getText();
		//System.out.println(research_subtitle_portal);
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
		//Market and delivery types
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]")));
		WebElement Mark_deltype = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]"));
		
		String Market_delivertype = Mark_deltype.getText();
		//System.out.println(Market_delivertype);
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
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div/div[9]/div/div/div/h2")));
	    		Thread.sleep(5000);
	    		String Reserach_heading = driver.findElement(By.xpath("html/body/div[2]/div/div[9]/div/div/div/h2")).getText();
	    		xl.setCellData("Sheet1", "Research_UI_title", i, Reserach_heading);
	    		System.out.println(Reserach_heading);
	    		System.out.println("===================================");
	    		List<WebElement> sub_title = driver.findElements(By.tagName("h3"));
	    		for(WebElement z:sub_title){
	    			System.out.println(z.getText());
	    		}
	    		System.out.println("++++++++++++++++++++");
	    		Thread.sleep(60000);
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
        	
	          }     
        
        }
        
		catch(ElementNotVisibleException e){
			driver.navigate().refresh();
		}
		catch(NoSuchElementException e){
			driver.navigate().refresh();	
		}
		catch(WebDriverException e){
			driver.navigate().refresh();
		}
		catch(NullPointerException e){
			driver.navigate().refresh();	
		           }
		}
        
		catch(ElementNotVisibleException e){
			driver.navigate().refresh();
		}
		catch(NoSuchElementException e){
			driver.navigate().refresh();	
		}
		catch(WebDriverException e){
			driver.navigate().refresh();
		}
		catch(NullPointerException e){
		  driver.navigate().refresh();
		}
		continue;
		}


	}

}