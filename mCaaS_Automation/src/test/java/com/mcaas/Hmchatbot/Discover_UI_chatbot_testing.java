package com.mcaas.Hmchatbot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.mcaas.genericlibraries.Xls_Reader;

public class Discover_UI_chatbot_testing {

	public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IOException {
		/*DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);*/
		//WebDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Sudhakar_Data\\Backup\\E\\Sudhakar_mCaaS\\DQA\\Latest\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		/*File file = new File("D:\\Sudhakar_Data\\Backup\\E\\Sudhakar_mCaaS\\DQA\\Latest\\MicrosoftWebDriver (4).exe");

	    System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
	    DesiredCapabilities capabilities = DesiredCapabilities.edge();
	    WebDriver driver = new EdgeDriver(capabilities);*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\Discover\\Discover_pilot_testing_26th_sep\\Test_results.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		System.out.println(rowCount);
		driver.get("https://mcaas-pilot-discover-ui.mybluemix.net/#/welcome");
		WebDriverWait wait = new WebDriverWait(driver,150);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div/div[2]/div/div/div[2]/div/img")));
		driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div/div[2]/div/img")).click();
		WebDriverWait wait34 = new WebDriverWait(driver,150);
		wait34.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[src='https://mcaas-pilot-discover-chatbot-ui.mybluemix.net/#/chat/13']")));
		WebElement frame = driver.findElement(By.cssSelector("iframe[src='https://mcaas-pilot-discover-chatbot-ui.mybluemix.net/#/chat/13']"));
		driver.switchTo().frame(frame);
		int j=3;
		for(int i=2;i<=rowCount;i++){
			System.out.println(i);
			String input_query = xl.getCellData("Sheet1","Question",i);
			String expected = xl.getCellData("Sheet1", "Expected", i);
			String replace1 = expected.replaceAll("\\s{2,}"," ").trim().replaceAll("\"","").replaceAll(",","").trim().replaceAll(" ","");
			String exp_01 = replace1.replaceAll("(?:<style.+?>.+?</style>|<script.+?>.+?</script>|<(?:!|/?[a-zA-Z]+).*?/?>)","");
			//System.out.println(replace_01.replaceAll("\\s",""));
			//add
			File newTextFile = new File("D:\\Sudhakar_Data\\Backup\\E\\Discover\\Discover_pilot_testing_26th_sep\\Discover.txt");
            FileWriter fw;
			fw = new FileWriter(newTextFile);
			fw.write(exp_01);
            fw.close();
		    String FILENAME = "D:\\Sudhakar_Data\\Backup\\E\\Discover\\Discover_pilot_testing_26th_sep\\Discover.txt";
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
			       String replace_04 = replace2.replaceAll("\\<[^>]*>","").replaceAll("\"", "").replaceAll(",", " ");
			       String replace_05 = replace_04.replaceAll("\\s{2,}"," ").trim().replaceAll("\"", "").replaceAll(",", " ");
				    String replace_06 = replace_05.replaceAll("(?:<style.+?>.+?</style>|<script.+?>.+?</script>|<(?:!|/?[a-zA-Z]+).*?/?>)","");
			       //System.out.println(replace_06.replaceAll("\\s",""));
			       String replace_07 = replace_06.replaceAll("&nbsp;","");
			       System.out.println(replace_07);
			
			//add
			driver.findElement(By.xpath(".//*[@id='chat-app']/div[2]/div/div/div[3]/form/div[1]/div/textarea")).sendKeys(input_query);
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='chat-app']/div[2]/div/div/div[3]/form/div[1]/div/button")).click();
			try{
			long Start_time = System.currentTimeMillis();
			WebDriverWait wait1 = new WebDriverWait(driver,150);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='chat-content']/div["+j+"]/div/div[2]")));
			long End_time = System.currentTimeMillis();
			System.out.println(((End_time-Start_time)/1000+"seconds"));
			String bot_response = driver.findElement(By.xpath(".//*[@id='chat-content']/div["+j+"]/div/div[2]")).getText();
			String replace_11 = bot_response.replaceAll("\\s{2,}"," ").trim().replaceAll("\"", "").replaceAll(",", " ");
			String replace_12 = replace_11.replaceAll("(?:<style.+?>.+?</style>|<script.+?>.+?</script>|<(?:!|/?[a-zA-Z]+).*?/?>)","");
			//System.out.println(bot_response.replaceAll("\\s",""));
			System.out.println(replace_12.replaceAll("\\s",""));
			//System.out.println(i+"---"+bot_response);
			String time=((End_time-Start_time)/1000+"seconds");
			xl.setCellData("Sheet1", "Response_time", i, time);
			xl.setCellData("Sheet1", "Actual", i, bot_response);
			
			// if(replace_12.replaceAll("\\s","").contains(replace_06.replaceAll("\\s",""))){
			if(replace_12.replaceAll("\\s","").contains(replace_07.replaceAll("\\s",""))){
				xl.setCellData("Sheet1", "Result", i, "Pass");
				System.out.println("Pass");
			}
			else{
				xl.setCellData("Sheet1", "Result", i, "Fail");
			System.out.println("Fail");
			}
			
			}
			
			catch(ElementNotVisibleException e){
				
			}
			catch(NoSuchElementException e){
				
			}
			
			}
			j+=2;
		}
			
	}

	}
