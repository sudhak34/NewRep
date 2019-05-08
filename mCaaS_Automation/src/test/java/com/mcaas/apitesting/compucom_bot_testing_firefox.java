package com.mcaas.apitesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mcaas.genericlibraries.Xls_Reader;

public class compucom_bot_testing_firefox {
	@SuppressWarnings("null")
	public static void main(String[] args) throws JSONException, IOException {
		
		try {
			   WebDriver driver=new ChromeDriver();
			   /*System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\Sudhakar_mCaaS\\DQA\\Latest\\chromedriver.exe");
			   WebDriver driver  = new ChromeDriver();*/
			   driver.manage().window().maximize();
			   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		       Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\Compucom_Bot\\Test_results_13072017\\Compucom_bot_FF_03.xlsx");
		       int rowCount = xl.getRowCount("Sheet1");
		       System.out.println(rowCount);
		       for(int j=800;j<=rowCount;j++){
		       String company = xl.getCellData("Sheet1", "COMPANY", j);
		       String short_description = xl.getCellData("Sheet1", "SHORT_DESCRIPTION", j);
		       String meta = xl.getCellData("Sheet1", "META", j);
		       String issue = xl.getCellData("Sheet1", "ISSUE", j);
		       String expected_response_from_bot = xl.getCellData("Sheet1", "Answer_from_Chatbot", j);
		       //String replace1 = expected_response_from_bot.replaceAll("\\s","");
		       String replace1 = expected_response_from_bot.replaceAll("\\s{2,}", " ").trim().replaceAll("\"", "").replaceAll(",", " ");
		       //String replace_01 = replace1.replaceAll("\\<[^>]*>","");
		       String replace_01 = replace1.replaceAll("(?:<style.+?>.+?</style>|<script.+?>.+?</script>|<(?:!|/?[a-zA-Z]+).*?/?>)","");
		       System.out.println(replace_01);
		       xl.setCellData("Sheet1", "Answer_from_Chatbot", j, replace_01);
		       driver.get("http://169.46.44.140:8080/chatbots?companyname="+company+"&queryInput="+short_description+"&type=compucom");
		       String Actual_resposne = driver.findElement(By.xpath("xhtml:html/xhtml:body/xhtml:pre")).getText();
		       
		       //String Actual_resposne = driver.findElement(By.xpath("html/body/pre/span[3]/code/span[5]/span[2]")).getText();
		       //JSONObject json = (JSONObject) JSONSerializer.toJSON(Actual_resposne);
		       //String jsonObject = json.getString("Resolution:");
		       String s2 = Actual_resposne.substring(Actual_resposne.indexOf("Resolution") + 14);
		       
	            File newTextFile = new File("D:\\Sudhakar_Data\\Backup\\E\\Compucom_Bot\\textfilefirefox.txt");

	            FileWriter fw = new FileWriter(newTextFile);
	            fw.write(s2);
	            fw.close();
	            String FILENAME = "D:\\Sudhakar_Data\\Backup\\E\\Compucom_Bot\\textfilefirefox.txt";
	            BufferedReader br = null;
	    		FileReader fr = null;
	    		fr = new FileReader(FILENAME);
				br = new BufferedReader(fr);
				String sCurrentLine;

				br = new BufferedReader(new FileReader(FILENAME));

				while ((sCurrentLine = br.readLine()) != null) {
					//System.out.println(sCurrentLine.replaceAll("(\\\\r\\\\r\\\\n|\\\\r\\\\n|\\\\n)", ""));
					String text = sCurrentLine.replaceAll("(\\\\r|\\\\r\\\\r\\\\r\\\\r|\\\\r\\\\r\\\\n|\\\\r\\\\n|\\\\n)", "");
				       //String replace2 = text.replaceAll("\\s","");
					String replace2 = text.replaceAll("  "," ");
				       replace2 = replace2.replaceAll("\\\\", "");
				       String replace_04 = replace2.replaceAll("\\<[^>]*>","").split("score_value")[0].replaceAll("\"", "").replaceAll(",", " ");
				       System.out.println(j+"---"+replace_04);
				       xl.setCellData("Sheet1", "Actual_response_bot", j, replace_04);
				       if(replace_04.replaceAll("\\s+","").contains(replace_01.replaceAll("\\s+",""))) {
				    	   xl.setCellData("Sheet1", "Result", j, "Pass");
							System.out.println("Pass");
				    	}
				       else{
				    	   xl.setCellData("Sheet1", "Result", j, "Fail");
					       System.out.println("Fail"); 
				       }
				       /*if(replace_04.contains(replace_01)){
							xl.setCellData("Sheet1", "Result", j, "Pass");
							System.out.println("Pass");
						}
						else{
							xl.setCellData("Sheet1", "Result", j, "Fail");
				       System.out.println("Fail");
						}*/
				       }
				}
				//String text = sCurrentLine.replace("\n", "").replace("\r", "");
		    	   /*File myFile = new File("D:\\Sudhakar_Data\\Backup\\E\\Compucom_Bot\\textfile.txt");
					FileWriter fileWriter = new FileWriter(myFile);
					fileWriter.write(s2);
					fileWriter.close();*/
					
			       
		       //String text = s2.replaceAll(System.getProperty("line.separator"), "");
		       
		}
		       
		catch(NoSuchElementException e){
			
		}
		catch(ElementNotVisibleException e){
			
		}
		
	
		}
}
