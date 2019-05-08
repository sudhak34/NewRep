package com.ke.test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class KE_Test_resp {
	public static String loadingIcon = "div.spinner";
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://memberuat.frost.com");
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("namrata.desai@happiestminds.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("Password@123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 90);
        Boolean isElementPresent = wait1
        .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loadingIcon)));
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pkw-portal']")));
		driver.findElement(By.xpath(".//*[@id='pkw-portal']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='portal-chatbot-panel']/div[3]/form/div/textarea")));
		driver.findElement(By.xpath(".//*[@id='portal-chatbot-panel']/div[3]/form/div/textarea")).sendKeys("Healthcare");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='portal-chatbot-panel']/div[3]/form/div/button")).click();
		long starttime = System.currentTimeMillis();
		boolean contains = driver.getPageSource().contains("Searching...");
		WebElement text = driver.findElement(By.xpath("//span[text()='Searching...']"));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath("//span[text()='Searching...']"))));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".loader-anim.bot"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='message_1']/div[1]/div/div[1]/div")));
		long finish = System.currentTimeMillis();
		long totalTime = finish - starttime; 
		String s=String.valueOf(totalTime/1000);
		System.out.println(s);*/
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/form/input"))).sendKeys("D777-00-A7-00-00");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='filter-overlay']/div[2]/form/span"))).click();
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loadingIcon)));
        driver.findElement(By.xpath(".//*[@id='read_research1']")).click();
        String parentwindow = driver.getWindowHandle();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loadingIcon)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='collapseOne']/div/div/div/ul/li/a"))).click();
       
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pf5']/div[1]/img"))).click();
        
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='sectionItemsForReport_2_1']/div/span/div/div[1]/div[1]/span[1]/span"))).click();
        //Actions hover = new Actions(driver);
        
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pf5']/div[1]/img")));
        element.click();
        Thread.sleep(6000);
        WebElement element2 = driver.findElement(By.xpath(".//*[@class='icon-c']"));
        //String attribute = driver.findElement(By.cssSelector(".sprite.grab_icon-report")).getAttribute("data-original-title");
        //System.out.println(attribute);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element2);
        System.out.println("vault selected");
        //System.out.println(driver.findElement(By.xpath("//.[@class='ng-scope success-msg'][@ng-class='vm.messageClass']")).getText());
        //Thread.sleep(20000);
       // System.out.println(driver.findElement(By.xpath("//.[@class='ng-binding ng-scope success-msg'][@ng-class='vm.messageClass']")).getText());
        //String attribute1 = driver.findElement(By.cssSelector(".sprite.grab_icon-report.tooltip-background")).getAttribute("data-original-title");
       // System.out.println(attribute1);
        /*Point point = element.getLocation();
        System.out.println(point.getX() +"----------"+point.getY());*/
        /*hover.moveToElement(mainMenu);
        hover.build();
        hover.perform();*/
       // Actions action = new Actions(driver);
       // action.moveToElement(element, point.getX(), point.getY()).click().build().perform();
        
        
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='sectionItemsForReport_2_1']/div/span/div/div[1]/div[1]/span[1]"))).click();
        /*hover.build();
        hover.perform();*/
        
        //System.out.println("vault selected");
	}

}
