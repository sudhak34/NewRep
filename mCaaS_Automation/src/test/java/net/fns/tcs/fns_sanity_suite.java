package net.fns.tcs;

import java.io.File;

import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import net.fns.pages.Aug_Search;
import net.fns.pages.KE_Test;
import net.fns.pages.Pg_Login;
import net.fns.pages.Reserach_Load_Pdf_download;
import net.fns.pages.Vault_feature_check;
import utility1.Log;
import utility1.Utils;

public class fns_sanity_suite extends Utils { 
	static Pg_Login login;
	static KE_Test KE_execution_Obj;
	static Aug_Search AUg_search_Obj;
	static Reserach_Load_Pdf_download PDF_Res_obj;
	static Vault_feature_check vault_res_obj;
	static String KE_Status;
	static String Aug_search_Status;
	
	@Test(priority = 1)
	public static void login() throws Throwable{
		try{
			String sTestName = "Login";
			String sTestDesc = "To Validate Login Functionality";

			Utils.setTestcaseName("Verify_" + sTestName);
			Utils.setTestcaseDesc("Test : " + sTestDesc);
			Utils.setResultFlag(true);
			login = new Pg_Login(driver);
			login.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
			waitForInvisibilityOfElement(60);
			//KE_execution_Obj = new KE_Test(driver);
			Utils.setResult(Utils.resultOnSuccess);
			
			
		}catch (Throwable e) {
			Log.error(e.getMessage());
			e.printStackTrace();
			Utils.setResult(Utils.resultOnFailure);
			throw e;
			
		}
		finally {
			Log.endTestCase(Utils.getTestcaseName(), Utils.getResult());
			Reporter.log("Status of the " + Utils.getTestcaseName() + " is : " + Utils.getResult());
			System.out.println("Status of the " + Utils.getTestcaseDesc() + " is : " + Utils.getResult());
		}
		
			
}
	
	@Test(priority = 2)
	public static void KEresposnecheck() throws Throwable{
		KE_execution_Obj = new KE_Test(driver);
		try{
			String sTestName = "KE Response check";
			String sTestDesc = "To Validate KE response time";

			Utils.setTestcaseName("Verify_" + sTestName);
			Utils.setTestcaseDesc("Test : " + sTestDesc);
			Utils.setResultFlag(true);
			KE_execution_Obj.KE_Response_method();
			Utils.setResult(Utils.resultOnSuccess);
			softAssertion.assertTrue(true);
			softAssertion.assertAll();
			KE_Status="<span style=color:green>Pass</span>";
			
		}catch (Throwable e) {
			KE_Status="<span style=color:red>Fail</span>";
			Log.error(e.getMessage());
			e.printStackTrace();
			Utils.setResult(Utils.resultOnFailure);
			throw e;
			
		}finally {
			Log.endTestCase(Utils.getTestcaseName(), Utils.getResult());
			Reporter.log("Status of the " + Utils.getTestcaseName() + " is : " + Utils.getResult());
			System.out.println("Status of the " + Utils.getTestcaseDesc() + " is : " + Utils.getResult());
		}
		
}

