package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBaseClass;
import com.crm.pages.ContactsPage;
import com.crm.pages.DealsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utility.TestUtility;

public class HomePageTest extends TestBaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtility;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	
	//constructor
	public HomePageTest() {
		super();
		System.out.println("Prog : HomePageTest and Constructor : HomePageTest");
	}
	
	
	@BeforeMethod
	public void setup() throws Exception {
		System.out.println("Prog : HomePageTest and Method : setup");
		
		initializeBaseClass();
		
		loginPage =  new LoginPage();
		testUtility = new TestUtility();
		
		String sUserName = prop.getProperty("username");
		String sUserPwd = prop.getProperty("password");
		
		System.out.println("User name = "+sUserName);
		System.out.println("User name = "+sUserPwd);
		
		homePage = loginPage.doLogin(sUserName,sUserPwd);
		
	}
	
	
	@Test(priority=1)
	public void homePageTitleTest() {
		Assert.assertEquals(homePage.getHomePageTitle(), "CRMPRO");
	}
	
	
	@Test(priority=2)
	public void loggedInUserNameTest() {
		System.out.println("Prog : HomePageTest and Method : loggedInUserNameTest");
		testUtility.switchToFrame();
		
		Assert.assertTrue(homePage.getLoggedInUserName().contains("User: Maria Rosi"));
		
	}
	
	@Test(priority=3)
	public void clickOnContactsTest() {
		System.out.println("Prog : HomePageTest and Method : clickOnContactsTest");
		testUtility.switchToFrame();
		
		contactsPage = homePage.clickOnContacts();
		
	}
	
	@Test(priority=3)
	public void clickOnDealsTest() {
		System.out.println("Prog : HomePageTest and Method : clickOnDealsTest");
		testUtility.switchToFrame();
		
		dealsPage = homePage.clickOnDeals();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Prog : HomePageTest and Method : tearDown");
		driver.quit();
	}

}
