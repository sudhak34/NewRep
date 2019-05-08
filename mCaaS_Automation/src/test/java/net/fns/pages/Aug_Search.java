package net.fns.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility1.Utils;
import utility1.Xls_Reader;

public class Aug_Search extends Utils {
		public WebDriver driver;
		public String Aug_Keyword_01;
		public String Aug_Keyword_01_response;
		public String Aug_Keyword_02;	
		public String Aug_Keyword_02_response;
		public Aug_Search(WebDriver driver) {
	     this.driver=driver;
	     waitFor(5);
	     PageFactory.initElements(driver,this);
	}
	
		@FindBy(xpath = "html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/input")
		public WebElement Aug_search_Text_field;
		
		@FindBy(xpath = "html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/span[2]/button")
		public WebElement Aug_search_button;
		
		@FindBy(xpath = "html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/span/span")
		public WebElement Aug_search_Results_shown;
		
		public void Aug_search_results(){
			Xls_Reader xl=new Xls_Reader(XL_path);
			String rownum = xl.getCellData("Aug_Search","ROWID", 2).replace("\"","").replace(".0","");
			Integer k = Integer.valueOf(rownum);
			System.out.println(k);
			try{
			for(int j=k;j<=k+1;j++){
			System.out.println(j);
			String Aug_search_keyword = xl.getCellData("Aug_Search", "Input", j);
			Aug_search_Text_field.clear();
			Aug_search_Text_field.sendKeys(Aug_search_keyword);
			Aug_search_button.click();
			long start_time = System.currentTimeMillis();
			waitForInvisibilityOfElement(60);
			waitForElementVisible(Aug_search_Results_shown);
			System.out.println(Aug_search_Results_shown.getText());
			long End_time = System.currentTimeMillis();
			long resp_time=(End_time-start_time);
			String s2=String.valueOf(resp_time/1000);
			System.out.println("Aug search resposne time:"+s2);
			xl.setCellData("Aug_Search", "Response", j, s2);
			}
			waitFor(3);
			
		    Aug_Keyword_01 = "<span style=color:green>"+xl.getCellData("Aug_Search", "Input", k)+"</span>";
			Aug_Keyword_01_response = "<span style=color:green>"+xl.getCellData("Aug_Search", "Response", k)+" "+"sec"+"</span>";
			Aug_Keyword_02 = "<span style=color:green>"+xl.getCellData("Aug_Search", "Input", k+1)+"</span>";
			Aug_Keyword_02_response = "<span style=color:green>"+xl.getCellData("Aug_Search", "Response", k+1)+" "+"sec"+"</span>";
			k+=2;
			xl.setCellData("Aug_Search", "ROWID", 2, String.valueOf(k));
			}
			catch(Exception e){
				Aug_Keyword_01 = "<span style=color:green>"+xl.getCellData("Aug_Search", "Input", k)+"</span>";
				Aug_Keyword_01_response="<span style=color:red>"+"-Fail </span>";
				Aug_Keyword_02 = "<span style=color:green>"+xl.getCellData("Aug_Search", "Input", k+1)+"</span>";
				Aug_Keyword_02_response="<span style=color:red>"+"-Fail </span>";
				k+=2;
				xl.setCellData("Aug_Search", "ROWID", 2, String.valueOf(k));
			 }
		}
		
		
}
