package com.ghost.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testclass_ghostbrowsing {

	public static void main(String[] args) throws InterruptedException {
		//WebDriver driver=new HtmlUnitDriver();
		/*String[] cli_args = new String[]{ "--ssl-protocol=any", "--ignore-ssl-errors=true", "--web-security=false" };
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		File file=new File("C:\\Program Files\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		caps.setCapability( PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cli_args );
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				file.getAbsolutePath());*/
         //WebDriver driver =new PhantomJSDriver(caps);
		//System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
		//WebDriver driver=new PhantomJSDriver(caps);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		WebElement element = driver.findElement(By.id("gb_70"));
		System.out.println(element.getText());
		WebElement element1 = driver.findElement(By.name("q"));
		element1.sendKeys("selenium");
		element1.submit();
		Thread.sleep(3000);
		String text = driver.findElement(By.id("resultStats")).getText();
		System.out.println(text);
		driver.quit();
       
	}

}
