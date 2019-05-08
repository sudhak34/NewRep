package others.fns.cases;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mcaas.genericlibraries.Xls_Reader;

public class KE {
	/*protected static File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}*/
	
	protected static File getLastModifiedFile(String directory) {
		File dir = new File(directory);
	    File max = null;
	    for (File file : dir.listFiles()) {
	        if (file.isDirectory() && (max == null || max.lastModified() < file.lastModified())) {
	            max = file;
	        }
	    }
		return max;
	}
	
	public static void main(String[] args) throws InterruptedException {
		/*Xls_Reader xl=new Xls_Reader("D:\\Test_Data\\Test_data.xlsx");
		String Rownum = xl.getCellData("Sheet1", "Rownumtopick", 2).replace(".0","");
		Integer Row = Integer.valueOf(Rownum);*/
		System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Latest_2000_KE\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		//WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://member.frost.com/login");
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='emailid']")));
		driver.findElement(By.xpath(".//*[@id='emailid']")).sendKeys("sudhakar.koduri@happiestminds.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("Password123#");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pkw-portal']")));
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='pkw-portal']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='portal-chatbot-panel']/div[3]/form/div/textarea")));
		Thread.sleep(2000);
		//for(int i=Row;i<=Row+1;i++){
			
		//	String keyword = xl.getCellData("Sheet1", "Keyword", i);
		driver.findElement(By.xpath(".//*[@id='portal-chatbot-panel']/div[3]/form/div/textarea")).sendKeys("Health");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='portal-chatbot-panel']/div[3]/form/div/button")).click();
		//Thread.sleep(2000);
		long start_time = System.currentTimeMillis();
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader-anim bot")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[contains(@class,'loader-anim bot')]/i/span[text() ='Searching...']")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//span[text()='Searching...']")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//span[.='Searching...']")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//span[contains(text(),'Searching...')]")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-anim bot']/span[text()='Searching...']")));
		//working wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[contains(@class,'loader-anim bot')]/span[text()='Searching...']")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[@class='loader-anim bot']/span[text()='Searching...']")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='loader-anim bot']")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Searching...")));
		
		//working
		/*boolean contains = driver.getPageSource().contains("Searching...");
		do{
			contains = driver.getPageSource().contains("Searching...");
		}while(contains==true);*/
			for(int i=1;i<=60;i++){
				Thread.sleep(1000);
				//System.out.println(i);
			boolean contains = driver.getPageSource().contains("Searching...");
			if(contains==false){
				break;
			}
		}
			long end_time = System.currentTimeMillis();
			long totalTime1 = end_time-start_time ;
			String Resp_Time = String.valueOf(totalTime1);
			String s1=String.valueOf(totalTime1/1000);
			System.out.println((totalTime1/1000)+"  seconds is the time taken for the KE to response");
			File getLatestFile = getLastModifiedFile("‪C:\\Users\\sudhakar.koduri\\Downloads");
			//Thread.sleep(30000);
			String fileName = getLatestFile.getName();
			System.out.println(fileName);
		
		//driver.findElement(By.xpath("//span[@class='alfresco-renderers-PropertyLink alfresco-renderers-Property pointer small']//span[@class='value']")).getText();
		/*long end_time = System.currentTimeMillis();
		long totalTime1 = end_time-start_time ;
		String Resp_Time = String.valueOf(totalTime1);
		String s1=String.valueOf(totalTime1/1000);
		System.out.println((totalTime1/1000)+"  seconds is the time taken for the KE to response");*/
		//xl.setCellData("Sheet1", "Response_Time", i, Resp_Time);
		//String valueOf = String.valueOf(i+1);
		//xl.setCellData("Sheet1", "Rownumtopick", 2, valueOf);
		/*int k=3;
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[6]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+k+"]/div/div[1]/div/div[1]/span[2]/span")));
		Thread.sleep(4000);
		String title = driver.findElement(By.xpath("html/body/div[6]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div["+k+"]/div/div[1]/div/div[1]/span[2]/span")).getText();
		System.out.println(title);
		k+=2;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			k+=2;
		}*/
		
		//}
		//Thread.sleep(5000);
		//driver.close();
}


	
}
