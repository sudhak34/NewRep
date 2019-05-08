package com.fns.testing;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mcaas.genericlibraries.Xls_Reader;

public class new_pkw_automation_01 {

	public static void main(String[] args) throws InterruptedException {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Fns_Research_articles.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
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
		WebDriverWait wait=new WebDriverWait(driver,90);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/input")));
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/input")).clear();
		Thread.sleep(10000);
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[2]/input")).sendKeys("9AAE-00-2D-00-00");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/span")));
		Thread.sleep(20000);
		driver.findElement(By.xpath(".//*[@id='filter-overlay']/div[2]/span")).click();
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a")));
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a")).click();
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
		System.out.println(Reserach_heading);
		Thread.sleep(30000);
		/*System.out.println("--------h1----------");
		List<WebElement> findElements1 = driver.findElements((By.tagName("h1")));
		for(WebElement x:findElements1){
		System.out.println(x.getText());
		}*/
		/*System.out.println("--------h2----------");
		List<WebElement> findElements2 = driver.findElements((By.tagName("h2")));
		
		for(WebElement x:findElements2){
			System.out.println(x.getText());
		
		
		}*/
		Thread.sleep(30000);
		System.out.println("--------h3----------");
		
		List<WebElement> findElements3 = driver.findElements(By.tagName("h3"));
		
			for(WebElement x:findElements3){
				
			System.out.println(x.getText());
			Thread.sleep(20000);
			System.out.println("--------span----------");
			WebElement values = driver.findElement(By.tagName("h3"));
			List<WebElement> findElements4 = values.findElements(By.xpath("//span[contains(@class,'QUOTEBOLDITALICTEXT')]"));
			for(WebElement y:findElements4){
			System.out.println(y.getText());
			}
			}
			
			/*System.out.println("--------span----------");
			WebElement values = driver.findElement(By.cssSelector("div[class='panel-body']"));
			List<WebElement> findElements4 = values.findElements(By.xpath("//span[contains(@class,'QUOTEBOLDITALICTEXT')]"));
			for(WebElement y:findElements4){
				
				System.out.println(y.getText());
				
				}*/

		

	}

}
