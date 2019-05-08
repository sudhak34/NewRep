package com.KIA.Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mcaas.genericlibraries.Xls_Reader;

public class KIa_generic_tetsing {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\KIA\\KIA_Testing_25102017\\KIA_25102017 - Copy.xlsx");
	    int rowCount = xl.getRowCount("Sheet1");
	    System.out.println(rowCount);
	    WebDriverWait wait=new WebDriverWait(driver,20);
	    for(int i=2;i<=rowCount;i++){
	    	System.out.println(i);
		 	String input = xl.getCellData("Sheet1", "Question", i);
			String expected = xl.getCellData("Sheet1", "Expected", i);
			try{
			driver.get("http://169.46.44.140:8082/kia3_response?companyname=KIA&queryInput="+input+"&userId=2");
			//String expected_result = expected.replaceAll("\\s{2,}","");
			//System.out.println(i+"----"+expected);
			String API ="http://169.46.44.140:8082/kia3_response?companyname=KIA&queryInput="+input+"&userId=2";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xhtml:html/xhtml:body/xhtml:pre")));
			String actual = driver.findElement(By.xpath("xhtml:html/xhtml:body/xhtml:pre")).getText();
			xl.setCellData("Sheet1", "Actual", i, actual);
			}
			
			catch(ElementNotVisibleException e){
				System.out.println("Fail");
			}
			catch(NoSuchElementException e){
				System.out.println("Fail");
			}
	    }

	}

}
