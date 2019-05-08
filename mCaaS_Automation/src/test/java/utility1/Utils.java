package utility1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Function;

public class Utils {

	public static WebDriver driver;
	public static Properties prop;
    public static boolean bResult;
    public static String sResult = "FAILED!";
    public static String sTestSuiteName = null;
    public static String sTestCaseName = null;
    public static String sTestCaseDesc = null;
    public static final String resultOnFailure="FAILED!";
	public static final String resultOnSuccess="PASSED!";
	public static String loadingIcon = "div.spinner";
	public static SoftAssert softAssertion;
	public static final String XL_path="C:\\Users\\sudhakar.koduri\\workspace_neon\\mCaaS_Automation\\Test_data_Research.xlsx";
	
	 public static void setTestSuiteName(String sTSName)
	    {
	        sTestSuiteName = sTSName;
	    }

	    public static String getTestSuiteName()
	    {
	        return sTestSuiteName;
	    }

	    public static void setTestcaseName(String sTCName)
	    {
	        sTestCaseName = sTCName;
	    }

	    public static String getTestcaseName()
	    {
	        return sTestCaseName;
	    }
	    public static void setTestcaseDesc(String sTCDesc)
	    {
	        sTestCaseDesc = sTCDesc;
	    }

	    public static String getTestcaseDesc()
	    {
	        return sTestCaseDesc;
	    }
	    public static void setResultFlag(boolean bRes)
	    {
	        bResult = bRes;
	    }
	    public static void setResult(String sRes)
	    {
	        sResult = sRes;
	    }

