package com.fns.testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class new_pkw_02 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://mcaas-icm-uat-fns-report-ui.mybluemix.net/#/assets/2/0b407a24-acfd-11e7-ae3a-1aa9f74f20ad/711fc21c-984b-11e7-8102-3ed4ee2a58e9/research?eui=8cff659e-9c71-11e7-9069-3ed4ee2a58e9");
		WebDriverWait wait=new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='report-title']/div/div/div/h2")));
		String Reserach_heading = driver.findElement(By.xpath(".//*[@id='report-title']/div/div/div/h2")).getText();
		System.out.println(Reserach_heading);
		Thread.sleep(30000);
        System.out.println("--------h3----------");
		
		List<WebElement> findElements1 = driver.findElements(By.tagName("h3"));
		
			for(WebElement x:findElements1){
				
			System.out.println(x.getText());
			
			}
			System.out.println("--------span----------");
		List<WebElement> findElements2 = driver.findElements(By.xpath("//div[contains(@class,'QUOTEBOLDITALICTEXT')]"));
		for(WebElement y:findElements2){
			
			System.out.println(y.getText());
			
			}
	}

}
