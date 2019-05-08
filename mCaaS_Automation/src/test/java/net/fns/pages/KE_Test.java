package net.fns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility1.Utils;
import utility1.Xls_Reader;

public class KE_Test extends Utils {
	public WebDriver driver;
	public String KE_Keyword_01;
	public String KE_Keyword_02;
	public String KE_Keyword_01_response;
	public String KE_Keyword_02_response;
	public KE_Test(WebDriver driver) {
     this.driver=driver;
     waitFor(5);
     PageFactory.initElements(driver,this);
}
	@FindBy(xpath = ".//*[@id='pkw-portal']")
	public WebElement KE_Icon;
	
	@FindBy(xpath = ".//*[@id='portal-chatbot-panel']/div[3]/form/div/textarea")
	public WebElement KE_Input_textarea;
	
	@FindBy(xpath = ".//*[@id='portal-chatbot-panel']/div[3]/form/div/button")
	public WebElement KE_enter_button;
	
	@FindBy(xpath = ".//*[contains(@class,'loader-anim bot')]/i[4]/span[text() ='Searching...']")
	                
	public WebElement KE_loading_icon;
	
	@FindBy(xpath = "html/body/div[6]/div[5]/chatbot/div[1]/div/div/div[2]/div/div[1]/div[3]/div/div[1]/div/div[1]/span[2]/span")
	public WebElement KE_response_title;
	
	@FindBy(xpath="html/body/div[6]/div[5]/chatbot/div[1]/div/div/div[1]/div[3]/div")
	 public WebElement KE_window_close;
	public void KE_Response_method() throws InterruptedException {
		Xls_Reader xl=new Xls_Reader(XL_path);
		String rownum = xl.getCellData("KE_Search","ROWID", 2).replace("\"","").replace(".0","");
		Integer k = Integer.valueOf(rownum);
		System.out.println(k);
		waitFor(5);
		try{
		waitForElementVisible(KE_Icon);
		waitFor(3);
		KE_Icon.click();
		for(int j=k;j<=k+1;j++){
			System.out.println(j);
		String KE_keyword = xl.getCellData("KE_Search", "Input", j);
		waitForElementVisible(KE_Input_textarea);
		waitFor(2);
		KE_Input_textarea.sendKeys(KE_keyword);
		waitForElementVisible(KE_enter_button);
		waitFor(2);
		KE_enter_button.click();
		long start_time = System.currentTimeMillis();
		//waitforinvisibilityOfElement_KEloadingicon(KE_loading_icon);
		for(int i=1;i<=80;i++){
			Thread.sleep(1000);
			//System.out.println(i);
		boolean contains = driver.getPageSource().contains("Searching...");
		if(contains==false){
			break;
		}
	}
		long end_time = System.currentTimeMillis();
		long totalTime1 = end_time-start_time ;
		String s1=String.valueOf(totalTime1/1000);
		System.out.println(s1 +"  seconds is the time taken for the KE to response");
		//System.out.println(KE_response_title.getText());
		xl.setCellData("KE_Search", "Response", j, s1);
		}
		
		waitFor(3);
		KE_window_close.click();
		KE_Keyword_01 = "<span style=color:green>"+xl.getCellData("KE_Search", "Input", k)+"</span>";
		KE_Keyword_01_response = "<span style=color:green>"+xl.getCellData("KE_Search", "Response", k)+" "+"sec"+"</span>";
		String cellData = xl.getCellData("KE_Search", "Response", k);
		Integer m = Integer.valueOf(cellData);
		if(m==null||m>=60){
			KE_Keyword_01_response = "<span style=color:red>"+xl.getCellData("KE_Search", "Response", k)+" "+"sec"+"</span>";
		}
		KE_Keyword_02 = "<span style=color:green>"+xl.getCellData("KE_Search", "Input", k+1)+"</span>";
		KE_Keyword_02_response = "<span style=color:green>"+xl.getCellData("KE_Search", "Response", k+1)+" "+"sec"+"</span>";
		String cellData1 = xl.getCellData("KE_Search", "Response", k+1);
		Integer n = Integer.valueOf(cellData1);
		if(n==null||n>=60){
			KE_Keyword_01_response = "<span style=color:red>"+xl.getCellData("KE_Search", "Response", k+1)+" "+"sec"+"</span>";
		}
		k+=2;
		xl.setCellData("KE_Search", "ROWID", 2, String.valueOf(k));
		}
		
		catch(Exception e){
			KE_Keyword_01 = "<span style=color:green>"+xl.getCellData("KE_Search", "Input", k)+"</span>";
			KE_Keyword_01_response = "<span style=color:red>"+"-Fail</span>";
			KE_Keyword_02 = "<span style=color:green>"+xl.getCellData("KE_Search", "Input", k+1)+"</span>";
			KE_Keyword_02_response = "<span style=color:red>"+"-Fail</span>";
			KE_window_close.click();
			k+=2;
			xl.setCellData("KE_Search", "ROWID", 2, String.valueOf(k));
		}
	}
}