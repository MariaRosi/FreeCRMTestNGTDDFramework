package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBaseClass;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	
	//constructor
	//call the parent class TestBaseClass constructor so the properties file can be read
	public LoginPageTest() {
		super();
		System.out.println("Prog : LoginPageTest and Constructor : LoginPageTest");
	}

	//Call the initializeBaseClass method of parent class TestBaseClass so that driver can be initialized
	@BeforeMethod
	public void setUp() {
		System.out.println("Prog : LoginPageTest and Method : setUp");
		initializeBaseClass();
		
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1) 
	public void loginPageTitleTest() {
		System.out.println("Prog : LoginPageTest and Method : loginPageTitleTest");
		String sLoginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(sLoginPageTitle,"Free CRM in the cloud software boosts sales");
		
	}
	
	@Test(priority=2)
	public void loginPageFreeCRMLogoTest() {
		System.out.println("Prog : LoginPageTest and Method : loginPageFreeCRMLogoTest");
		boolean isDisplayedLogo = loginPage.isDisplayedFreeCRMLogo();
		Assert.assertTrue(isDisplayedLogo);
	}
	
	
	@Test(priority=3)
	public void doLoginTest() throws Exception {
		System.out.println("Prog : LoginPageTest and Method : doLoginTest");
		String sUserName = prop.getProperty("username");
		String sUserPwd = prop.getProperty("password");
		
		System.out.println("User name = "+sUserName);
		System.out.println("User name = "+sUserPwd);
		
		homePage = loginPage.doLogin(sUserName,sUserPwd);
		
	}
	
		
	@AfterMethod
	public void tearDown() {
		System.out.println("Prog : LoginPageTest and Method : tearDown");
		driver.quit();
	}
}
