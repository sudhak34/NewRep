package net.fns.pages;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility1.Utils;
import utility1.Xls_Reader;

public class Vault_feature_check extends Utils {
	public WebDriver driver;
	public String Vault_pdf_filename;
	public String vault_AssetID;
	public String Vault_image_grabtime;
	public String vault_PDF_download_time;
	public String Vault_Image_capture;
	public String Vault_PDF_Download;
	public Vault_feature_check(WebDriver driver) {
	     this.driver=driver;
	     waitFor(5);
	     PageFactory.initElements(driver,this);
	}
	
	    @FindBy(xpath = "html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/input")
		public WebElement Aug_search_Text_field;
	   
	    @FindBy(xpath = "html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/div/form/span[2]/button")
		public WebElement Aug_search_button;
	    
	    @FindBy(xpath = "html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div[3]/div[2]/research-feed/div[1]/div[2]/div[1]/div/div[5]/div/div[2]/div/span/a")
		public WebElement Read_Reserach_option;
	    
	    @FindBy(xpath = ".//*[@id='collapseOne']/div/div/div[1]/ul/li/a")
		public WebElement Toc_option;
	    
	    @FindBy(xpath = ".//*[@class='icon-c']")
		public WebElement Vault_icon;
	    
	    @FindBy(xpath = ".//*[@id='sectionId2']/div[1]")
		public WebElement Reserach_Grabbed_section_title;
	    
	    @FindBy(xpath = "//div[@class='ng-scope']//div//a//div[@class='sprite humburger_menu']")
		public WebElement Humburger_icon;
	    
	    @FindBy(xpath = "html/body/div[6]/div[1]/nav/div/div[1]/div/ul/li/ul/li[11]/span[2]/a")
		public WebElement To_Click_on_Vault_page;
	    
	    @FindBy(xpath = ".//*[@id='arrow_0']")
		public WebElement Vault_Down_Arrow;
	   
	    @FindBy(xpath = ".//*[@id='collapse_0']/div/div/a")
		public WebElement To_expand_vault_download_options;
	    
	    @FindBy(xpath = ".//*[@id='collapse_0']/div/ul/li[2]/a")
		public WebElement To_Download_vault_content_as_PDF;
	    
	    //Please wait PDF is being downloaded.
	    
	    @FindBy(xpath = "html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div/div[4]/ul/li[1]/div/div[2]/div[2]/button[2]")
		public WebElement To_Remove_grabbed_section;
	    
	    @FindBy(xpath = "html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/span")
		public WebElement Title_of_Reserach_Grabbed;
	    
	    @FindBy(xpath = "html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div/div[4]/ul/li[1]/div/div[2]/span/span")
		public WebElement Subtitle_of_Reserach_Grabbed;
	   
	    @FindBy(xpath = "html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div/div[4]/ul/li[1]/div/div[2]/div[1]")
		public WebElement Vault_saved_on;
	    
	    @FindBy(xpath = "html/body/div[6]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div/div[5]/div/div[1]/div/div/span/img")
		public WebElement To_delete_complete_grabbed_sections_research;
	    
	    @FindBy(xpath = ".//*[@id='report-title']/div/div/div/h2")
		public WebElement Research_Title;
	    //K02D-01-00-00-00
	    
