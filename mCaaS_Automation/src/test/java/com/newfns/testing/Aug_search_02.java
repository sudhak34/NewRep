package com.newfns.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.mcaas.genericlibraries.Xls_Reader;

public class Aug_search_02 {

	public static void main(String[] args) throws InterruptedException {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Aug_search\\Aug_search_final_data\\New folder\\Del_Type\\Aug_search_OLD_index_UAT_data_Del_Updated_02.xlsx");
		int rowCount_01 = xl.getRowCount("Sheet1");
		int rowCount_02 = xl.getRowCount("Sheet2");
		System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Latest_2000_KE\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("https://memberuat.frost.com/#/login");
		driver.get("https://mcaas-uat-icm-fns-portal-ui-v2.mybluemix.net/login");
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebDriverWait wait1=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='emailid']")));
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='emailid']")).sendKeys("namrata.desai@happiestminds.com");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("Password@123");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		Thread.sleep(20000);
		int j=1060;
		for(int k=197;k<=254;k++){
		System.out.println(k);
		String search = xl.getCellData("Sheet1", "Search_Term", k);
		System.out.println(search);
		xl.setCellData("Sheet2", "Input", j, search);
		try{
		WebElement Search_textbox = driver.findElement(By.xpath("html/body/div[3]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/input"));
		Search_textbox.clear();
		Search_textbox.sendKeys(search);
		driver.findElement(By.xpath("html/body/div[3]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/span[2]/button")).click();
		Thread.sleep(30000);
		String results_count = driver.findElement(By.xpath("html/body/div[3]/div[3]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span/span")).getText();
		xl.setCellData("Sheet2", "Total_results_count", j, results_count);
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
		
		try{
		for(int i=1;i<=15;i++){
			//Thread.sleep(1000);
			
			try{
				String Reserach_title = driver.findElement(By.xpath("html/body/div[3]/div[3]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[1]/div[1]/div/div/a/h2/span")).getText();
				xl.setCellData("Sheet2","Top_15_results", j,Reserach_title);
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
			try{
				String Published_date = driver.findElement(By.xpath("html/body/div[3]/div[3]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[3]/div[1]/div/button")).getText();
				xl.setCellData("Sheet2","Published_date", j,Published_date);
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
			try{
				String Del_type = driver.findElement(By.xpath("html/body/div[3]/div[3]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[3]/div[2]/div/span[1]")).getText();
				xl.setCellData("Sheet2","Delivery_Type", j,Del_type);
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
			try{
				String Indus_type = driver.findElement(By.xpath("html/body/div[3]/div[3]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[3]/div[2]/div/span[2]/span")).getText();
				xl.setCellData("Sheet2","Industry_Type", j,Indus_type);
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
					
			j+=1;
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
		catch(Exception e){
			
		}
		
		}
		
	}

}
