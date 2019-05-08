package com.mcaas.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DQAchatbot_pom {
	public WebDriver driver;
	public int j;
	public DQAchatbot_pom(WebDriver driver){
		this.driver=driver;
	}
	public void browser_close(){
		driver.close();
	}
	public void geturl() throws InterruptedException{
		driver.get("http://mcaas-demo-dqa-ui-v3.mybluemix.net/#/DigitalQueryAssistant");
		Thread.sleep(5000);
	}
	public void click_login_linktext(){
		driver.findElement(By.linkText("LOGIN")).click();
	}
	public void enter_username(String username){
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div/div[2]/div/div[2]/div[1]/form/div[1]/div/input")).sendKeys(username);
	}
    public void enter_password(String password){
    driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div/div[2]/div/div[2]/div[1]/form/div[2]/div/input")).sendKeys(password);
	}
    public void click_login_button(){
    driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div/div[2]/div/div[2]/div[1]/form/div[4]/div/div/input")).click();
	}
    public void click_chatbot(){
    driver.findElement(By.id("virtualChatbotId")).click();	
    }
    public void chat_textinput(String inputchat){
    	 driver.findElement(By.xpath("html/body/div[1]/div/div/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/form/div[1]/div/textarea")).sendKeys(inputchat);
    	                               
    }
    public void chatbutton_click(){
    	driver.findElement(By.id("chatTextSubmit")).click();
    }
    public String replytext_chat(){
    	return driver.findElement(By.xpath("//div/div/div[2]/div[1]/div[" +j+ "]/div/div/p")).getText();
    }
    public void click_search_icon(){
    	driver.findElement(By.xpath("/html/body/div/div/div/div[2]/nav/a[1]/img")).click();
    }
    public void click_Select_source(){
    	driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div[1]/form/div/div[3]/div[1]/input")).click();
    }
    public void select_sourcevalue_fromdropdown(){
    	driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div[1]/form/div/div[1]/div[3]/div[2]/label/div")).click();
    }
    public void clear_input_searchvalue(){
     driver.findElement(By.id("inputSearchValue")).clear();
	    }
    public void enter_input_searchvalue(String input){
        driver.findElement(By.id("inputSearchValue")).sendKeys(input);
   	    }
    public void click_search_aftersearchinputprovided(){
    	driver.findElement(By.className("glyphicon-search")).click();
    }
    public void click_getmoresearchresults(){
    	driver.findElement(By.id("gtMoreTxtBtn")).click();
    }
    public String search_result(){
    	return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[3]/div/div/div[2]/div[2]/div[3]/div[2]/div[4]")).getText();
    }
}
