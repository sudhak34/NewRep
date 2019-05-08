package com.newfns.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mcaas.genericlibraries.Xls_Reader;

public class PKW_01 {
	public static void main(String[] args) throws InterruptedException, ElementNotVisibleException {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\PKW\\PKW_249_03_01_2018\\2nd_iteration_04012017\\PKW_249_Locked_content_sudhakar.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://memberuat.frost.com");
		/*String sub_heading=null;
		String research_url=null;
		String sub_heading_next=null;*/
		String expanded_image_text=null;
		WebDriverWait wait=new WebDriverWait(driver,15);
		WebDriverWait wait1=new WebDriverWait(driver,3);
		WebDriverWait wait2=new WebDriverWait(driver,3);
		WebDriverWait wait3=new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("namrata.desai@happiestminds.com");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("Password@123");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		Thread.sleep(15000);
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[6]/div[3]/button")));
		driver.findElement(By.xpath("html/body/div[6]/div[3]/button")).click();
		Thread.sleep(5000);*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[3]")));
		driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[3]")).click();
		int j=3;
		int k=1;
		for(int i=2;i<=205;i++){
			System.out.println(i);
			String input = xl.getCellData("Sheet1", "Input query", i);
			String title = xl.getCellData("Sheet1", "Title", i);
			String expected = xl.getCellData("Sheet1", "Expected_slide_heading", i);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[3]/form/div/textarea")));
			driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[3]/form/div/textarea")).sendKeys(input);
			Thread.sleep(5000);
			driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[3]/form/div/button")).click();
			//sorry don't have knowledge
			try{
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div/span")));
				WebElement No_KW = driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div/span"));
				String slide = No_KW.getText();
				System.out.println(slide);
				xl.setCellData("Sheet1", "Response", i, slide);
			   }
           
			catch(ElementNotVisibleException e){
				
			}
			catch(NoSuchElementException e){
				
			}
			catch(WebDriverException e){
				
			}
			catch(NullPointerException e){
				
			}
			//url
			try{
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div[1]/span[2]")));
				String Research_url = driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div[1]/span[2]")).getText();
				System.out.println(Research_url);
				xl.setCellData("Sheet1","Response_Title",i,Research_url);
				 if(Research_url.contains(title)){
					xl.setCellData("Sheet1", "Result", i, "Pass");
					System.out.println("Pass");
					}
				 else{
					xl.setCellData("Sheet1", "Result", i, "Fail");
					System.out.println("Fail");	
					}
				  }
            
			catch(ElementNotVisibleException e){
				
			}
			catch(NoSuchElementException e){
				
			}
			catch(WebDriverException e){
				
			}
			catch(NullPointerException e){
				
			}
			try{
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div[2]/h3")));
				String sub_heading1 = driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div[2]/h3")).getText();
				System.out.println(sub_heading1);
				xl.setCellData("Sheet1","Sub_heading_01",i,sub_heading1);
				 if(sub_heading1.contains(expected)){
					xl.setCellData("Sheet1", "Result_01", i, "Pass");
					System.out.println("Pass_01");
					}
				 else{
					xl.setCellData("Sheet1", "Result_01", i, "Fail");
					System.out.println("Fail_01");	
					}
				  }
            
			catch(ElementNotVisibleException e){
				
			}
			catch(NoSuchElementException e){
				
			}
			catch(WebDriverException e){
				
			}
			catch(NullPointerException e){
				
			}
			//sub heading 02
			try{
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/span/span/span/div[1]/h3")));
				String sub_heading2 = driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/span/span/span/div[1]/h3")).getText();
				System.out.println(sub_heading2);
				xl.setCellData("Sheet1","Sub_heading_02",i,sub_heading2);
				 if(sub_heading2.contains(expected)){
					xl.setCellData("Sheet1", "Result_02", i, "Pass");
					System.out.println("Pass_02");
					}
				 else{
					xl.setCellData("Sheet1", "Result_02", i, "Fail");
					System.out.println("Fail_02");	
					}
				  }
            
			catch(ElementNotVisibleException e){
				
			}
			catch(NoSuchElementException e){
				
			}
			catch(WebDriverException e){
				
			}
			catch(NullPointerException e){
				
			}
			try{
				if(driver.findElement(By.xpath("//img[@src='/core/images/Search_Icon.png']")).isDisplayed()){
				wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='expand_"+k+"']")));
			    WebElement expanded_image_button = driver.findElement(By.xpath("//div[@id='expand_"+k+"']"));	
		    	expanded_image_button.click();
		    	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[2]/div/div/div[2]/div/span/span")));
               expanded_image_text = driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[2]/div/div/div[2]/div/span/span")).getText();
               System.out.println(expanded_image_text);
               driver.findElement(By.xpath(".//*[@id='htmlPopup']/div/div/div[1]/button")).click();
               xl.setCellData("Sheet1", "Expanded_image_response", i, expanded_image_text);
				}
				}
		        
				catch(ElementNotVisibleException e){
					
				}
				catch(NoSuchElementException e){
					
				}
				catch(WebDriverException e){
					
				}
				catch(NullPointerException e){
					
				}
			
			j+=2;
			k+=2;
			continue;
		}
		
	}
}
