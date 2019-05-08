package com.fns.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Fns_tc_default_feed {

	public static void main(String[] args) throws InterruptedException, NoSuchFieldException {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")));
		Thread.sleep(10000);
		String Research_count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		System.out.println("Resarch count displayed for any on default feed----"+Research_count);
		String count = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span")).getText();
		String Num_of_records = count.replace(" results found", "");
		int Number = Integer.parseInt(Num_of_records);
		System.out.println(Number);
		//Research articles on default feed
		for(int i=1;i<=10;i++){
			try{
			String Research_title = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[1]/div[1]/div/h2/span")).getText();
			
			
			String Sub_heading = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[2]/div/div/h3")).getText();
			String Published_date = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[3]/div[1]/div/button")).getText();
			String Delivery_type_marker_research_id = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div["+i+"]/div/div[3]/div[2]/div")).getText();
			String newLine = System.getProperty("line.separator");
			System.out.println(Research_title+""+newLine+""+Sub_heading+""+newLine+""+Published_date+""+newLine+""+Delivery_type_marker_research_id);	
			System.out.println("====================");
			}
            
			catch(ElementNotVisibleException e){
				System.out.println("Default feed Research articles--"+i+"---"+"Fail");
			}
			catch(NoSuchElementException e){
				System.out.println("Default feed Research articles--"+i+"---"+"Fail");
			}
		}
		//Recommended research
			for(int i=1;i<=5;i++){
			try{
				String Recommended_Research = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[2]/div[2]/side-feed[1]/div[1]/div/div/div[1]/div[1]/h2")).getText();
				System.out.println(Recommended_Research);
				String Top_5_Recommended_research = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[2]/div[2]/side-feed[1]/div[1]/div/div/ul/li["+i+"]/div[1]/div/h3")).getText();
				System.out.println(Top_5_Recommended_research);
				
				}
            
			catch(ElementNotVisibleException e){
				System.out.println("Recommended Research--"+i+"---"+"Fail");
			}
			catch(NoSuchElementException e){
				System.out.println("Recommended Research--"+i+"---"+"Fail");
			}
			}
			//Trending Research
			for(int i=1;i<=5;i++){
				try{
					String Trending_Research = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[2]/div[2]/side-feed[2]/div[1]/div/div/div[1]/div[1]/h2")).getText();
					System.out.println(Trending_Research);
					String Top_5_Trending_research = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[2]/div[2]/side-feed[2]/div[1]/div/div/ul/li["+i+"]/div[1]/div/h3")).getText();
					System.out.println(Top_5_Trending_research);
					
					}
	            
				catch(ElementNotVisibleException e){
					System.out.println("Trending Research--"+i+"---"+"Fail");
				}
				catch(NoSuchElementException e){
					System.out.println("Trending Research--"+i+"---"+"Fail");
				}
			}
			//Recently Viewed
			System.out.println("Recently Viewed reserach articles");
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[1]/ul/li[2]/a")).click();
				for(int i=1;i<=10;i++){
					try{
					String Research_title = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div/research-feed/div[1]/div[2]/div["+i+"]/div/div[1]/div[1]/div/h2/span")).getText();
					String Sub_heading = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div/research-feed/div[1]/div[2]/div["+i+"]/div/div[2]/div/div/h3")).getText();
					String Published_date = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div/research-feed/div[1]/div[2]/div["+i+"]/div/div[3]/div[1]/div/button")).getText();
					String Delivery_type_marker_research_id = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div/research-feed/div[1]/div[2]/div["+i+"]/div/div[3]/div[2]/div")).getText();
					String newLine = System.getProperty("line.separator");
					System.out.println(Research_title+""+newLine+""+Sub_heading+""+newLine+""+Published_date+""+newLine+""+Delivery_type_marker_research_id);	
					System.out.println("====================");
					}
		           
					catch(ElementNotVisibleException e){
						System.out.println("Recently Viewed--"+i+"---"+"Fail");
						
					}
					catch(NoSuchElementException e){
						System.out.println("Recently Viewed--"+i+"---"+"Fail");
						
					}
					
				}
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div[1]/ul/li[1]/a")).click();
				
				
		  }
	}


