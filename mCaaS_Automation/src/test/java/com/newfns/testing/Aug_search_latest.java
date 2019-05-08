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

public class Aug_search_latest {

	public static void main(String[] args) throws InterruptedException {
		Xls_Reader xl=new Xls_Reader("D:\\Test_Data\\Aug_search_Test_data_Prod_03042019.xlsx");
		System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Latest_2000_KE\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("https://memberuat.frost.com/#/login");
		driver.get("https://member.frost.com");
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebDriverWait wait1=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='emailid']")));
		driver.findElement(By.xpath(".//*[@id='emailid']")).sendKeys("namrata.desai@happiestminds.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("Password@123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		Thread.sleep(5000);
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
		Thread.sleep(10000);
		for(int i=120;i<=276;i++){
		System.out.println(i);
		String search = xl.getCellData("Sheet1", "Input_Query", i);
		//System.out.println(search);
		//xl.setCellData("Sheet2", "Input", j, search);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/input")));
			WebElement Text_box = driver.findElement(By.xpath("html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/input"));
			Text_box.clear();
			Text_box.sendKeys(search);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/span[2]/button")));
			WebElement search_button = driver.findElement(By.xpath("html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/span[2]/button"));
			search_button.click();
			long start_time = System.currentTimeMillis();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span/span")));
			WebElement results = driver.findElement(By.xpath("html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span/span"));
			
			long end_time = System.currentTimeMillis();
			long totalTime1 = end_time-start_time ;
			String s2=String.valueOf(totalTime1/1000);
			xl.setCellData("Sheet1","Response_time", i, s2);
			xl.setCellData("Sheet1","Results", i, results.getText());
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

