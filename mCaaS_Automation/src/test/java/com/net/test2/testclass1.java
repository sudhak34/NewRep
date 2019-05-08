package com.net.test2;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.net.test1.browserclass;
import com.net.test1.login_details;

public class testclass1 {
	static WebDriver driver;
 @Test
	public static void login() throws InterruptedException{
		browserclass bw=new browserclass();
		login_details ld=new login_details(driver);
	    ld.txt_UserName("namrata.desai@happiestminds.com");
	    ld.txt_Password("Password@123");
	    ld.btn_Login();
	}
 
   
	

}
