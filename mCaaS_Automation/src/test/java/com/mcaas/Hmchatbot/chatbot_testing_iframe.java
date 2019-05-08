package com.mcaas.Hmchatbot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.mcaas.genericlibraries.Xls_Reader;

public class chatbot_testing_iframe {
	public static void main(String[] args) throws InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		WebDriver driver=new ChromeDriver(dc);
		/*System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\Sudhakar_mCaaS\\DQA\\Drivers\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\HM_Chatbot\\15-06-2017\\Testdata_chatbot.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		driver.get("file:///D:/Sudhakar_Data/Backup/E/HM_Chatbot/Chatbot_testing_25052017/happiestminds.html");
		Thread.sleep(10000);
		WebElement frame = driver.findElement(By.cssSelector("iframe[src='http://mcaas-dqa-pilot-happiestminds-chatbot-ui.mybluemix.net/#/chat/happiest minds/2']"));
		driver.switchTo().frame(frame);
		int j=2;
		for(int i=8;i<=rowCount;i++){
			String input_query = xl.getCellData("Sheet1", "Input question", i);
			String Expected = xl.getCellData("Sheet1", "Expected Response", i);
			try{
				Alert alert2 = driver.switchTo().alert();
				alert2.accept();
			}
			catch(NoAlertPresentException e){
			}
			driver.findElement(By.xpath(".//*[@id='chat-app']/div[2]/div/div/div/form/div/textarea")).sendKeys(input_query);
			Thread.sleep(5000);
			try{
				Alert alert3 = driver.switchTo().alert();
				alert3.accept();
			}
			catch(NoAlertPresentException e){
			}
			driver.findElement(By.xpath(".//*[@id='chat-app']/div[2]/div/div/div/form/div/button")).click();
			//driver.switchTo().defaultContent();
			try{
				Alert alert4 = driver.switchTo().alert();
				alert4.accept();
			}
			catch(NoAlertPresentException e){
			}
			//Thread.sleep(5000);
			//driver.switchTo().frame(frame);
			String output_01 = driver.findElement(By.xpath("html/body/div[1]/div/md-content/div/div[2]/div/div/md-content/div[1]/div["+j+"]/div/div[1]/span")).getText();
			Thread.sleep(5000);
			
			try{
			Alert alert1 = driver.switchTo().alert();
			alert1.accept();
			}
			catch(NoAlertPresentException e){
			System.out.println(i+"   "+output_01);				}
			xl.setCellData("Sheet1", "Actual Response", i, output_01);
			if(output_01.contains(Expected)){
				xl.setCellData("Sheet1", "Result", i, "Pass");
			}
			else
				xl.setCellData("Sheet1", "Result", i, "Fail");
			//System.out.println(i+"  "+output_01);
			j+=2;
		}
	}
}
