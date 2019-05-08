package com.ke.test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mcaas.genericlibraries.Xls_Reader;

public class KE_latest_updated_code_01 {

	public static void main(String[] args) throws InterruptedException, ElementNotVisibleException {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\KE_300_reports\\Updated\\Test_data_Toc.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mcaas-uat-icm-fns-portal-ui-v2.mybluemix.net/login");
		//driver.get("https://mcaas-dev-icm-fns-portal-ui.mybluemix.net/login");
		/*String sub_heading=null;
		String research_url=null;
		String sub_heading_next=null;*/
		String expanded_image_text=null;
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebDriverWait wait1=new WebDriverWait(driver,10);
		WebDriverWait wait2=new WebDriverWait(driver,4);
		WebDriverWait wait3=new WebDriverWait(driver,4);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[5]/chatbot/div[3]")));
		driver.findElement(By.xpath("html/body/div[3]/div[5]/chatbot/div[3]")).click();
		int j=3;
		int k=1;
		for(int i=309;i<=rowCount;i++){
			System.out.println(i);
			String input = xl.getCellData("Sheet1", "Input_query", i);
			String title_01 = xl.getCellData("Sheet1", "Expected_Research_UI_title", i);
			String title = title_01.replaceAll("—","");
			String expected = xl.getCellData("Sheet1", "Expected_slide_heading", i);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[3]/form/div/textarea")));
			driver.findElement(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[3]/form/div/textarea")).sendKeys(input);
			Thread.sleep(5000);
			driver.findElement(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[3]/form/div/button")).click();
			//Research tile
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div/span[2]/span")));
				if(driver.findElement(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div/span[2]/span")).isDisplayed()){
				String Research_url = driver.findElement(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div/span[2]/span")).getText();
				System.out.println(Research_url);
				xl.setCellData("Sheet1","Actual_title",i,Research_url);
				 if(Research_url.replaceAll("\\s{2,}","").replaceAll(" ","").contains(title.replaceAll("\\s{2,}","").replaceAll(" ",""))){
					xl.setCellData("Sheet1", "Title_Match", i, "Pass");
					System.out.println("Title Pass");
					}
				 else{
					xl.setCellData("Sheet1", "Title_Match", i, "Fail");
					System.out.println("Title Fail");	
					}
				 wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/span[1]/span/span/div[1]/h3")));
					String sub_heading2 = driver.findElement(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/span[1]/span/span/div[1]/h3")).getText();
					System.out.println(sub_heading2);
					xl.setCellData("Sheet1","Actual_KE_Response_slide_heading",i,sub_heading2);
					 if(sub_heading2.replaceAll("\\s{2,}","").replaceAll(" ","").contains(expected.replaceAll("\\s{2,}","").replaceAll(" ",""))){
						xl.setCellData("Sheet1","Result_02", i, "Pass");
						System.out.println("Pass_02");
						}
					 else{
						xl.setCellData("Sheet1","Result_02", i, "Fail");
						System.out.println("Fail_02");	
						}
				}
				else if(driver.findElement(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div[1]/span[2]/span")).isDisplayed()){
					String Research_url = driver.findElement(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div[1]/span[2]/span")).getText();
					System.out.println(Research_url);
					xl.setCellData("Sheet1","Actual_title",i,Research_url);
					 if(Research_url.replaceAll("\\s{2,}","").replaceAll(" ","").contains(title.replaceAll("\\s{2,}","").replaceAll(" ",""))){
						xl.setCellData("Sheet1", "Title_Match", i, "Pass");
						System.out.println("Title Pass");
						}
					 else{
						xl.setCellData("Sheet1", "Title_Match", i, "Fail");
						System.out.println("Title Fail");	
						}
					 wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div[2]/h3")));
					 String sub_heading1 = driver.findElement(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div[2]/h3")).getText();
						System.out.println(sub_heading1);
						xl.setCellData("Sheet1","Sub_Head_Research_Summary",i,sub_heading1);
						 if(sub_heading1.contains("Research Summary")){
							xl.setCellData("Sheet1", "Result_01", i, "Pass");
							xl.setCellData("Sheet1","Result_02", i, "Pass");
							System.out.println("Pass_01");
							}
						 else{
							xl.setCellData("Sheet1", "Result_01", i, "Fail");
							System.out.println("Fail_01");	
							}				
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
			//I was unable to find an exact match
			try{
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div")));
				WebElement No_KW = driver.findElement(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div"));
				String slide = No_KW.getText();
					if(slide.contains("I was unable to find an exact match")){
					xl.setCellData("Sheet1", "Result_02", i, "Fail");
					xl.setCellData("Sheet1", "Title_Match", i, "Fail");
					System.out.println(slide);
					xl.setCellData("Sheet1", "Response", i, slide);
				}
					else if (slide.contains("Sorry, I dont have that knowledge now, however will be with my next version")){
						xl.setCellData("Sheet1", "Result_02", i, "Fail");
						xl.setCellData("Sheet1", "Title_Match", i, "Fail");
						System.out.println(slide);
						xl.setCellData("Sheet1", "Response", i, slide);
						
					}
					else{
						
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
			//Research summary title
			try{
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div[2]/h3")));
				String sub_heading1 = driver.findElement(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div[2]/h3")).getText();
				System.out.println(sub_heading1);
				xl.setCellData("Sheet1","Sub_Head_Research_Summary",i,sub_heading1);
				 if(sub_heading1.contains("Research Summary")){
					xl.setCellData("Sheet1", "Result_01", i, "Pass");
					xl.setCellData("Sheet1","Result_02", i, "Pass");
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
			/*try{
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/span[1]/span/span/div[1]/h3")));
				String sub_heading2 = driver.findElement(By.xpath("html/body/div[3]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/span[1]/span/span/div[1]/h3")).getText();
				System.out.println(sub_heading2);
				xl.setCellData("Sheet1","Actual_KE_Response_slide_heading",i,sub_heading2);
				 if(sub_heading2.replaceAll("\\s{2,}","").replaceAll(" ","").contains(expected.replaceAll("\\s{2,}","").replaceAll(" ",""))){
					xl.setCellData("Sheet1","Result_02", i, "Pass");
					System.out.println("Pass_02");
					}
				 else{
					xl.setCellData("Sheet1","Result_02", i, "Fail");
					System.out.println("Fail_02");	
					}
				  }
            catch(ElementNotFoundException e){
				
			}
			catch(ElementNotVisibleException e){
				
			}
			catch(NoSuchElementException e){
				
			}
			catch(WebDriverException e){
				
			}
			catch(NullPointerException e){
				
			}*/
			//Complete response 
			/*try{
				if(driver.findElement(By.xpath("//div[@id='expand_"+k+"']")).isDisplayed()){
				WebElement expanded_image_button = driver.findElement(By.xpath("//div[@id='expand_"+k+"']"));	
		    	expanded_image_button.click();
		    	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[2]/div/div/div[2]/div/span/span")));
               expanded_image_text = driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[2]/div/div/div[2]/div/span/span")).getText();
               System.out.println(expanded_image_text);
               driver.findElement(By.xpath(".//*[@id='htmlPopup']/div/div/div[1]/button")).click();
               xl.setCellData("Sheet1", "Expanded_image_response", i, expanded_image_text);
               if(expanded_image_text.contains(input)){
					xl.setCellData("Sheet1","Result_03", i, "Pass");
					System.out.println("Pass_03");
					}
				 else{
					xl.setCellData("Sheet1","Result_03", i, "Fail");
					System.out.println("Fail_02");	
					}
				}
				}
		        catch(ElementNotFoundException e){
					
				}
				catch(ElementNotVisibleException e){
					
				}
				catch(NoSuchElementException e){
					
				}
				catch(WebDriverException e){
					
				}
				catch(NullPointerException e){
					
				}*/
			
			j+=2;
			k+=2;
			continue;
		}
		
	}
}

