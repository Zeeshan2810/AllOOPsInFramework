package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	//page locators define by By class and define private
	
	private By emailid = By.id("username");
	private By password = By.id("password");
	private By signButton = By.id("loginBtn");
	private By header = By.xpath("//i18n-string[@data-key='login.signupLink.text']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//public getters of all private locators;

	
	public WebElement getEmailid() {
		return getElement(emailid);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getSignButton() {
		return getElement(signButton);
	}

	public WebElement getHeader() {
		return getElement(header);
	}

	
	public String getLoginPageTitle() {
		
		return getPageTitle();
		}
	public String getLoginPageHeader() {
		
		return getPageHeader(header);
	}
	
	
	public HomePage doLogin(String username, String pwd) {
		
		getEmailid().sendKeys(username);
		getPassword().sendKeys(pwd);
		getSignButton().click();
		
		return getInstance(HomePage.class);
		
	}
	
	public void doLogin() {
		
		getEmailid().sendKeys("");
		getPassword().sendKeys("");
		getSignButton().click();		
		
	}


	
	

}
