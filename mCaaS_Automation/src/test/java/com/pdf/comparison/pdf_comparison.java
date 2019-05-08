package com.pdf.comparison;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pdf_comparison {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,10);
		driver.get("https://mcaas-icm-prod-fns-report-ui.mybluemix.net/#/assets/1/413/1713/D79F-01-00-00-00/research?eui=12");
		Thread.sleep(50000);
		List<WebElement> content = driver.findElements(By.tagName("body"));
		for(WebElement element:content ){
		String k = element.getText();
        System.out.println(element.getText());
        String attribute = element.getAttribute("innerHTML");
	}
		
	}

}
