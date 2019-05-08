package com.fns.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fns_tc_sub_lev_ownership {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//login
		driver.get("http://mcaas-prod-icm-fns-portal-ui.mybluemix.net/#/login");
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("bhavana.gavade@happiestminds.com");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login")).click();
		//login successful and Owned any
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")));
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
		System.out.println(Owned_Research_count);*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[1]/nav/div/div[1]/div/ul/li/a/div")));
		driver.findElement(By.xpath("html/body/div[2]/div[1]/nav/div/div[1]/div/ul/li/a/div")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[1]/nav/div/div[1]/div/ul/li/ul/li[4]/span[2]/a")));
		driver.findElement(By.xpath("html/body/div[2]/div[1]/nav/div/div[1]/div/ul/li/ul/li[4]/span[2]/a")).click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/h2")));
		String Subscription_name = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/h2")).getText();
		System.out.println(Subscription_name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[1]/div[2]/h3/span")));
		String Market_name = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[1]/div[2]/h3/span")).getText();
		System.out.println(Market_name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/a")));
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/a")).click();
		Thread.sleep(20000);
		String count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		String Num_of_records = count.replace(" results found", "");
		int Number = Integer.parseInt(Num_of_records);
		System.out.println(Number);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 500)");
		WebElement Items_per_page = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[13]/div/div/select"));
		Select slc=new Select(Items_per_page);
		slc.selectByVisibleText("100");
		Thread.sleep(10000);
		for(int i=1;i<=Number;i++){
			String Research_title = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[1]/div[1]/div/h2/span")).getText();
			String Sub_heading = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[2]/div/div/h3")).getText();
			String newLine = System.getProperty("line.separator");
			System.out.println(Research_title+""+newLine+""+Sub_heading);	
			System.out.println("====================");
		}
		//List<WebElement> findElements = driver.findElements(By.tagName("h2"));
		driver.close();
	}
	
}
