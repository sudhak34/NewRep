package com.mcaas.Hmchatbot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mcaas.genericlibraries.Xls_Reader;

public class discover_apitesting_chatbot {
	public static void main(String[] args) throws InterruptedException {
	Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\Discover\\Testing\\Discover_Automation\\API_Discover_with_welfare.xlsx");
    int rowCount = xl.getRowCount("Sheet1");
    System.out.println(rowCount);
    System.setProperty("webdriver.chrome.driver", "D:\\Framework\\Drivers\\New folder\\chromedriver.exe");
	WebDriver driver  = new ChromeDriver();
	for(int i=2;i<=rowCount;i++){
		String input = xl.getCellData("Sheet1", "Question", i);
		//String expected = xl.getCellData("Sheet1", "Answer_from_Chatbot", i);
		long Start_time = System.currentTimeMillis();
		driver.get("http://169.46.44.140:5014/response?companyname=Discover&queryInput="+input+"&userId=500223&typeOfRequest=plain_text");
		Thread.sleep(3000);
		long End_time = System.currentTimeMillis();
		String output = driver.findElement(By.xpath("xhtml:html/xhtml:body/xhtml:pre")).getText();
		System.out.println(i+"-"+driver.findElement(By.xpath("xhtml:html/xhtml:body/xhtml:pre")).getText());
		xl.setCellData("Sheet1", "Bot_response", i, output);
		String time=((End_time-Start_time)/1000+"seconds");
		xl.setCellData("Sheet1", "Response_time", i, time);
		System.out.println(time);
		/*if(output.contains(expected)){
			xl.setCellData("damac", "Result", i, "Pass");
		}
		else
			xl.setCellData("damac", "Result", i, "Fail");*/
	   }
	}
}