	    public static String getResult()
	    {
	        return sResult;
	    }
	//fluent wait
	 // Waiting 30 seconds for an element to be present on the page, checking
	 // for its presence once every 5 seconds.
	 /*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	     .withTimeout(30, SECONDS)
	     .pollingEvery(5, SECONDS)
	     .ignoring(NoSuchElementException.class);

	 WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
	 {
	   public WebElement apply(WebDriver driver) {
	   return driver.findElement(By.id("foo"));
	 }
	 });*/
	  public static void sendemailtoteam_old(String value1,String value2,String value3,String value4,String value5,
	    		String value6,String value7,String value8,String value9,
	    		String value10,String value11,String value12,String value13,String value14,String value15,String value16,String value17,String value18,String value19,String value20,String value21,String value22,String value23) {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			StringBuilder sb = new StringBuilder();
			Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("demo.mcaas@gmail.com","happiest@123");
					}
				});

			try {

				Message message = new MimeMessage(session);
				//message.setFrom(new InternetAddress("demo.mcaas@gmail.com"));
				message.setFrom(new InternetAddress("demo.mcaas@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
				//InternetAddress.parse("qa_mcaas@happiestminds.onmicrosoft.com"+","+"Rakesh.Guttedar@happiestminds.com"+","+"prashantha.hl@happiestminds.com"+","+"sriram.hl@happiestminds.com"+","+"mallikarjuna.b@happiestminds.com"+","+"senthamizhan.p@happiestminds.com"));
				InternetAddress.parse("sudhakar.koduri@happiestminds.onmicrosoft.com"+","+"sudhakar4@gmail.com"));
				message.setSubject("FnS Daily Sanity Test Results as on -"+" "+LocalDateTime.now());
				//message.setText("FnS Daily Sanity Test Results as on -"+" "+LocalDateTime.now());
				//LocalDateTime.now(),ZonedDateTime.now()
				/*message.setContent("Dear Team," +
						"\n\n "+"Please find below the Sanity test results for production urls Rendering status "+
						"\n\n "+output+
						"\n\n"+output1+
						"\n\n"+output2+
						"\n\n"+output3,"text/html");*/
				/*message.setText("Dear Team," +
				"\n\n "+"Please find below the Sanity test results for production urls Rendering status "+
				"\n\n "+output+
				"\n\n"+output1+
				"\n\n"+output2+
				"\n\n"+output3);*/
				message.setContent("Dear Team," +
						"<p/><b>"+"Please find below Sanity Test Results for FnS Production Environment:"+"</b>"+
						"<table border ="+1+" cellpadding = "+5+" cellspacing = "+5+" bordercolor=green>"+
						"<tr>"+
						"<th bgcolor =lightblue>Test_Scenario</th>"+
						"<th bgcolor =lightblue>Test_Data</th>"+
						"<th bgcolor =lightblue>Response_Time</th>"+
						"<th bgcolor =lightblue>Result</th>"+
						"</tr>"+
						"<tr>"+
						"<td bgcolor =lightgreen rowspan = "+2+">KE</td>"+
						"<td>"+value2+"</td>"+
						"<td>"+value4+"</td>"+
						"<td>"+value18+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td>"+value3+"</td>"+
						"<td>"+value5+"</td>"+
						"<td>"+value18+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td bgcolor =lightgreen rowspan = "+2+">Aug_Search</td>"+
						"<td>"+value6+"</td>"+
						"<td>"+value8+"</td>"+
						"<td>"+value19+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td>"+value7+"</td>"+
						"<td>"+value9+"</td>"+
						"<td>"+value19+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td bgcolor =lightgreen>Full_Research_Load</td>"+
						"<td>"+value10+"</td>"+
						"<td>"+value11+"</td>"+
						"<td>"+value20+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td bgcolor =lightgreen>PDF_Download</td>"+
						"<td>"+value10+"</td>"+
						"<td>"+value13+"</td>"+
						"<td>"+value21+"</td>"+
						"</tr>"+
						"<td bgcolor =lightgreen>Vault_Image_Capture</td>"+
						"<td>"+value14+"</td>"+
						"<td>"+value15+"</td>"+
						"<td>"+value22+"</td>"+
						"</tr>"+
						"</tr>"+
						"<td bgcolor =lightgreen>Vault_PDF_Download</td>"+
						"<td>"+value14+"</td>"+
						"<td>"+value17+"</td>"+
						"<td>"+value23+"</td>"+
						"</tr>"+
						"<p/> "+"Login Status"+value1+
						"<p/><b>"+"Knowledge Engine Test Results:"+"</b>"+
						"<p/> "+"KE Input Keyword1:"+value2+
						"<p/>"+"Response Time:"+value4+
						"<p/>"+"KE Input Keyword2:"+value3+
						"<p/>"+"Response Time:"+value5+
						"<p/><b>"+"Aug Search Test Results:"+"</b>"+
						"<p/>"+"Aug search keyword1:"+value6+
						"<p/>"+"Response time:"+value8+
						"<p/>"+"Aug search keyword2:"+value7+
						"<p/>"+"Response time:"+value9+
						"<p/><b>"+"Research Loading and PDF Download in Research Page Test Results:"+"</b>"+
						"<p/> "+"AssetID:"+value10+
						"<p/>"+"Full Research Loading Time:"+value11+
						"<p/>"+"PDF File Successfully Downloaded:"+value12+
						"<p/>"+"Time Taken for Research PDF to get Downloaded:"+value13+
						"<p/><b>"+"VAULT Test Results:"+"</b>"+
						"<p/> "+"AssetID:"+value14+
						"<p/>"+"Time Taken for Image to get saved to VAULT:"+value15+
						"<p/> "+"VAULT PDF Successfully Downloaded:"+value16+
						//"<p/>"+"Time Taken for VAULT PDF to get Downloaded:"+value17+
						"</table>"+""+"",
						"text/html");
				
				Transport.send(message);
				System.out.println("Mail sent");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}  
	    
	    public static void sendemailtoteam(String value10,String value11,String value12,String value13,String value14,String value15,
	    		String value16,String value17,String value18) {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			StringBuilder sb = new StringBuilder();
			Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("fnsdailysanitycheck@gmail.com","Happiest@123");
					}
				});

			try {

				Message message = new MimeMessage(session);
				//message.setFrom(new InternetAddress("demo.mcaas@gmail.com"));
				message.setFrom(new InternetAddress("fnsdailysanitycheck@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
				//InternetAddress.parse("qa_mcaas@happiestminds.onmicrosoft.com"+","+"Rakesh.Guttedar@happiestminds.com"+","+"prashantha.hl@happiestminds.com"+","+"sriram.hl@happiestminds.com"+","+"mallikarjuna.b@happiestminds.com"+","+"senthamizhan.p@happiestminds.com"));
				InternetAddress.parse("sudhakar.koduri@happiestminds.onmicrosoft.com"+","+"sudhakar4@gmail.com"));
						/*InternetAddress.parse("sudhakar.koduri@happiestminds.onmicrosoft.com"+","
								+"srividya.s@happiestminds.onmicrosoft.com"+","
								+"sandeep.mn@happiestminds.onmicrosoft.com"+","
								+"pruthvi.c@happiestminds.onmicrosoft.com"+","
								+"Geeta.Bagewadi@happiestminds.onmicrosoft.com"+","
								+"nagaraj.ambig@happiestminds.onmicrosoft.com"+","
								+"Ganavi.YV@happiestminds.onmicrosoft.com"));
				message.setSubject("FnS Daily Sanity Test Results as on -"+" "+LocalDateTime.now());*/
				/*message.addRecipient(Message.RecipientType.CC, InternetAddress.parse("abc@abc.com"));
				message.addRecipient(Message.RecipientType.CC, InternetAddress.parse("abc@def.com"));
				message.addRecipient(Message.RecipientType.CC, InternetAddress.parse("ghi@abc.com"));*/
						
				/*InternetAddress.parse("Ganavi.YV@happiestminds.onmicrosoft.com"
						+","+"Geeta.Bagewadi@happiestminds.onmicrosoft.com"+","+"nagaraj.ambig@happiestminds.onmicrosoft.com"+","+"Pradeep.MS@happiestminds.onmicrosoft.com"+","+"pramila.sasnoor@happiestminds.onmicrosoft.com"+","+"pruthvi.c@happiestminds.onmicrosoft.com"
						+","+"sandeep.mn@happiestminds.onmicrosoft.com"+","+"sudhakar.koduri@happiestminds.onmicrosoft.com"
						));
				message.setRecipients(Message.RecipientType.CC,
						InternetAddress.parse("srividya.s@happiestminds.onmicrosoft.com"));
						*/
				//InternetAddress.parse("sudhakar.koduri@happiestminds.onmicrosoft.com"+","+"sudhakar4@gmail.com"));
				message.setSubject("FnS Full Research Loading Test Results as on -"+" "+LocalDateTime.now());
				message.setContent("Dear Team," +
						"<p/><b>"+"Please find below Test Results for FnS Full Research Loading scenario in Production Environment:"+"</b>"+
						"<table border ="+1+" cellpadding = "+5+" cellspacing = "+5+" bordercolor=green>"+
						"<tr>"+
						"<th bgcolor =lightblue>Test_Scenario</th>"+
						"<th bgcolor =lightblue>Test_Data</th>"+
						"<th bgcolor =lightblue>Response_Time</th>"+
						"<th bgcolor =lightblue>Result</th>"+
						"</tr>"+
						/*"<tr>"+
						"<td bgcolor =lightgreen rowspan = "+2+">KE</td>"+
						"<td>"+value2+"</td>"+
						"<td>"+value4+"</td>"+
						"<td>"+value18+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td>"+value3+"</td>"+
						"<td>"+value5+"</td>"+
						"<td>"+value18+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td bgcolor =lightgreen rowspan = "+2+">Aug_Search</td>"+
						"<td>"+value6+"</td>"+
						"<td>"+value8+"</td>"+
						"<td>"+value19+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td>"+value7+"</td>"+
						"<td>"+value9+"</td>"+
						"<td>"+value19+"</td>"+
						"</tr>"+*/
						"<tr>"+
						"<td bgcolor =lightgreen rowspan = "+3+">Full_Research_Load</td>"+
						"<td>"+value10+"</td>"+
						"<td>"+value11+"</td>"+
						"<td>"+value12+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td>"+value13+"</td>"+
						"<td>"+value14+"</td>"+
						"<td>"+value15+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td>"+value16+"</td>"+
						"<td>"+value17+"</td>"+
						"<td>"+value18+"</td>"+
						"</tr>"+
						/*"<tr>"+
						"<td bgcolor =lightgreen>PDF_Download</td>"+
						"<td>"+value10+"</td>"+
						"<td>"+value13+"</td>"+
						"<td>"+value21+"</td>"+
						"</tr>"+
						"<td bgcolor =lightgreen>Vault_Image_Capture</td>"+
						"<td>"+value14+"</td>"+
						"<td>"+value15+"</td>"+
						"<td>"+value22+"</td>"+
						"</tr>"+
						"</tr>"+
						"<td bgcolor =lightgreen>Vault_PDF_Download</td>"+
						"<td>"+value14+"</td>"+
						"<td>"+value17+"</td>"+
						"<td>"+value23+"</td>"+
						"</tr>"+*/
						/*"<p/> "+"Login Status"+value1+
						"<p/><b>"+"Knowledge Engine Test Results:"+"</b>"+
						"<p/> "+"KE Input Keyword1:"+value2+
						"<p/>"+"Response Time:"+value4+
						"<p/>"+"KE Input Keyword2:"+value3+
						"<p/>"+"Response Time:"+value5+
						"<p/><b>"+"Aug Search Test Results:"+"</b>"+
						"<p/>"+"Aug search keyword1:"+value6+
						"<p/>"+"Response time:"+value8+
						"<p/>"+"Aug search keyword2:"+value7+
						"<p/>"+"Response time:"+value9+
						"<p/><b>"+"Research Loading and PDF Download in Research Page Test Results:"+"</b>"+
						"<p/> "+"AssetID:"+value10+
						"<p/>"+"Full Research Loading Time:"+value11+
						"<p/>"+"PDF File Successfully Downloaded:"+value12+
						"<p/>"+"Time Taken for Research PDF to get Downloaded:"+value13+
						"<p/><b>"+"VAULT Test Results:"+"</b>"+
						"<p/> "+"AssetID:"+value14+
						"<p/>"+"Time Taken for Image to get saved to VAULT:"+value15+
						"<p/> "+"VAULT PDF Successfully Downloaded:"+value16+*/
						//"<p/>"+"Time Taken for VAULT PDF to get Downloaded:"+value17+
						"</table>"+""+"",
						"text/html");
				
				Transport.send(message);
				System.out.println("Mail sent");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}  


	    /*public static void sendemailtoteam_Researchload(String value10,String value11,String value13,String value20,String value21) {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			StringBuilder sb = new StringBuilder();
			Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("demo.mcaas@gmail.com","happiest@123");
					}
				});

			try {

				Message message = new MimeMessage(session);
				//message.setFrom(new InternetAddress("demo.mcaas@gmail.com"));
				message.setFrom(new InternetAddress("demo.mcaas@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
				//InternetAddress.parse("qa_mcaas@happiestminds.onmicrosoft.com"+","+"Rakesh.Guttedar@happiestminds.com"+","+"prashantha.hl@happiestminds.com"+","+"sriram.hl@happiestminds.com"+","+"mallikarjuna.b@happiestminds.com"+","+"senthamizhan.p@happiestminds.com"));
				InternetAddress.parse("sudhakar.koduri@happiestminds.onmicrosoft.com"+","+"sudhakar4@gmail.com"));
				message.setSubject("FnS Daily Sanity Test Results as on -"+" "+LocalDateTime.now());
				//message.setText("FnS Daily Sanity Test Results as on -"+" "+LocalDateTime.now());
				//LocalDateTime.now(),ZonedDateTime.now()
				message.setContent("Dear Team," +
						"\n\n "+"Please find below the Sanity test results for production urls Rendering status "+
						"\n\n "+output+
						"\n\n"+output1+
						"\n\n"+output2+
						"\n\n"+output3,"text/html");
				message.setText("Dear Team," +
				"\n\n "+"Please find below the Sanity test results for production urls Rendering status "+
				"\n\n "+output+
				"\n\n"+output1+
				"\n\n"+output2+
				"\n\n"+output3);
				message.setContent("Dear Team," +
						"<p/><b>"+"Please find below Research Load & Download Test Results of FnS Production Environment:"+"</b>"+
						"<table border ="+1+" cellpadding = "+5+" cellspacing = "+5+" bordercolor=green>"+
						"<tr>"+
						"<th bgcolor =lightblue>Test_Scenario</th>"+
						"<th bgcolor =lightblue>Test_Data</th>"+
						"<th bgcolor =lightblue>Response_Time</th>"+
						"<th bgcolor =lightblue>Result</th>"+
						"</tr>"+
						"<tr>"+
						"<td bgcolor =lightgreen rowspan = "+2+">KE</td>"+
						"<td>"+value2+"</td>"+
						"<td>"+value4+"</td>"+
						"<td>"+value18+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td>"+value3+"</td>"+
						"<td>"+value5+"</td>"+
						"<td>"+value18+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td bgcolor =lightgreen rowspan = "+2+">Aug_Search</td>"+
						"<td>"+value6+"</td>"+
						"<td>"+value8+"</td>"+
						"<td>"+value19+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td>"+value7+"</td>"+
						"<td>"+value9+"</td>"+
						"<td>"+value19+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td bgcolor =lightgreen>Full_Research_Load</td>"+
						"<td>"+value10+"</td>"+
						"<td>"+value11+"</td>"+
						"<td>"+value20+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td bgcolor =lightgreen>PDF_Download</td>"+
						"<td>"+value10+"</td>"+
						"<td>"+value13+"</td>"+
						"<td>"+value21+"</td>"+
						"</tr>"+
						"<td bgcolor =lightgreen>Vault_Image_Capture</td>"+
						"<td>"+value14+"</td>"+
						"<td>"+value15+"</td>"+
						"<td>"+value22+"</td>"+
						"</tr>"+
						"</tr>"+
						"<td bgcolor =lightgreen>Vault_PDF_Download</td>"+
						"<td>"+value14+"</td>"+
						"<td>"+value17+"</td>"+
						"<td>"+value23+"</td>"+
						"</tr>"+
						"<p/> "+"Login Status"+value1+
						"<p/><b>"+"Knowledge Engine Test Results:"+"</b>"+
						"<p/> "+"KE Input Keyword1:"+value2+
						"<p/>"+"Response Time:"+value4+
						"<p/>"+"KE Input Keyword2:"+value3+
						"<p/>"+"Response Time:"+value5+
						"<p/><b>"+"Aug Search Test Results:"+"</b>"+
						"<p/>"+"Aug search keyword1:"+value6+
						"<p/>"+"Response time:"+value8+
						"<p/>"+"Aug search keyword2:"+value7+
						"<p/>"+"Response time:"+value9+
						"<p/><b>"+"Research Loading and PDF Download in Research Page Test Results:"+"</b>"+
						"<p/> "+"AssetID:"+value10+
						"<p/>"+"Full Research Loading Time:"+value11+
						"<p/>"+"PDF File Successfully Downloaded:"+value12+
						"<p/>"+"Time Taken for Research PDF to get Downloaded:"+value13+
						"<p/><b>"+"VAULT Test Results:"+"</b>"+
						"<p/> "+"AssetID:"+value14+
						"<p/>"+"Time Taken for Image to get saved to VAULT:"+value15+
						"<p/> "+"VAULT PDF Successfully Downloaded:"+value16+
						//"<p/>"+"Time Taken for VAULT PDF to get Downloaded:"+value17+
						"</table>"+""+"",
						"text/html");
				
				Transport.send(message);
				System.out.println("Mail sent");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}  
	    */
	    
	    
    public static void waitForPageLoad()
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(new Function<WebDriver, Boolean>(){
        	
            public Boolean apply(WebDriver driver)
            {
                return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }
	
    public static boolean waitFor(int iSeconds)
    {
        try
        {
            Thread.sleep(iSeconds * 1000);
        }
        catch (Exception e)
        {
        	System.out.println("Not able to Wait --- " + e.getMessage());
            //Log.error("Not able to Wait --- " + e.getMessage());
            return false;
        }
        return true;
    }
    
    public static boolean waitForInvisibilityOfElement(int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Boolean isElementPresent = wait
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loadingIcon)));
        return isElementPresent;
    }
     public static void waitforinvisibilityOfElementlocated(WebElement element){
    	 WebDriverWait wait = new WebDriverWait(driver , 60);
         wait.until(ExpectedConditions.visibilityOf(element)); 
     }
     public static void waitforinvisibilityOfElement_KEloadingicon(WebElement element){
    	 WebDriverWait wait = new WebDriverWait(driver , 60);
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[contains(@class,'loader-anim bot')]/i[4]/span[text() ='Searching...']"))); 
     }
    public static void waitForElementVisible(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver , 60);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public static void waitForElementsVisible(List<WebElement> element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    
    
	@BeforeClass
	public void launchUrl() throws IOException{
	    //DOMConfigurator is used to configure logger from xml configuration file
		DOMConfigurator.configure("log4j.xml");
		String sProjectPath = System.getProperty("user.dir");
		File file = new File(System.getProperty("user.dir")+"\\configuration\\config.properties");
    	FileInputStream fileInput = new FileInputStream(file);
    	prop = new Properties();
    	prop.load(fileInput);
    	 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sudhakar.koduri\\workspace_neon\\mCaaS_Automation\\SetupFiles\\chromedriver.exe");
		/*ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
	 	chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);*/
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("loginUrl"));
	}
	
	@BeforeMethod
	public static void softAssert(){
		softAssertion= new SoftAssert();
	}
	
	@AfterClass
	public static void destroy(){
		
		//if(prop.getProperty("browserClose").equalsIgnoreCase("yes")) {
			driver.quit();
		//}
	}	
	
	protected static File getLatestFilefromDir(String dirPath){
 	    File dir = new File(dirPath);
 	    File[] files = dir.listFiles();
 	    if (files == null || files.length == 0) {
 	        return null;
 	    }
 	
 	    File lastModifiedFile = files[0];
 	    for (int i = 1; i < files.length; i++) {
 	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
 	           lastModifiedFile = files[i];
 	       }
 	    }
 	    return lastModifiedFile;
 	}
	
	
	
	public static void selectDropdownItem(List<WebElement> elements, String sListItem)
    {
        java.util.Iterator<WebElement> i = elements.iterator();
        while (i.hasNext())
        {
            WebElement row = i.next();
            // System.out.println(row.getText());
            if (row.getText().equals(sListItem))
            {
                row.click();
                break;
            }
        }
    }


}
