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

public class PKW_02 {

	public static void main(String[] args) throws InterruptedException, ElementNotVisibleException {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\PKW\\PKW_249_03_01_2018\\2nd_iteration_04012017\\PKW_249_Locked_content_Namrata.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		WebDriver driver=new ChromeDriver();
		/*System.setProperty("webdriver.chrome.driver", "D:\\driver\\New folder\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("http://mcaas-uat-icm-fns-portal-ui.mybluemix.net/#/login");
		driver.get("https://mcaas-dev-icm-fns-portal-ui.mybluemix.net/#/login");
		//driver.get("https://mcaas-local-icm-fns-portal-ui.mybluemix.net/#/login");
		//String sub_heading=null;
		String research_url=null;
		String sub_heading_next=null;
		String expanded_image_text=null;
		//String sub_heading_next=null;
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebDriverWait wait1=new WebDriverWait(driver,2);
		WebDriverWait wait2=new WebDriverWait(driver,3);
		WebDriverWait wait3=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("namrata.desai@happiestminds.com");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("password");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[6]/div[3]/button")));
		driver.findElement(By.xpath("html/body/div[6]/div[3]/button")).click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[3]")));
		driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[3]")).click();
		int j=3;
		int k=1;
		for(int i=2;i<=350;i++){
		try{
			System.out.println(i);
			String input = xl.getCellData("Sheet1", "Input query", i);
			String title = xl.getCellData("Sheet1", "Title", i);
			
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[3]/form/div/textarea")));
		driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[3]/form/div/textarea")).sendKeys(input);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[3]/form/div/button")).click();
		//long starttime=System.currentTimeMillis()/1000;
		try{
			//if(driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div/span")).isDisplayed()){
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
		try{
			//URL
		//Thread.sleep(10000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div/span[2]")));
		                                                                   // html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div[9]/div/div[1]/div/div/span[2]                                                                
		research_url = driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div/span[2]")).getText();
		System.out.println(research_url);
		}
		 /*catch(ElementNotFoundException e){
				
			}*/
			catch(ElementNotVisibleException e){
				
			}
			catch(NoSuchElementException e){
				
			}
			catch(WebDriverException e){
				
			}
			catch(NullPointerException e){
				
			}
		
					
			
		//sub heading_02
				try{
					wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/span/span/span/div[1]/h3")));
					                                                                    //html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/div/span/span/span/div[1]/h3
			       sub_heading_next = driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/span/span/span/div[1]/h3")).getText();
					System.out.println(sub_heading_next);
					xl.setCellData("Sheet1","Sub_heading_02",i,sub_heading_next);
					
						
		}
			        /*catch(ElementNotFoundException e){
						
					}*/
					catch(ElementNotVisibleException e){
						
					}
					catch(NoSuchElementException e){
						
					}
					catch(WebDriverException e){
						
					}
					catch(NullPointerException e){
						
					}
		
		//expand image option
		try{
		//wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/span/span/span/div[2]/div/div[2]/div/img")));
    	//WebElement expanded_image_button = driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/span/span/span/div[2]/div/div[2]/div/img"));
		if(driver.findElement(By.xpath("//img[@src='/core/images/Search_Icon.png']")).isDisplayed()){
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='expand_"+k+"']")));
	    WebElement expanded_image_button = driver.findElement(By.xpath("//div[@id='expand_"+k+"']"));	
    	expanded_image_button.click();
		}
		}
       /* catch(ElementNotFoundException e){
			
		}*/
		catch(ElementNotVisibleException e){
			
		}
		catch(NoSuchElementException e){
			
		}
		catch(WebDriverException e){
			
		}
		catch(NullPointerException e){
			
		}
		try{
		//expanded image response
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[2]/div/div/div[2]/div/span/span")));
		                                                                   // html/body/div[3]/div[4]/chatbot/div[2]/div/div/div[2]/div/span/span
		//wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[4]/chatbot/div[2]/div/div/div[2]")));
		// html/body/div[2]/div[4]/chatbot/div[2]/div/div/div[2]/div/span/span                           
		expanded_image_text = driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[2]/div/div/div[2]/div/span/span")).getText();
		//expanded_image_text = driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[2]/div/div/div[2]")).getText();
		
		System.out.println(expanded_image_text);
		driver.findElement(By.xpath(".//*[@id='htmlPopup']/div/div/div[1]/button")).click();
		
		xl.setCellData("Sheet1", "Expanded_image_response", i, expanded_image_text);
		xl.setCellData("Sheet1","Sub_heading_02",i,sub_heading_next);
		String expected = xl.getCellData("Sheet1","Expected_slide_heading",i);
		if(expected.contains(sub_heading_next)){
			xl.setCellData("Sheet1","Result_01",i,"Pass");	
			System.out.println("Pass_01");
				}
		else{
			xl.setCellData("Sheet1", "Result_01", i, "Fail");	
			System.out.println("Fail_01");
		}
		
		}
        /*catch(ElementNotFoundException e){
			
			
		}*/
		catch(ElementNotVisibleException e){
			
			
		}
		catch(NoSuchElementException e){
			
			
		}
		catch(WebDriverException e){
			
			
		}
		catch(NullPointerException e){
						
		}
		//sub heading _01
				try{
					wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div[2]/h3")));
					String sub_heading = driver.findElement(By.xpath("html/body/div[3]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/div[2]/h3")).getText();
					System.out.println(sub_heading);
					xl.setCellData("Sheet1", "Sub_heading_01", i, sub_heading);
					/*sub_heading_next = driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+j+"]/div/div[1]/div/span/span/span/div[1]/h3")).getText();
					System.out.println(sub_heading_next);*/
					xl.setCellData("Sheet1","Sub_heading_02",i,sub_heading_next);
					String expected = xl.getCellData("Sheet1","Expected_slide_heading",i);
					if(expected.contains(sub_heading_next)){
						xl.setCellData("Sheet1","Result_01",i,"Pass");	
						System.out.println("Pass_01");
							}
					else{
						xl.setCellData("Sheet1", "Result_01", i, "Fail");	
						System.out.println("Fail_01");
					}
				}
				/*catch(ElementNotFoundException e){
					
					
				}*/
				catch(ElementNotVisibleException e){
					
					
				}
				catch(NoSuchElementException e){
					
					
				}
				catch(WebDriverException e){
					
					
				}
				catch(NullPointerException e){
								
				}
				
