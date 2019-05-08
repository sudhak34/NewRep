package net.fns.pages;



import java.io.File;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility1.Utils;
import utility1.Xls_Reader;

public class Reserach_Load_Pdf_download extends Utils {
	
	public WebDriver driver;
	public String AssetID_01;
	public String AssetID_02;
	public String AssetID_03;
	public String Research_loadtime_01;
	public String Research_loadtime_02;
	public String Research_loadtime_03;
	public String PDF_download_time;
	public String pdf_filename;
	public String Parent_window;
	public String Research_load_01;
	public String Research_load_02;
	public String Research_load_03;
	public String PDF_Download;
	
	 public  Reserach_Load_Pdf_download(WebDriver driver){
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
	    
	    @FindBy(xpath = ".//*[@id='download_pdf_tour']/a/div")
		public WebElement Download_pdf_option;
	    
	    @FindBy(xpath = ".//*[@id='download_pdf_tour']/ul/li/button")
		public WebElement Download_pdf;
	    
	    @FindBy(xpath = ".//*[@id='report-title']/div/div/div/h2")
		public WebElement Research_Title;
	    
	   
	    
	    	public void download_pdf_researchrender() throws InterruptedException{
	    	Xls_Reader xl=new Xls_Reader(XL_path);
			String rownum = xl.getCellData("Report_loading", "ROWID", 2).replace("\"", "").replace(".0","");
			//int rowCount = xl.getRowCount("Report_loading");
			//Integer k = Integer.valueOf(rownum);
			Integer k= Integer.parseInt(rownum);
			System.out.println(k);
			//String Aug_search_keyword = xl.getCellData("Report_loading", "Input", k);
			waitFor(15);
			try{
			for(int j=k;j<=k+2;j++){
			String Aug_search_keyword = xl.getCellData("Report_loading", "Input", j);
	    	Aug_search_Text_field.clear();
	    	Aug_search_Text_field.sendKeys(Aug_search_keyword);
	    	Aug_search_button.click();
	    	waitForInvisibilityOfElement(60);
	    	Read_Reserach_option.click();
	    	Parent_window = driver.getWindowHandle();
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
			try{
			waitForInvisibilityOfElement(0);
			}
			catch(Exception e){
				
			}
			System.out.println(Research_Title.getText());
			long start_time = System.currentTimeMillis();
			//waitforinvisibilityOfElement_KEloadingicon(KE_loading_icon);
			for(int i=1;i<=120;i++){
				Thread.sleep(1000);
				//System.out.println(i);
			boolean contains = driver.getPageSource().contains("Please wait research is loading");
			if(contains==false){
				break;
			}
		}
			long end_time = System.currentTimeMillis();
			long totalTime1 = end_time-start_time ;
			String s2=String.valueOf(totalTime1/1000);

          
            
			System.out.println(s2 +"  seconds is the time taken for the research to load");
			xl.setCellData("Report_loading", "Report_Response", j, s2);
			driver.close();
			driver.switchTo().window(Parent_window);
            }
			    AssetID_01 = xl.getCellData("Report_loading", "Input", k);
			    String cellData_01 = xl.getCellData("Report_loading", "Report_Response", k);
				Integer m = Integer.valueOf(cellData_01);
				if(m>=10){
					Research_loadtime_01 = "<span style=color:red>"+xl.getCellData("Report_loading", "Report_Response", k)+" "+"sec"+"</span>";
					
				}
				else{
					Research_loadtime_01 = "<span style=color:green>"+xl.getCellData("Report_loading", "Report_Response", k)+" "+"sec"+"</span>";
				}
				 if(m<=90){
						Research_load_01="<b><span style=color:green>Pass</span></b>";
					}
		            else{
		            	Research_load_01="<span style=color:red>Fail(Research Loading message remained on screen though content loaded successfully)</span>";
		            }
				AssetID_02 = xl.getCellData("Report_loading", "Input", k+1);
			    String cellData_02 = xl.getCellData("Report_loading", "Report_Response", k+1);
				Integer n = Integer.valueOf(cellData_02);
				if(n>=10){
					Research_loadtime_02 = "<span style=color:red>"+xl.getCellData("Report_loading", "Report_Response", k+1)+" "+"sec"+"</span>";
				}
				else{
					Research_loadtime_02 = "<span style=color:green>"+xl.getCellData("Report_loading", "Report_Response", k+1)+" "+"sec"+"</span>";
				}
				if(n<=90){
					Research_load_02="<b><span style=color:green>Pass</span></b>";
				}
	            else{
	            	Research_load_02="<span style=color:red>Fail(Research Loading message remained on screen though content loaded successfully)</span>";
	            }
				AssetID_03 = xl.getCellData("Report_loading", "Input", k+2);
			    String cellData_03 = xl.getCellData("Report_loading", "Report_Response", k+2);
				Integer p = Integer.valueOf(cellData_03);
				if(p>=10){
					Research_loadtime_03 = "<span style=color:red>"+xl.getCellData("Report_loading", "Report_Response", k+2)+" "+"sec"+"</span>";
				}
				else{
					Research_loadtime_03 = "<span style=color:green>"+xl.getCellData("Report_loading", "Report_Response", k+2)+" "+"sec"+"</span>";
				}
				if(p<=90){
					Research_load_03="<b><span style=color:green>Pass</span></b>";
				}
	            else{
	            	Research_load_03="<span style=color:red>Fail(Research Loading message remained on screen though content loaded successfully.)</span>";
	            }
			
			
			
			k+=3;
			xl.setCellData("Report_loading", "ROWID", 2, String.valueOf(k));
			
			if(k>=90){
				k=2;
				xl.setCellData("Report_loading", "ROWID", 2, String.valueOf(k));
			}
			}
			catch(Exception e){
				/*AssetID_01 = "<span style=color:red>"+xl.getCellData("Report_loading", "Input", k)+"</span>";
				Research_loadtime_01 = "<span style=color:red>"+"Fail</span>";
				Research_load_01="<span style=color:red>Fail</span>";
				AssetID_02 = "<span style=color:red>"+xl.getCellData("Report_loading", "Input", k+1)+"</span>";
				Research_loadtime_02 = "<span style=color:red>"+"Fail</span>";
				Research_load_02="<span style=color:red>Fail</span>";
				AssetID_03 = "<span style=color:red>"+xl.getCellData("Report_loading", "Input", k+2)+"</span>";
				Research_loadtime_03 = "<span style=color:red>"+"Fail</span>";
				Research_load_03="<span style=color:red>Fail</span>";*/
				AssetID_01 = xl.getCellData("Report_loading", "Input", k);
			    String cellData_01 = xl.getCellData("Report_loading", "Report_Response", k);
				Integer m = Integer.valueOf(cellData_01);
				if(m>=10){
					Research_loadtime_01 = "<span style=color:red>"+xl.getCellData("Report_loading", "Report_Response", k)+" "+"sec"+"</span>";
					
				} 
				
				else {
					Research_loadtime_01 = "<span style=color:green>"+xl.getCellData("Report_loading", "Report_Response", k)+" "+"sec"+"</span>";
				}
				 if(m<=90){
						Research_load_01="<b><span style=color:green>Pass</span></b>";
					}
				     else{
		            	Research_load_01="<span style=color:red>Fail</span>";
		            }
				AssetID_02 = xl.getCellData("Report_loading", "Input", k+1);
			    String cellData_02 = xl.getCellData("Report_loading", "Report_Response", k+1);
				Integer n = Integer.valueOf(cellData_02);
				if(n>=10){
					Research_loadtime_02 = "<span style=color:red>"+xl.getCellData("Report_loading", "Report_Response", k+1)+" "+"sec"+"</span>";
				}
				
				else{
					Research_loadtime_02 = "<span style=color:green>"+xl.getCellData("Report_loading", "Report_Response", k+1)+" "+"sec"+"</span>";
				}
				if(n<=90){
					Research_load_02="<b><span style=color:green>Pass</span></b>";
				}
				
	            else{
	            	Research_load_02="<span style=color:red>Fail</span>";
	            }
				AssetID_03 = xl.getCellData("Report_loading", "Input", k+2);
			    String cellData_03 = xl.getCellData("Report_loading", "Report_Response", k+2);
				Integer p = Integer.valueOf(cellData_03);
				if(p>=10){
					Research_loadtime_03 = "<span style=color:red>"+xl.getCellData("Report_loading", "Report_Response", k+2)+" "+"sec"+"</span>";
				}
				
				else{
					Research_loadtime_03 = "<span style=color:green>"+xl.getCellData("Report_loading", "Report_Response", k+2)+" "+"sec"+"</span>";
				}
				if(p<=90){
					Research_load_03="<b><span style=color:green>Pass</span></b>";
				}
				   else{
	            	Research_load_03="<span style=color:red>Fail</span>";
	            }
				/*pdf_filename = "<span style=color:red>"+"Fail</span>";
				PDF_download_time = "<span style=color:red>"+"-Fail</span>";*/
				driver.switchTo().window(Parent_window);
				k+=3;
				xl.setCellData("Report_loading", "ROWID", 2, String.valueOf(k));
				if(k>=90){
					k=2;
					xl.setCellData("Report_loading", "ROWID", 2, String.valueOf(k));
				}
			}
	    }
	    
	    
	    
}
	/*public WebDriver driver;
	public String AssetID;
	public String Research_loadtime;
	public String PDF_download_time;
	public String pdf_filename;
	public String Parent_window;
	public String Research_load;
	public String PDF_Download;
	 public  Reserach_Load_Pdf_download(WebDriver driver){
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
	    
	    @FindBy(xpath = ".//*[@id='download_pdf_tour']/a/div")
		public WebElement Download_pdf_option;
	    
	    @FindBy(xpath = ".//*[@id='download_pdf_tour']/ul/li/button")
		public WebElement Download_pdf;
	    
	    @FindBy(xpath = ".//*[@id='report-title']/div/div/div/h2")
		public WebElement Research_Title;
	    
	   
	    
	    public void download_pdf_researchrender() throws InterruptedException{
	    	Xls_Reader xl=new Xls_Reader(XL_path);
			String rownum = xl.getCellData("Report_loading", "ROWID", 2).replace("\"","").replace(".0","");
			Integer k = Integer.valueOf(rownum);
			System.out.println(k);
			String Aug_search_keyword = xl.getCellData("Report_loading", "Input", k);
			try{
	    	Aug_search_Text_field.clear();
	    	Aug_search_Text_field.sendKeys(Aug_search_keyword);
	    	Aug_search_button.click();
	    	waitForInvisibilityOfElement(60);
	    	Read_Reserach_option.click();
	    	Parent_window = driver.getWindowHandle();
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
			long start_time = System.currentTimeMillis();
			//waitforinvisibilityOfElement_KEloadingicon(KE_loading_icon);
			for(int i=1;i<=80;i++){
				Thread.sleep(1000);
				//System.out.println(i);
			boolean contains = driver.getPageSource().contains("Please wait research is loading");
			if(contains==false){
				break;
			}
		}
			long end_time = System.currentTimeMillis();
			long totalTime1 = end_time-start_time ;
			String s2=String.valueOf(totalTime1/1000);
            if((totalTime1/1000)<=50){
				Research_load="<span style=color:green>Pass</span>";
			}
            else{
            	Research_load="<span style=color:red>Fail</span>";
            }
            	
			System.out.println(s2 +"  seconds is the time taken for the research to load");
			xl.setCellData("Report_loading", "Report_Response", k, s2);
			waitForElementVisible(Download_pdf_option);
			Download_pdf_option.click();
			waitForElementVisible(Download_pdf);
			Download_pdf.click();
			long start_time_dow_pdf = System.currentTimeMillis();
			//waitforinvisibilityOfElement_KEloadingicon(KE_loading_icon);
			for(int i=1;i<=100;i++){
				Thread.sleep(1000);
				//System.out.println(i);
			boolean contains = driver.getPageSource().contains("Please wait PDF is being downloaded");
			if(contains==false){
				break;
			}
		}
			long end_time_dow_pdf = System.currentTimeMillis();
			long totalTime_pdf = end_time_dow_pdf-start_time_dow_pdf ;
			String s3=String.valueOf(totalTime_pdf/1000);
			System.out.println(s3 +"  seconds is the time taken for the pdf to get downloaded");
			if((totalTime_pdf/1000)<=80){
				PDF_Download="<span style=color:green>Pass</span>";
			}
            else{
            	PDF_Download="<span style=color:red>Fail</span>";
            }
			xl.setCellData("Report_loading", "Download_pdf_Response", k, s3);
			waitFor(20);
		   
			File getLatestFile = getLatestFilefromDir("C:\\Users\\sudhakar.koduri\\Downloads");
			//String fileName = getLatestFile.getName();
			
			    AssetID = "<span style=color:green>"+xl.getCellData("Report_loading", "Input", k)+"</span>";
				Research_loadtime = "<span style=color:green>"+xl.getCellData("Report_loading", "Report_Response", k)+" "+"sec"+"</span>";
				pdf_filename = "<span style=color:green>"+getLatestFile.getName()+"</span>";
				System.out.println(pdf_filename);
				PDF_download_time = "<span style=color:green>"+xl.getCellData("Report_loading", "Download_pdf_Response", k)+" "+"sec"+"</span>";
			k+=1;
			xl.setCellData("Report_loading", "ROWID", 2, String.valueOf(k));
			
			driver.close();
			driver.switchTo().window(Parent_window);
			}
			catch(Exception e){
				AssetID = "<span style=color:red>"+"-Fail</span>";
				Research_loadtime = "<span style=color:red>"+"-Fail</span>";
				pdf_filename = "<span style=color:red>"+"-Fail</span>";
				PDF_download_time = "<span style=color:red>"+"-Fail</span>";
				driver.close();
				driver.switchTo().window(Parent_window);
			}
	    }
	    
	    
	    
}*/
