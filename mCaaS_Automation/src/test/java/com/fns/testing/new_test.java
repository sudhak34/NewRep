package com.fns.testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class new_test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\Sudhakar_mCaaS\\DQA\\Latest\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//login
		//driver.get("http://mcaas-prod-icm-fns-portal-ui.mybluemix.net/#/login");
		WebDriverWait wait=new WebDriverWait(driver,50);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("emailid")));
		driver.get("https://mcaas-icm-prod-fns-report-ui.mybluemix.net/#/assets/1/413/1713/D79F-01-00-00-00/research?eui=12");
		Thread.sleep(20000);
		//driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div/div[2]/div/div[1]/span")).click();
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div/div[3]/div/div/div[2]/div/div[3]/span")));
		driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div/div[2]/div/div[3]/span")).click();*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='collapseOne']/div/div/div[3]/ul/li/a")));
		driver.findElement(By.xpath(".//*[@id='collapseOne']/div/div/div[3]/ul/li/a")).click();
		Thread.sleep(15000);
		WebElement result = driver.findElement(By.tagName("h3"));
		System.out.println(result.getLocation());
		if(result.isEnabled()){
			System.out.println(result.getText());
		}
		
	}

}
