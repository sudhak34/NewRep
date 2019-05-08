package com.newfns.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tag {

	public static void main(String[] args) throws InterruptedException {
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\sudhakar.koduri\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();*/
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://memberuat.frost.com/#/login");
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("sudhakar.koduri@happiestminds.com");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("Password123#");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		Thread.sleep(20000);
        driver.findElement(By.xpath(".//*[@id='tag_0']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='tagName']")).click();
        Thread.sleep(2000);
        WebElement text_box = driver.findElement(By.cssSelector("#tagName"));
        driver.findElement(By.xpath("//*[@id='tagName']"));
        
        //driver.findElement(By.xpath("html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[29]/div/form/label")).click();
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        Thread.sleep(2000);
        text_box.clear();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[29]/div/form/label")).click();
        /*js.executeScript("arguments[0].click();",text_box);
        Thread.sleep(2000);*/
        //((JavascriptExecutor) driver).executeScript("arguments[0].click;", text_box);
        JavascriptExecutor jse= (JavascriptExecutor) driver; jse.executeScript("arguments[0].value='Hello';", text_box);
        text_box.sendKeys("world");
        //text_box.sendKeys("xyz");
        Thread.sleep(2000);
        driver.findElement(By.xpath("html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[29]/div/form/div[6]/button[1]")).click();
        
	}

}
