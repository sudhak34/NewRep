package com.newfns.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mcaas.genericlibraries.Xls_Reader;

public class mpuat_augsearch_reposnetime {

	public static void main(String[] args) throws InterruptedException {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Aug_search\\Aug_search_final_data\\AuG_search_MP_uat_New_index_Response_time.xlsx");
		int rowCount_01 = xl.getRowCount("Sheet1");
		System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Latest_2000_KE\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://memberuat.frost.com/#/login");
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
		for(int i=197;i<=rowCount_01;i++){
			String search = xl.getCellData("Sheet1", "Input", i);
			System.out.println(i);
			WebElement Search_textbox = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/input"));
			Search_textbox.clear();
			Search_textbox.sendKeys(search);
			long start = System.currentTimeMillis();
			driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/span[2]/button")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span/span")));
			driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span/span")).isDisplayed();
			long finish = System.currentTimeMillis();
			long totalTime = finish - start; 
			String s=String.valueOf(totalTime);
			System.out.println(s);
			//System.out.println(totalTime);
			xl.setCellData("Sheet1", "Response_time", i,s);
			
		}
	}

}
