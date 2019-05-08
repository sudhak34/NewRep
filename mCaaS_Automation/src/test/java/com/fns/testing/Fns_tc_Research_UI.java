package com.fns.testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Fns_tc_Research_UI {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Research article details
		try{
		driver.get("https://mcaas-icm-prod-fns-report-ui.mybluemix.net/#/assets/1/413/1713/D79F-01-00-00-00/research?eui=12");
		}
		
		catch(ElementNotVisibleException e){
			System.out.println("Fail");
		}
		catch(NoSuchElementException e){
			System.out.println("Fail");
		}
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait=new WebDriverWait(driver,50);
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div/div[6]/div/div/div/h2")));
		String Reserach_article_heading = driver.findElement(By.xpath("html/body/div[2]/div/div[6]/div/div/div/h2")).getText();
		System.out.println("Research article heading---"+Reserach_article_heading);
		}
		
		catch(ElementNotVisibleException e){
			System.out.println("Fail");
		}
		catch(NoSuchElementException e){
			System.out.println("Fail");
		}
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div/div[6]/div/div/div/h4")));
		String Reserach_article_sub_heading = driver.findElement(By.xpath("html/body/div[2]/div/div[6]/div/div/div/h4")).getText();
		System.out.println("Research article Sub-heading---"+Reserach_article_sub_heading);
		}
		
		catch(ElementNotVisibleException e){
			System.out.println("Fail");
		}
		catch(NoSuchElementException e){
			System.out.println("Fail");
		}
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div/div[6]/div/div/div/h5")));
		String Market_research_id_details = driver.findElement(By.xpath("html/body/div[2]/div/div[6]/div/div/div/h5")).getText();
		System.out.println("Research article market&id---"+Market_research_id_details);
		}
		
		catch(ElementNotVisibleException e){
			System.out.println("Fail");
		}
		catch(NoSuchElementException e){
			System.out.println("Fail");
		}
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div/div[6]/div/div/div/span")));
			String published_date = driver.findElement(By.xpath("html/body/div[2]/div/div[6]/div/div/div/span")).getText();
			System.out.println("Research article published date---"+published_date);
			}
			
			catch(ElementNotVisibleException e){
				System.out.println("Fail");
			}
			catch(NoSuchElementException e){
				System.out.println("Fail");
			}
		//toc
		//WebElement values = driver.findElement(By.xpath("//div[@class='panel-body']"));
		WebElement values = driver.findElement(By.cssSelector("div[class='panel-body']"));
		//List<WebElement> findElements2 = values.findElements(By.xpath("//div[contains(@class,'table-content-inner ng-scope')]"));
		//List<WebElement> findElements2 = values.findElements(By.tagName("li"));
		//List<WebElement> findElements2 = values.findElements(By.cssSelector("html.ng-scope body div.container-fluid.ng-scope div.ng-scope div.toc-container.ng-scope div.ng-scope div#accordion.panel-group.ng-scope div.panel.panel-default.ng-scope div#collapseOne.panel-collapse.in div.panel-body div.ng-scope"));
		List<WebElement> findElements2 = values.findElements(By.xpath("//div[@class='panel-body']"));
		//for(WebElement x:findElements2){
		
			driver.findElement(By.xpath(".//*[@id='collapseOne']/div/div/div[1]/span")).click();
			
		         /*JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		         jsExec.executeScript("document.getElementByxpath('//div[@class='panel-body').scrollDown += 100");*/
		        
		         for(WebElement x:findElements2){
		        	 
		        	 System.out.println(x.getText());
		        	 driver.findElement(By.xpath(".//*[@id='collapseOne']/div/div/div[1]/span")).click();
		     
	}
        driver.close();
	}

}
