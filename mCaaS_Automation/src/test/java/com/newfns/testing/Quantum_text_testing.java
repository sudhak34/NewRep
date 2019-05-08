package com.newfns.testing;

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

public class Quantum_text_testing {

	public static void main(String[] args) throws InterruptedException {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Text.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		System.out.println(rowCount);
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String parentwindow =null;
		String Reserach_heading=null;
		int j=2;
		//login
		//try{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("http://mcaas-uat-icm-fns-portal-ui.mybluemix.net/#/login");
		WebDriverWait wait=new WebDriverWait(driver,20);
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
		for(int i=4150;i<=rowCount;i++){
			System.out.println(i);
		String assetid = xl.getCellData("Sheet1", "CATID", i);
		//Asset id
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/input")));
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/input")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[2]/input")).sendKeys(assetid);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/span")));
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/span")).click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/h2/span")));
		WebElement title = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/h2/span"));
		String research_title_portal = title.getText();
		System.out.println(research_title_portal);
		xl.setCellData("Sheet1", "Portal_Research_title", i, research_title_portal);
		
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
		//Market and delivery types
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]")));
		WebElement Mark_deltype = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[3]"));
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
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a")));
		WebElement option = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a"));
		String option_value = option.getText();
		xl.setCellData("Sheet1", "Option", i, option_value);
        System.out.println(option_value);
		option.click();
		}
        
		catch(ElementNotVisibleException e){
			
		}
		catch(NoSuchElementException e){
			
		}
		catch(WebDriverException e){
			
		}
		catch(NullPointerException e){
			
		}
		
		try{
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
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='report-title']/div/div/div/h2")));
		Reserach_heading = driver.findElement(By.xpath(".//*[@id='report-title']/div/div/div/h2")).getText();*/
		Reserach_heading = driver.getCurrentUrl();
		xl.setCellData("Sheet1", "Research_UI_title", i, Reserach_heading);
		System.out.println(Reserach_heading);
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
