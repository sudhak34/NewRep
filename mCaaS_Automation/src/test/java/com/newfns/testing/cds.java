package com.newfns.testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.mcaas.genericlibraries.Xls_Reader;

public class cds {

	public static void main(String[] args) throws InterruptedException {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Aug_search\\CDS_Test_data.xlsx");
		int rowCount_01 = xl.getRowCount("Sheet1");
		int rowCount_02 = xl.getRowCount("Sheet2");
		System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Latest_2000_KE\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		//WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://cds.frost.com/");
		String cds_title =null;
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebDriverWait wait1=new WebDriverWait(driver,10);	// TODO Auto-generated method stub
driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[2]/div[1]/div/form/div[1]/input")).sendKeys("trialuser@HappiestMinds.com");
driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[2]/div[1]/div/form/div[2]/input")).sendKeys("Ha102016");
driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[2]/div[1]/div/form/div[3]/button")).click();
Thread.sleep(20000);
driver.findElement(By.xpath("html/body/nav[2]/div/ul/li[2]/a/span/i")).click();
Thread.sleep(10000);
driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/div/div[1]/cd-year-select/div/button")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/div/div[1]/cd-year-select/cq-popover-panel/div/div[2]/div/form/div[1]/input")).clear();
driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/div/div[1]/cd-year-select/cq-popover-panel/div/div[2]/div/form/div[1]/input")).sendKeys("2014");
driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/div/div[1]/cd-year-select/cq-popover-panel/div/div[2]/div/form/div[2]/button[1]")).click();
Thread.sleep(20000);
int j=275;
for(int k=37;k<=rowCount_01;k++){
	//System.out.println(k);
	String search = xl.getCellData("Sheet1", "Search_Term", k);
	System.out.println(search);
	xl.setCellData("Sheet2", "Input", j, search);
	try{
	driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/div/cd-search-input/div/input")).clear();
    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/div/cd-search-input/div/input")).sendKeys(search);
    Thread.sleep(4000);
    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/div/cd-search-input/div/span/button")).click();
     Thread.sleep(10000);
    String results_count = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[3]/span/span")).getText();
    xl.setCellData("Sheet2", "Total_results_count", j, results_count);
	}
	
	catch(ElementNotVisibleException e){
		
	}
	catch(NoSuchElementException e){
		
	}
	catch(WebDriverException e){
		
	}
	catch(NullPointerException e){
		
	}
	catch(Exception e){
		
	}
	Thread.sleep(2000);
	//List<WebElement> element = driver.findElements(By.xpath("/h5/span"));
	// for(WebElement x:element){
    for(int i=1;i<=8;i++){
    	//try{
    	//System.out.println(i);
    	//Thread.sleep(2000);
    	//String cds_title = driver.findElement(By.xpath("//cd-deliverable["+i+"]/div/article/div[2]/div/h5/span")).getText();
    	try{ 
    	cds_title = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/cd-deliverable["+i+"]/div/article/div[2]/div/h5/span")).getText();
    	   		
    		if(driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/cd-deliverable["+i+"]/div/article/div[2]/div/cd-deliverable-strapline/ul/li[3]")).isDisplayed()){
    	    	String cds_pub_date_01 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/cd-deliverable["+i+"]/div/article/div[2]/div/cd-deliverable-strapline/ul/li[3]")).getText();
    	    	System.out.println(cds_title+"---"+cds_pub_date_01);
    	    	xl.setCellData("Sheet2","Top_8_results",j,cds_title);
    			xl.setCellData("Sheet2","Published_date",j,cds_pub_date_01);
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
		catch(Exception e){
			
		}
    	try{
    		
    		if(driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/cd-deliverable["+i+"]/div/article/div[2]/div/cd-deliverable-strapline/ul/li[4]")).isDisplayed()){
    	    	String cds_pub_date = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/cd-deliverable["+i+"]/div/article/div[2]/div/cd-deliverable-strapline/ul/li[4]")).getText();
    	    	System.out.println(cds_title+"---"+cds_pub_date);
    	    	xl.setCellData("Sheet2","Top_8_results",j,cds_title);
    			xl.setCellData("Sheet2","Published_date",j,cds_pub_date);
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
		catch(Exception e){
			
		}
    	//String cds_title = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/cd-deliverable["+i+"]/div/article/div[2]/div/h5/span")).getText();
    	
		j+=1;
    	}
/*catch(ElementNotFoundException e){
			
		}
		catch(ElementNotVisibleException e){
			
		}
		catch(NoSuchElementException e){
			
		}
		catch(WebDriverException e){
			
		}
		catch(NullPointerException e){
			
		}
		catch(Exception e){
			
		}
    }*/
    
}
	}

}
