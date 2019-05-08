package com.GTM.Sanitycheck;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.mcaas.genericlibraries.Xls_Reader;

public class GTM_sanity_testing {
	@Test(priority=1)
	public static void Discover_testing() throws InterruptedException{
		//WebDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\Sudhakar_mCaaS\\DQA\\Drivers\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://demo-mcaas-chatbot-creditcard.mybluemix.net/#/discover");
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\GTM_Demo\\GTM_sanity_testing\\GTM_Sanity_Testing.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		for(int i=2;i<=rowCount;i++){
			WebDriverWait wait1 = new WebDriverWait(driver,240);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div/div[2]/div/ul/li[3]/a")));
			driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/ul/li[3]/a")).click();
		    driver.findElement(By.xpath(".//*[@id='virtualChatbotId']")).click();
		    String Welcome_Message = driver.findElement(By.xpath(".//*[@id='msgContainer']/span/div/div/div/p")).getText();
		    //System.out.println("Welcome Message:"  +  driver.findElement(By.xpath(".//*[@id='msgContainer']/span/div/div/div/p")).getText());
		    xl.setCellData("Discovery", "Actual", 2, Welcome_Message);
		    String expected = xl.getCellData("Discover_input", "expected", 2);
		    if(Welcome_Message.equals(expected)){
		    	xl.setCellData("Sheet1", "Discover", 2,"Pass");
		    }
		    else{
		    	xl.setCellData("Sheet1", "Discover", 2,"Fail");
		    }
		    driver.findElement(By.xpath(".//*[@id='chat-window']/div/div/div[2]/div/div[2]/input[1]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chat-window']/div/div/div[2]/div/div[3]/form/div[7]/input[1]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chat-window']/div/div/div[2]/div/div[3]/form/div[9]/input[1]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chat-window']/div/div/div[2]/div/div[3]/form/div[8]/input[1]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chat-window']/div/div/div[2]/div/div[3]/form/div[8]/input[1]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chat-window']/div/div/div[2]/div/div[3]/form/div[1]/div/textarea")).sendKeys("Software Engineer");
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chatTextSubmit']")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("html/body/div[1]/div/div/div[4]/div[4]/div/div/div/div[2]/div/div[3]/form/div[1]/span/input")).click();
		    Thread.sleep(5000);
		    WebElement profession = driver.findElement(By.xpath("html/body/div[1]/div/div/div[4]/div[4]/div/div/div/div[2]/div/div[3]/form/div[5]/select"));
		    Select slc=new Select(profession);
		    Thread.sleep(5000);
		    slc.selectByVisibleText("Software Engineer");
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("html/body/div[1]/div/div/div[4]/div[4]/div/div/div/div[2]/div/div[3]/form/div[5]/input")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chat-window']/div/div/div[2]/div/div[3]/form/div[5]/input")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chat-window']/div/div/div[2]/div/div[3]/form/div[1]/div/textarea")).sendKeys("600000");
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chatTextSubmit']")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chat-window']/div/div/div[2]/div/div[3]/form/div[1]/div/textarea")).sendKeys("123456789");
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chatTextSubmit']")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chat-window']/div/div/div[2]/div/div[3]/form/div[1]/div/textarea")).sendKeys("0990099000");
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chatTextSubmit']")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chat-window']/div/div/div[2]/div/div[3]/form/div[2]/input")).sendKeys("10101990");
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chatTextSubmit']")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='chat-window']/div/div/div[2]/div/div[3]/form/div[4]/input")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='useraaplicationform']/div[2]/div[2]/div[7]/button")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/div[2]/div[2]/div[2]/p[3]/input")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/div[2]/div[3]/div[2]/button")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='tcloginModal']/div/div/div/div/div/div[3]/div/form/div/div[1]/a/img")).click();
		    Thread.sleep(5000);
		    System.out.println(driver.getTitle());
		    String parentwindow1 = driver.getWindowHandle();
			   String childwindow1 = null;
			   Set<String> windows1 = driver.getWindowHandles();
			   for(String x :windows1)
					{
						if(!x.equals(parentwindow1))
						{
							childwindow1 = x;
						}
					}
					driver.switchTo().window(childwindow1);
					Thread.sleep(5000);
					System.out.println(driver.getTitle());
					driver.findElement(By.xpath(".//*[@id='email']")).clear();
					driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("sandralaville029@gmail.com");
					 Thread.sleep(5000);
					driver.findElement(By.xpath(".//*[@id='pass']")).clear();
					driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("@Sandra123");
					driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/form/div/div[3]/label[2]/input")).click();
					Thread.sleep(5000);
					driver.switchTo().window(parentwindow1);
					System.out.println(driver.findElement(By.xpath("html/body/div[1]/div/div/div[9]/div/div/div[2]/div/div/div[2]/h4")).getText());
					
					driver.findElement(By.xpath("html/body/div[1]/div/div/div[9]/div/div/div[1]/button")).click();
					System.out.println(driver.findElement(By.xpath("html/body/div[1]/div/div/div[4]/div[4]/div/div/div/div[2]/div/div[1]/span[13]/div/div/div/p")).getText());
					String Response_filenumber = driver.findElement(By.xpath("html/body/div[1]/div/div/div[4]/div[4]/div/div/div/div[2]/div/div[1]/span[13]/div/div/div/p")).getText();
					xl.setCellData("Sheet1", "test", 15, Response_filenumber);
					//String result = Response_filenumber.substring(0, Response_filenumber.indexOf("number : "));
					//System.out.println(result);
					String response = Response_filenumber.replace("You can also check the status on our FB page. Or call us as at 1800-MY-CARD.","");
					String number = response.replace("If you want to know the status of your application, you can always chat with me here or call us with reference number : ", "");
					System.out.println(number);
					xl.setCellData("Sheet1", "test", 16, number);
					Thread.sleep(10000);
					driver.findElement(By.xpath("html/body/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
					driver.findElement(By.xpath("html/body/div[1]/div/div/div[13]/div/div/div/div/div/div[3]/div/form/div/div[1]/a/img")).click();
					System.out.println(driver.getTitle());
				    String parentwindow2 = driver.getWindowHandle();
					   String childwindow2 = null;
					   Set<String> windows2 = driver.getWindowHandles();
					   for(String x :windows2)
							{
								if(!x.equals(parentwindow2))
								{
									childwindow2 = x;
								}
							}
							driver.switchTo().window(childwindow2);
							Thread.sleep(5000);
							System.out.println(driver.getTitle());
							//driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/form/div/div[1]/div/input")).sendKeys("sandralaville029@gmail.com");
							driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[1]/table/tbody/tr[1]/td/input")).sendKeys("@Sandra123");
							                             
							driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[3]/label/input")).click();
							Thread.sleep(5000);
							driver.switchTo().window(parentwindow2);
							driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/ul/li[3]/a")).click();
						    Thread.sleep(5000);
						    //driver.findElement(By.xpath("html/body/div[1]/div/div/div[4]/div[4]/div/div/div/div[1]/div[2]/span")).click();
						    driver.findElement(By.xpath("html/body/div[1]/div/div/div[4]/div[4]/div/div/div/div[2]/div/div[3]/form/div[1]/div/textarea")).sendKeys(number);
					        driver.findElement(By.xpath("html/body/div[1]/div/div/div[4]/div[4]/div/div/div/div[2]/div/div[3]/form/div[1]/span/input")).click();
					        Thread.sleep(15000);
					        String status = driver.findElement(By.xpath("html/body/div[1]/div/div/div[4]/div[4]/div/div/div/div[2]/div/div[1]/span[15]/div/div/div/p")).getText();
					        System.out.println(status);
					        xl.setCellData("Sheet1", "test", 17, status);  
						    
					/*driver.get("https://www.gmail.com");
					driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div[1]/div/div/input[1]")).sendKeys("sandralaville029@gmail.com");
					driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/input")).click();
					driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/form/div[2]/div/div[2]/div/div/input[2]")).sendKeys("@Sandra123");
					driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/form/div[2]/div/input[1]")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[3]/div/div/div/form/fieldset[2]/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/div/input[2]")).sendKeys("demo.discover");
					driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[3]/div/div/div/form/div/button")).click();
					System.out.println(driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div[5]/div[1]/div/table/tbody/tr[1]/td[8]/span")).getText());
					driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
					driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[3]/div[2]/a")).click();
					driver.get("http://demo-mcaas-chatbot-creditcard.mybluemix.net/#/discover");
					*/
		 driver.close();
				
			}
		    
			}


	}