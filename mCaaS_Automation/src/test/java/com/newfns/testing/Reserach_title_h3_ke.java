package com.newfns.testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;



public class Reserach_title_h3_ke {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://research.frost.com/#/assets/1/41ad4ebc-ec8f-11e7-8152-22b9eb655397/daea6f02-7d99-11e7-9fa1-22b9eb655397/research?eui=ee4d8eb6-c2e1-11e7-9cf0-22b9eb655397&pagename=recommended");
		Thread.sleep(30000);
		//long startTime = System.currentTimeMillis();
		try{
		//boolean displayed = driver.findElement(By.xpath("html/body/div[3]/div/div[13]/div/span")).isDisplayed();
		Boolean displayed = driver.findElements(By.xpath("html/body/div[3]/div/div[13]/div/span")).size() > 0;
		//while(displayed==true||(System.currentTimeMillis()-startTime)<5000){
		  while(displayed==true){
		  if(displayed==false){
				  break;
			  }
		   	}
		}
		catch(Exception e){
			
		}
		List<WebElement> element = driver.findElements(By.xpath("//div[1]/h3"));
		for(WebElement x:element){
			 //System.out.println(x.getSize());
			//System.out.println(x.getCssValue("color"));
			String color = x.getCssValue("color");
			String Hex = Color.fromString(color).asHex();
			System.out.println(Hex);
			if(Hex.equals("#01172f")){
			System.out.println("Black");
			}
			else if (Hex.equals("#119da4")) {
				System.out.println("Blue");
			}
			else{
				
			}
			/*String cssValue_color = x.getCssValue("color");
			String hex = cssValue_color.fromString(cssValue_color).asHex();
			System.out.println(hex);*/
			String h3 = x.getText();
			System.out.println(h3);
			
		}

	}

}
