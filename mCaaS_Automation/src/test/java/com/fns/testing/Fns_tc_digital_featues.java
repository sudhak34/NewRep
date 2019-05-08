package com.fns.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Fns_tc_digital_featues {

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
		Thread.sleep(10000);
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/h2/span")));
		String Research_article = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/h2/span")).getText();
		System.out.println(Research_article);
		String wishlist_enable="sprite fav_small_nor wishlist_tooltip_main ng-scope fav_small_sltd";
		String wishlist_disable="sprite fav_small_nor wishlist_tooltip_main ng-scope";
		//Wishlist
		String wishlist_class_attr_value = driver.findElement(By.id("wishlist_0")).getAttribute("class");
		System.out.println(wishlist_class_attr_value);
		if(wishlist_class_attr_value.equals(wishlist_enable)){
			System.out.println("Research article wishlist icon is enabled");
			}
		else{
			System.out.println("Research article wishlist icon is disabled");
			}
		    driver.findElement(By.xpath("html/body/div[2]/div[1]/nav/div/div[1]/div/ul/li/a/div")).click();
		    driver.findElement(By.xpath("html/body/div[2]/div[1]/nav/div/div[1]/div/ul/li/ul/li[7]/span[2]/a")).click();
		    Thread.sleep(10000);
			String Total_count = driver.findElement(By.className("ng-isolate-scope")).getAttribute("total-count");
			int rowcount = Integer.parseInt(Total_count);
			System.out.println(Total_count);
			StringBuilder sb = new StringBuilder();
			String wishlist_Research=null;
			String complete_string=null;
			for(int i=1;i<=rowcount;i++){
				
				wishlist_Research = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div/research-feed/div[1]/div[2]/div["+i+"]/div/div[1]/div[1]/div/h2/span")).getText();
				//System.out.println(wishlist_Research);
				if(wishlist_Research.equals(Research_article)){
					System.out.println("Research article with wislist icon enabled on home page avaialble in wislist page");
					System.out.println(wishlist_Research);
					//break;
				}
				sb.append(wishlist_Research);
				 complete_string = sb.toString();
			}
			
			System.out.println(complete_string);
			if(!wishlist_Research.contains(complete_string)){
				System.out.println("Research article is not available in wishlist page");
			}
		
		}
		
		catch(ElementNotVisibleException e){
			System.out.println("Fail");
		}
		catch(NoSuchElementException e){
			System.out.println("Fail");
		}
	}

}
