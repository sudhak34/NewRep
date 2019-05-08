package com.mcaas.genericlibraries;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshots {
	public static WebDriver captureScreenshots1(WebDriver driver, String page) throws Exception
	{
		/*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("E:\\screenshot.png"));*/
		String path =(System.getProperty("user.dir")+"\\screenshots\\"+page+".png");
		System.out.println(path);
		WebDriver browser = driver; 
		TakesScreenshot scr = (TakesScreenshot)browser;
		File screenshotAs = scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(path));
		return driver;
	}
}