	@Test(priority = 3)
	public static void  Augsearchsposnecheck() throws Throwable{
		AUg_search_Obj= new Aug_Search(driver);
		try{
			String sTestName = "Aug search Response check";
			String sTestDesc = "To Validate Aug search response time";
			Utils.setTestcaseName("Verify_" + sTestName);
			Utils.setTestcaseDesc("Test : " + sTestDesc);
			Utils.setResultFlag(true);
			AUg_search_Obj.Aug_search_results();
			Utils.setResult(Utils.resultOnSuccess);
			softAssertion.assertTrue(true);
			softAssertion.assertAll();
			Aug_search_Status="<span style=color:green>Pass</span>";
			
		}catch (Throwable e) {
			Aug_search_Status="<span style=color:red>Fail</span>";
			Log.error(e.getMessage());
			e.printStackTrace();
			Utils.setResult(Utils.resultOnFailure);
			throw e;
		}finally {
			Log.endTestCase(Utils.getTestcaseName(), Utils.getResult());
			Reporter.log("Status of the " + Utils.getTestcaseName() + " is : " + Utils.getResult());
			System.out.println("Status of the " + Utils.getTestcaseDesc() + " is : " + Utils.getResult());
		}
		
	}
	@Test(priority = 4)
	public static void  PDFdownloadnResearchload() throws Throwable{
		 PDF_Res_obj= new Reserach_Load_Pdf_download(driver);
		try{
			String sTestName = "Reserach loading Response check";
			String sTestDesc = "To Validate Reserach_loading and PDF download response time";
			Utils.setTestcaseName("Verify_" + sTestName);
			Utils.setTestcaseDesc("Test : " + sTestDesc);
			Utils.setResultFlag(true);
			PDF_Res_obj.download_pdf_researchrender();
			/*waitFor(30);
			File getLatestFile = getLatestFilefromDir("C:\\Users\\sudhakar.koduri\\Downloads");
			String fileName = getLatestFile.getName();
			System.out.println(fileName);*/
			Utils.setResult(Utils.resultOnSuccess);
			softAssertion.assertTrue(true);
			softAssertion.assertAll();
					
		}catch (Throwable e) {
			Log.error(e.getMessage());
			e.printStackTrace();
			Utils.setResult(Utils.resultOnFailure);
			throw e;
		}finally {
			Log.endTestCase(Utils.getTestcaseName(), Utils.getResult());
			Reporter.log("Status of the " + Utils.getTestcaseName() + " is : " + Utils.getResult());
			System.out.println("Status of the " + Utils.getTestcaseDesc() + " is : " + Utils.getResult());
		}
		
	}
	
	@Test(priority = 5)
	public static void Vaultposnecheck() throws Throwable{
		vault_res_obj = new Vault_feature_check(driver);
		try{
			String sTestName = "Vault Response check";
			String sTestDesc = "To Validate Vault response time";

			Utils.setTestcaseName("Verify_" + sTestName);
			Utils.setTestcaseDesc("Test : " + sTestDesc);
			Utils.setResultFlag(true);
			vault_res_obj.Vault_feature_Testing();
			/*waitFor(30);
			File getLatestFile = getLatestFilefromDir("C:\\Users\\sudhakar.koduri\\Downloads");
			String fileName = getLatestFile.getName();
			System.out.println(fileName);*/
			Utils.setResult(Utils.resultOnSuccess);
			softAssertion.assertTrue(true);
			softAssertion.assertAll();
			
		}catch (Throwable e) {
			Log.error(e.getMessage());
			e.printStackTrace();
			Utils.setResult(Utils.resultOnFailure);
			throw e;
		}finally {
			Log.endTestCase(Utils.getTestcaseName(), Utils.getResult());
			Reporter.log("Status of the " + Utils.getTestcaseName() + " is : " + Utils.getResult());
			System.out.println("Status of the " + Utils.getTestcaseDesc() + " is : " + Utils.getResult());
		}
		
	}
	@Test(priority = 6)
	public static void sendemail(){
		fns_sanity_suite.sendemailtoteam_old(login.login_homepage,KE_execution_Obj.KE_Keyword_01,KE_execution_Obj.KE_Keyword_02,KE_execution_Obj.KE_Keyword_01_response,KE_execution_Obj.KE_Keyword_02_response,
				AUg_search_Obj.Aug_Keyword_01,AUg_search_Obj.Aug_Keyword_02,AUg_search_Obj.Aug_Keyword_01_response,AUg_search_Obj.Aug_Keyword_02_response,
				PDF_Res_obj.AssetID_01,PDF_Res_obj.Research_loadtime_01,PDF_Res_obj.pdf_filename,PDF_Res_obj.PDF_download_time,
				vault_res_obj.vault_AssetID,vault_res_obj.Vault_image_grabtime,vault_res_obj.Vault_pdf_filename,vault_res_obj.vault_PDF_download_time,KE_Status,Aug_search_Status,PDF_Res_obj.Research_load_02,PDF_Res_obj.PDF_Download,vault_res_obj.Vault_Image_capture,vault_res_obj.Vault_PDF_Download);
	}
	
	}