package com.orangeHRM.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.mainbase.Constants;
import com.orangeHRM.mainbase.MainBase;
import com.orangeHRM.pages.AdminLoginPage;

public class AdminLoginTest {
	
	MainBase mainBase = new MainBase();
	AdminLoginPage adminLogin;
	
	@BeforeClass
	public void initiaizingBrowser() {
		MainBase.openBrowser(Constants.prop.getProperty("browser"));
		MainBase.maximize();
		MainBase.deleteAllCookies();
		MainBase.launchUrl(Constants.prop.getProperty("url"));
		MainBase.impilicitWait();
		adminLogin=PageFactory.initElements(Constants.driver, AdminLoginPage.class);
		
	}
	
	@Test
	public void loginWithValidCredentials() {
		
		adminLogin.executeLoginFlow(Constants.prop.getProperty("username"), Constants.prop.getProperty("password"));
	}
	
	@AfterTest
	public void closeBrowser() {
		MainBase.tearDown();
	}

}
