package com.orangeHRM.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangeHRM.mainbase.Constants;
import com.orangeHRM.mainbase.MainBase;
import com.orangeHRM.pages.AdminLoginPage;
import com.orangeHRM.utility.TestUtil;

public class AdminLoginTest {
	
	MainBase mainBase = new MainBase();
	AdminLoginPage adminLogin;
	
	@BeforeMethod
	public void initiaizingBrowser() {
		MainBase.openBrowser(Constants.prop.getProperty("browser"));
		MainBase.maximize();
		MainBase.deleteAllCookies();
		MainBase.launchUrl(Constants.prop.getProperty("url"));
		MainBase.impilicitWait();
		adminLogin=PageFactory.initElements(Constants.driver, AdminLoginPage.class);
		
	}
	
	@DataProvider(name = "InvalidTestData")
	public Object[][] getData(){
			return TestUtil.getInvalidTestDataFromExcel();
	}
	
	@Test(priority=1, dataProvider = "InvalidTestData")
	public void loginWithInvalidCredentials(String Username, String Password) {
		adminLogin.executeLoginFlow(Username, Password);
	}
	
	@Test(priority=2)
	public void loginWithValidCredentials() {
		
		adminLogin.executeLoginFlow(Constants.prop.getProperty("username"), Constants.prop.getProperty("password"));
		String title = adminLogin.getTitle();
		Assert.assertEquals(title, "Dashboard");
	}
	
	@AfterMethod
	public void closeBrowser() {
		MainBase.tearDown();
	}

}
