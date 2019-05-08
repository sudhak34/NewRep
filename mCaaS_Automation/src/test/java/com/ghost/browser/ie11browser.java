package com.ghost.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ie11browser {

	public static void main(String[] args) throws InterruptedException {
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		//caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		caps.setCapability("EnableNativeEvents", false);
		caps.setCapability("ignoreZoomSetting", true);
		System.setProperty("webdriver.ie.driver","D:\\driver\\New folder\\IEDriverServer.exe");
	    WebDriver driver = new ChromeDriver(caps);
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	   // driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));

     	driver.get("https://memberuat.frost.com");
		//driver.navigate().to("https://memberuat.frost.com");

	}

}
