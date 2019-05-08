package com.fns.testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_class {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//login
		//driver.get("http://mcaas-prod-icm-fns-portal-ui.mybluemix.net/#/login");
		WebDriverWait wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("emailid")));
		driver.get("https://mcaas-icm-prod-fns-report-ui.mybluemix.net/#/assets/1/413/1713/D79F-01-00-00-00/research?eui=16");
		Thread.sleep(20000);
		WebElement values3 = driver.findElement(By.cssSelector("div[class='col-md-12 section-height']"));
		List<WebElement> findElements3 = values3.findElements(By.tagName("h3"));
			for(WebElement x:findElements3){
		//for(int i=0;i<findElements3.size();i++){
			System.out.println(x.getText());
			/*if(findElements3.get(i).getText().contains("Hello")){
				System.out.println("Element is visible");
			}
			else{
				System.out.println("Element is not visible");
			}*/
			}
		

	}

}