		/*long endtime=System.currentTimeMillis()/1000;
		long loadtime=endtime-starttime;
		System.out.println(loadtime);
		String loading_time = Long.toString(loadtime);
		xl.setCellData("Sheet11", "Time", i, loading_time);
		Thread.sleep(5000);*/
		//System.out.println(output);
		xl.setCellData("Sheet1", "Reponse_Title", i, research_url);
		//int flag=0;
		if(research_url.contains(title)){
			xl.setCellData("Sheet1", "Result", i, "Pass");
			System.out.println("Pass");
		}
		else{
			xl.setCellData("Sheet1", "Result", i, "Fail");
			System.out.println("Fail");	
			/*xl.setCellData("Sheet1", "Result_01", i, "Fail");	
			System.out.println("Fail_01");*/
			/*flag=0;*/
			}
		
		
		
			
			
			
		//	}/*flag=1;
			//break;*/
			
		
		//String expected = xl.getCellData("Sheet1", "Expected_slide_heading", i);
		
		
		/*}
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
		}
       /* catch(ElementNotFoundException e){
			
		}*/
		catch(ElementNotVisibleException e){
			
		}
		catch(NoSuchElementException e){
			
		}
		catch(WebDriverException e){
			
		}
		catch(NullPointerException e){
			
		}
		
		}
		 /*catch(ElementNotFoundException e){
				driver.navigate().refresh();
				//Thread.sleep(20000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[4]/chatbot/div[3]")));
				driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[3]")).click();
				j=1;
				k-=1;
			}*/
			catch(ElementNotVisibleException e){
				/*driver.navigate().refresh();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[4]/chatbot/div[3]")));
				driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[3]")).click();
				j=1;
				k-=1;*/
				
			}
			catch(NoSuchElementException e){
				/*driver.navigate().refresh();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[4]/chatbot/div[3]")));
				driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[3]")).click();
				j=1;
				k-=1;*/
			}
			catch(WebDriverException e){
				/*driver.navigate().refresh();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[4]/chatbot/div[3]")));
				driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[3]")).click();
				j=1;
				k-=1;*/
				
			}
			catch(NullPointerException e){
				/*driver.navigate().refresh();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[4]/chatbot/div[3]")));
				driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[3]")).click();
				j=1;
				k-=1;*/
				
			}
		j+=2;
		k+=2;
		continue;
		}
		
		}


}
