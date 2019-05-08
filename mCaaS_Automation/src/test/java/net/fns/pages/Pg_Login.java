package net.fns.pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility1.Utils;



public class Pg_Login extends Utils{
	public String login_homepage;
	public WebDriver driver;
	String url = prop.getProperty("loginUrl");
	
	public Pg_Login(WebDriver driver){
		this.driver=driver;
		Assert.assertEquals(prop.getProperty("loginUrl"), driver.getCurrentUrl());
		System.out.println("Assertion passed - Login Page");
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="emailid")
    public WebElement txt_UserName;
	
	@FindBy(id="password")
    public WebElement txt_Password;
	
	@FindBy(id="login")
    public WebElement btn_Login;

	@FindBy(xpath="html/body/div[6]/div[1]/nav/div/div[1]/div/div[1]/a/img")
	public WebElement FnS_logo;
	  
	public void loginDetails(String userName, String password){
		try{
		Utils.waitForInvisibilityOfElement(60);
		waitForElementVisible(txt_UserName);
		txt_UserName.clear();
		txt_UserName.sendKeys(userName);
		waitForElementVisible(txt_Password);
		txt_Password.clear();
		txt_Password.sendKeys(password);
		waitForElementVisible(btn_Login);
		waitFor(5);
		btn_Login.click();
		Utils.waitForInvisibilityOfElement(60);
		Utils.waitForElementVisible(FnS_logo);
		System.out.println(FnS_logo.getText());
		login_homepage="<span style=color:green>"+FnS_logo.getText()+"-PASS </span>";
		//"<span style=color:green> Basic Mindfields Report has rendered successfully - PASS </span> "
		}
		catch(Exception e){
			login_homepage="<span style=color:red>"+FnS_logo.getText()+"-Fail </span>";
		 }
		}
	
	  
}
