package com.tumi.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tumi_testing {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\driver_new\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.get("https://mcaas-pilot-tumi-ui.mybluemix.net/#/welcome");

	}

}
