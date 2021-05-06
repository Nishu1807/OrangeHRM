package com.orangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orangeHRM.mainbase.Constants;

public class AdminLoginPage {
	
	@FindBy(xpath="//input[@id='txtUsername']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginButton;
	
	@FindBy(xpath="//li[@class='page-title']")
	WebElement title;
	
	
	public void enterUsernameOnTextbox(String username) {
		userName.click();
		userName.clear();
		userName.sendKeys(username);
	}
	
	public void enterPasswordOnTextbox(String passwrd) {
		password.click();
		password.clear();
		password.sendKeys(passwrd);
		
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void executeLoginFlow(String username,String passwrd) {
		enterUsernameOnTextbox(username);
		enterPasswordOnTextbox(passwrd);
		clickOnLoginButton();
	}

	public String getTitle() {
		title.isDisplayed();
		return Constants.driver.getTitle();
	}
}
