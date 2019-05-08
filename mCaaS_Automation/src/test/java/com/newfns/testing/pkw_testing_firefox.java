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

public class pkw_testing_firefox {

	public static void main(String[] args) throws InterruptedException {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\PKW\\PKW_01_1to192.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		/*System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();*/
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://mcaas-uat-icm-fns-portal-ui.mybluemix.net/#/login");
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid")));
		driver.findElement(By.id("emailid")).sendKeys("sudhakar.koduri@happiestminds.com");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("password");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		Thread.sleep(30000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[4]/chatbot/div[3]")));
		driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[3]")).click();
		int j=3;
		int k=1;
		for(int i=1;i<=195;i++){
			System.out.println(i);
			String input = xl.getCellData("Sheet12", "Input query", i);
			String title = xl.getCellData("Sheet12", "Title", i);
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='chat-window-inner']/div[3]/form/div[1]/textarea")));
		driver.findElement(By.xpath(".//*[@id='chat-window-inner']/div[3]/form/div[1]/textarea")).sendKeys(input);
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[1]/div/div/div[3]/form/div[1]/button")).click();
		long starttime=System.currentTimeMillis()/1000;
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div[1]/div["+j+"]/div/div[1]/div[1]/div[1]/div[1]/span[2]")));
		                                                                   
		WebElement research_url = driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div[1]/div["+j+"]/div/div[1]/div[1]/div[1]/div[1]/span[2]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='chat-content']/div[1]/div["+j+"]/div/div[1]/div[1]/div[1]/div[2]/span")));
		WebElement heading = driver.findElement(By.xpath(".//*[@id='chat-content']/div[1]/div["+j+"]/div/div[1]/div[1]/div[1]/div[2]/span"));
		
		/*long endtime=System.currentTimeMillis()/1000;
		long loadtime=endtime-starttime;
		System.out.println(loadtime);
		String loading_time = Long.toString(loadtime);
		xl.setCellData("Sheet11", "Time", i, loading_time);
		Thread.sleep(5000);*/
		String url = research_url.getText();
		String slide = heading.getText();
		
		//System.out.println(output);
		xl.setCellData("Sheet12", "Research", i, url);
		xl.setCellData("Sheet12", "Heading", i, slide);
		
		if(url.replaceAll("–","").replaceAll(",","").replaceAll("\\s+","").equals(title.replaceAll("–","").replaceAll(",","").replaceAll("\\s+",""))){
			xl.setCellData("Sheet12", "Latest_result", i, "Pass");
		}
		else{
			xl.setCellData("Sheet12", "Latest_result", i, "Fail");
		}
		//System.out.println(research_url);
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='test_"+k+"]/div/div/div[1]/div")));
		String expanded_output = driver.findElement(By.xpath(".//*[@id='test_"+k+"]/div/div/div[1]/div")).getText();
		xl.setCellData("Sheet11", "output_02", i, expanded_output);
		System.out.println(expanded_output);*/
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='chat-content']/div[1]/div["+j+"]/div/div[1]/div[2]/div/img")));
		driver.findElement(By.xpath(".//*[@id='chat-content']/div[1]/div["+j+"]/div/div[1]/div[2]/div/img")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='test_"+k+"']/span/div/div/div[1]/div")));
		String expanded_output = driver.findElement(By.xpath(".//*[@id='test_"+k+"']/span/div/div/div[1]/div")).getText();
		xl.setCellData("Sheet11", "output_02", i, expanded_output);
		driver.findElement(By.xpath(".//*[@id='htmlPopup']/div/div/div[1]/button")).click();*/
		
		//Thread.sleep(5000);
		String output_reponse = driver.findElement(By.xpath("html/body/div[2]/div[4]/chatbot/div[1]/div/div/div[2]/div/div[1]/div[1]/div["+j+"]/div/div[1]/div[1]")).getText();
		System.out.println(output_reponse);
		xl.setCellData("Sheet12", "Response", i, output_reponse);
		}
        
		catch(ElementNotVisibleException e){
			
		}
		catch(NoSuchElementException e){
			
		}
		catch(WebDriverException e){
			
		}
		catch(NullPointerException e){
			
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
		//k+=2;
		continue;
		}
		
		}


}
