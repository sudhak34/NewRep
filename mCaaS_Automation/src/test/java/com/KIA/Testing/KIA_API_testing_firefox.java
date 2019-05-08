package com.KIA.Testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mcaas.genericlibraries.Xls_Reader;

public class KIA_API_testing_firefox {

			public static void main(String[] args) throws InterruptedException, IOException, NoSuchFieldException  {
			Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\KIA\\KIA_Testing_04102017\\KIA_API_Testing_04102017.xlsx");
		    int rowCount = xl.getRowCount("Sheet1");
		    System.out.println(rowCount);
		    WebDriver driver=new ChromeDriver();
		    /*System.setProperty("webdriver.chrome.driver", "D:\\Framework\\Drivers\\New folder\\chromedriver.exe");
			WebDriver driver  = new ChromeDriver();*/
			for(int i=2;i<=rowCount;i++){
				try{
			 	String input = xl.getCellData("Sheet1", "Question", i);
				String expected = xl.getCellData("Sheet1", "Actual_Answer", i);
			    String replace1 = expected.replaceAll("\\s{2,}"," ").trim().replaceAll("\"", "").replaceAll(",", " ");
			    String replace_01 = replace1.replaceAll("(?:<style.+?>.+?</style>|<script.+?>.+?</script>|<(?:!|/?[a-zA-Z]+).*?/?>)","");
			    System.out.println(i);
			    System.out.println(replace_01.replaceAll("\\s",""));
			    driver.get("http://169.46.44.140:5016/kia_response?companyname=KIA&queryInput="+input+"&userId=124");
			    WebDriverWait wait=new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xhtml:html/xhtml:body/xhtml:pre")));
				//long End_time = System.currentTimeMillis();
				String output = driver.findElement(By.xpath("xhtml:html/xhtml:body/xhtml:pre")).getText();
				String s2 = output.substring(output.indexOf("Answer") + 10);
				
				//String s3 = output.substring(output.indexOf("Answer") + 10);
				//System.out.println(s2);
				File newTextFile = new File("D:\\Sudhakar_Data\\Backup\\E\\KIA\\KIA_Auto.txt");
	            FileWriter fw;
				fw = new FileWriter(newTextFile);
				fw.write(s2);
	            fw.close();
			    String FILENAME = "D:\\Sudhakar_Data\\Backup\\E\\KIA\\KIA_Auto.txt";
	            BufferedReader br = null;
	    		FileReader fr = null;
	    		fr = new FileReader(FILENAME);
				br = new BufferedReader(fr);
				String sCurrentLine;
				br = new BufferedReader(new FileReader(FILENAME));
				while ((sCurrentLine = br.readLine()) != null) {
					//System.out.println(sCurrentLine.replaceAll("(\\\\r\\\\r\\\\n|\\\\r\\\\n|\\\\n)", ""));
					String text = sCurrentLine.replaceAll("(\\\\r|\\\\r\\\\r\\\\r\\\\r|\\\\r\\\\r\\\\n|\\\\r\\\\n|\\\\n|\\\\r\\\\r\\\\n1|\\\\r\\\\r\\\\n2|\\\\r\\\\r\\\\n3)", "");
				       //String replace2 = text.replaceAll("\\s","");
					String replace2 = text.replaceAll("  "," ");
				       replace2 = replace2.replaceAll("\\\\", "");
				       String replace_04 = replace2.replaceAll("\\<[^>]*>","").split("score_value")[0].replaceAll("\"", "").replaceAll(",", " ");
				       String replace_05 = replace_04.replaceAll("\\s{2,}"," ").trim().replaceAll("\"", "").replaceAll(",", " ");
					    String replace_06 = replace_05.replaceAll("(?:<style.+?>.+?</style>|<script.+?>.+?</script>|<(?:!|/?[a-zA-Z]+).*?/?>)","");
				       System.out.println(replace_06.replaceAll("\\s",""));
				       //xl.setCellData("Sheet1", "Actual_response_bot", j, replace_04);
				       if(replace_06.replaceAll("\\s","").contains(replace_01.replaceAll("\\s",""))){
							xl.setCellData("Sheet1", "Result", i, "Pass");
							System.out.println("Pass");
						}
						else{
							xl.setCellData("Sheet1", "Result", i, "Fail");
						System.out.println("Fail");
						}
				//System.out.println(i+"-"+driver.findElement(By.xpath("xhtml:html/xhtml:body/xhtml:pre")).getText());
				//String text = s2.replaceAll("(\\\\r|\\\\r\\\\r\\\\r\\\\r|\\\\r\\\\r\\\\n|\\\\r\\\\n|\\\\n|\\\\n1|\\\\n2|\\\\n3|\\\\n4)", "");
				//System.out.println(text);
				xl.setCellData("Sheet1", "Api_Resposne", i, output);
				
				}
			}
		        
				catch(ElementNotVisibleException e){
		   			
		   		            }
		   		catch(NoSuchElementException e){
		   			
		   		            }
			
		}			
	}
}
