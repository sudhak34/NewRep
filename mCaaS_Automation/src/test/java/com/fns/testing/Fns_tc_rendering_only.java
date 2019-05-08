package com.fns.testing;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.mcaas.genericlibraries.Xls_Reader;

public class Fns_tc_rendering_only {
	
	public static void main(String[] args) throws Exception {
		//WebDriver driver=new FirefoxDriver();
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Fns_Research_articles.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parentwindow =null;
		String Reserach_heading=null;
		int j=2;
		//login
		//try{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("http://mcaas-uat-icm-fns-portal-ui.mybluemix.net/#/login");
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("sudhakar.koduri@happiestminds.com");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("password");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		//login successful and Owned any
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")));
		Thread.sleep(10000);
		String Research_count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		System.out.println(Research_count);
		System.out.println(driver.getTitle());
		      //owned Only
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[3]/div[2]/input")));
	    //driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[3]/div[2]/input")).click();
		WebElement radioBtn1 = driver.findElement(By.id("radio2"));
		((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtn1);
		radioBtn1.click();
	    Thread.sleep(10000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/select")));
	    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/select")).click();
	    //driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[2]/div[2]/div")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")));
		String Owned_Research_count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		System.out.println(Owned_Research_count); 
		
		String rowcount = Owned_Research_count.replace(" results found", "");
		int rows = Integer.parseInt(rowcount);
		System.out.println(rows);
		jse.executeScript("scroll(0, 2000)");
		WebElement Items_per_page = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[26]/div/div/select"));
		Select slc=new Select(Items_per_page);
		slc.selectByVisibleText("100");
		Thread.sleep(20000);
		jse.executeScript("scroll(2000, 0)");
		//int k=100;
		for(int i=1;i<=100;i++){
			//JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			Thread.sleep(5000);
			String Research_option_text=null;
			String Research_title_portal=null;
			String Sub_title=null;
			String Research_details_portal=null;
			String Research_Published_date=null;
			
		
			//JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[5]/div/div[2]/div/span/a")));
		WebElement read_research = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[5]/div/div[2]/div/span/a"));		
		try{
        
		Research_option_text = read_research.getText();
		System.out.println(i+"---"+Research_option_text);
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
			//JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[1]/div[1]/div/h2/span")));
			
			WebElement title = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[1]/div[1]/div/h2/span"));
			Research_title_portal = title.getText();
			System.out.println(Research_title_portal);
			xl.setCellData("Sheet1", "Research_article_Title_portal", j, Research_title_portal);
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
			//JavascriptExecutor jse3 = (JavascriptExecutor)driver;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[2]/div/div/h3")));
			
			WebElement research_sub_title = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[2]/div/div/h3"));
			Sub_title = research_sub_title.getText();
			System.out.println(Sub_title);
			xl.setCellData("Sheet1", "Sub-title_Portal", j, Sub_title);
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
			//JavascriptExecutor jse4 = (JavascriptExecutor)driver;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[3]/div[2]/div")));
			
			WebElement Industry_details = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[3]/div[2]/div"));
			Research_details_portal = Industry_details.getText();
			System.out.println(Research_details_portal);
			xl.setCellData("Sheet1", "Industry_details", j, Research_details_portal);
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
			//JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[3]/div[1]/div/button")));
			
			WebElement published_date = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[3]/div[1]/div/button"));
			Research_Published_date = published_date.getText();
			System.out.println(Research_Published_date);
			xl.setCellData("Sheet1", "Published_date", j, Research_Published_date);
		}
        
		catch(ElementNotVisibleException e){
			
		}
		catch(NoSuchElementException e){
			
		}
		catch(WebDriverException e){
			
		}
		catch(NullPointerException e){
			
		}
		
		if(Research_option_text.equalsIgnoreCase("READ RESEARCH")){
		read_research.click();
		    xl.setCellData("Sheet1", "Option", j, Research_option_text);
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
		Reserach_heading = driver.findElement(By.xpath(".//*[@id='report-title']/div/div/div/h2")).getText();
		
		System.out.println(i+"-------"+Reserach_heading);
		xl.setCellData("Sheet1", "Research_article_Title_UI",j,Reserach_heading);
				
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
		driver.close();
		driver.switchTo().window(parentwindow);
		if(Research_option_text.equalsIgnoreCase("READ RESEARCH")){
			xl.setCellData("Sheet1", "Option", j, Research_option_text);	
		}
		else if(Research_option_text.equalsIgnoreCase("VIEW CONTENT")){
			xl.setCellData("Sheet1", "Option", j, Research_option_text);	
		}
        else if(Research_option_text.equalsIgnoreCase("DOWNLOAD PDF")){
        	xl.setCellData("Sheet1", "Option", j, Research_option_text);
		}
        else{
        	xl.setCellData("Sheet1", "Option", j, Research_option_text);	
		}
		j+=1;
		if(i==100){
			i=i-99;
			driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/dir-pagination-controls/ul/li[5]/a")).click();
			Thread.sleep(10000);
			/*if(i>3){
				jse1.executeScript("scroll(0,"+k+")");
				k+=20;
				}
				Thread.sleep(5000);*/	
		}
		/*if(i<=7){
		jse.executeScript("window.scrollBy(0,100)", "");
		}
		else if(i>=8||i<=13){
		jse.executeScript("window.scrollBy(0,150)", "");
		}
		else if(i>=14||i<=20){
			jse.executeScript("window.scrollBy(0,130)", "");
			}
		else if(i>=21||i<=31){
			jse.executeScript("window.scrollBy(0,150)", "");
			}*/
		
		continue;
		
		//for loop ends here
		}
		
		//try ends here
		
		//} 
		
		
		/*catch(ElementNotFoundException e){
			
		}
		catch(ElementNotVisibleException e){
			
		}
		catch(NoSuchElementException e){
			
		}
		catch(WebDriverException e){
			
		}
        catch(NullPointerException e){
			
		}*/

	}

}
