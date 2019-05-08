package com.test.session;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_session_02 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://www.sbi.co.in/portal/web/home/emi-calculator");
		String expected_result="7500";
		//driver.findElement(By.name("uamount")).sendKeys("100000");
		driver.findElement(By.xpath("//div/div/div/div[1]/div/form/table/tbody/tr[2]/td[1]/p[1]/input")).sendKeys("100000");
		//driver.findElement(By.name("uTime")).sendKeys("12");
		driver.findElement(By.cssSelector("input[name='uTime'][class='textbox']")).sendKeys("12");
        driver.findElement(By.name("uRate")).sendKeys("14");
        driver.findElement(By.xpath(".//*[@id='content-area']/form/table/tbody/tr[3]/td/p/input[1]")).click();
        String actual_value = driver.findElement(By.name("uEmi")).getAttribute("value");
        System.out.println(actual_value);
        driver.close();
        if(actual_value.equals(expected_result)){
        	System.out.println("Pass");
        }
        else{
        	System.out.println("Fail");
        }
	}

}