	    public void Vault_feature_Testing() throws InterruptedException{
	    	waitForInvisibilityOfElement(60);
	    	Xls_Reader xl=new Xls_Reader(XL_path);
			String rownum = xl.getCellData("Vault","ROWID",2).replace("\"","").replace(".0","");
			Integer p = Integer.valueOf(rownum);
			System.out.println(p);
			String Vault_aug_search_keyword = xl.getCellData("Vault","Input", p);
			try{
	    	Aug_search_Text_field.clear();
	    	Aug_search_Text_field.sendKeys(Vault_aug_search_keyword);
	    	Aug_search_button.click();
	    	waitForInvisibilityOfElement(60);
	    	Read_Reserach_option.click();
	    	String Parent_window = driver.getWindowHandle();
			String childwindow=null;
			Set<String> windowHandles = driver.getWindowHandles();//window handling
			//for(datatype variable:value)
			for(String x:windowHandles) {
				//System.out.println(x);
				if(!x.equals(Parent_window)) {
					childwindow=x;
					
				}
				
			}
			driver.switchTo().window(childwindow);
			waitForInvisibilityOfElement(60);
			System.out.println(Research_Title.getText());
			for(int i=1;i<=60;i++){
				Thread.sleep(1000);
				//System.out.println(i);
			boolean contains = driver.getPageSource().contains("Please wait research is loading");
			if(contains==false){
				break;
				
			}
		}
			Toc_option.click();
			waitFor(5);
			System.out.println(Reserach_Grabbed_section_title.getText());
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", Vault_icon);
			long start_time_vault = System.currentTimeMillis();
			//Vault_icon.click();
			for(int i=1;i<=80;i++){
				Thread.sleep(1000);
			boolean contains = driver.getPageSource().contains("Please wait image is being saved");
			if(contains==false){
				break;
			
			}
			  }
			long end_time_vault = System.currentTimeMillis();
			long totalTime1 = end_time_vault-start_time_vault ;
			String s4=String.valueOf(totalTime1/1000);
			if((totalTime1/1000)<=40){
				Vault_Image_capture="<span style=color:green>Pass</span>";
			}
            else{
            	Vault_Image_capture="<span style=color:red>Fail</span>";
            }
			System.out.println(s4 +"  seconds is the time taken for the image to be grabbed");
			xl.setCellData("Vault","Image_capture_Response", p, s4);
		  driver.close();
		  driver.switchTo().window(Parent_window);
		  waitFor(10);
		  waitForElementVisible(Humburger_icon);
		  Humburger_icon.click();
		  waitFor(2);
		  waitForElementVisible(To_Click_on_Vault_page);
		  To_Click_on_Vault_page.click();
		  waitForInvisibilityOfElement(60);		
		  waitForElementVisible(Vault_Down_Arrow);
		  Vault_Down_Arrow.click();
		  waitForInvisibilityOfElement(60);
		  System.out.println(Title_of_Reserach_Grabbed.getText());
		  System.out.println(Subtitle_of_Reserach_Grabbed.getText()+ "----saved on:"+Vault_saved_on.getText());
		  To_expand_vault_download_options.click();
		  To_Download_vault_content_as_PDF.click();
		  long start_time_01 = System.currentTimeMillis();
		  for(int j=1;j<=120;j++){
				Thread.sleep(1000);
			boolean contains = driver.getPageSource().contains("Please wait PDF is being downloaded.");
			if(contains==false){
				break;
				}
			if(j>=90){
				System.out.println("Vault pdf download message remains on screen after 90 seconds");
			}
			
		  }
		    long end_time_01 = System.currentTimeMillis();
			long totalTime01 = end_time_01-start_time_01 ;
			String s3=String.valueOf(totalTime01/1000);
			if((totalTime01/1000)<=90){
				Vault_PDF_Download="<span style=color:green>Pass</span>";
			}
            else{
            	Vault_PDF_Download="<span style=color:red>Fail</span>";
            }
			System.out.println(s3 +"  seconds is the time taken for the vault pdf to get downloaded");
			xl.setCellData("Vault", "Vault_PDF_download", p, s3);
			waitFor(10);
			To_Remove_grabbed_section.click();
			waitForInvisibilityOfElement(60);
			waitFor(30);
			File getLatestFile = getLatestFilefromDir("C:\\Users\\sudhakar.koduri\\Downloads");
			Vault_pdf_filename = "<span style=color:green>"+getLatestFile.getName()+"</span>";
			System.out.println(Vault_pdf_filename);
			waitFor(10);
			 vault_AssetID = "<span style=color:green>"+xl.getCellData("Vault","Input",p)+"</span>";
			 Vault_image_grabtime = "<span style=color:green>"+xl.getCellData("Vault","Image_capture_Response",p)+" "+"sec"+"</span>";
			 vault_PDF_download_time = "<span style=color:green>"+xl.getCellData("Vault","Vault_PDF_download",p)+" "+"sec"+"</span>";
			 p+=1;
	    }
			catch(Exception e){
				vault_AssetID = "<span style=color:red>"+"-Fail</span>";
				Vault_image_grabtime = "<span style=color:red>"+"-Fail</span>";
				vault_PDF_download_time = "<span style=color:red>"+"-Fail</span>";
				Vault_pdf_filename = "<span style=color:red>"+"-Fail</span>";
			}
	    }
	    
	    
	    
}
