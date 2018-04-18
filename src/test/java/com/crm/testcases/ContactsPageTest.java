package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.base.TestBaseClass;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utility.TestUtility;

public class ContactsPageTest extends TestBaseClass{
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtility;
	ContactsPage contactsPage;
	
	
	//constructor
	public ContactsPageTest() {
		super();
		System.out.println("Prog : ContactsPageTest and Constructor : ContactsPageTest");
	}
	
	
	@BeforeMethod
	public void setup() throws Exception {
		System.out.println("Prog : ContactsPageTest and Method : setup");
		
		initializeBaseClass();
		
		loginPage =  new LoginPage();
		testUtility = new TestUtility();
		
		String sUserName = prop.getProperty("username");
		String sUserPwd = prop.getProperty("password");
		
		System.out.println("User name = "+sUserName);
		System.out.println("User name = "+sUserPwd);
		
		homePage = loginPage.doLogin(sUserName,sUserPwd);
		testUtility.switchToFrame();

		Thread.sleep(2000);
		
	}
	
	
	@Test(priority=1,enabled=false)
	public void isDisplayedContactsPageContactLabelTest() {
		System.out.println("Prog : ContactsPageTest and Method : isDisplayedContactsPageContactLabelTest");
		contactsPage = homePage.clickOnContacts();
		Assert.assertTrue(contactsPage.isDisplayedContactsPageContactLabel());
	}
	
	
	@Test(priority=2,enabled=false)
	public void selectContactsByNameTest() {
		System.out.println("Prog : ContactsPageTest and Method : selectContactsByName");
		contactsPage = homePage.clickOnContacts();
		contactsPage.selectContactsByName("Test2 Test2");
	}
	
	
	@Test(priority=3,dataProvider = "getCreateNewContactsTestData")
	public void clickOnNewContactTest(String sTitle, String sUsername, String sSurname, String sCompany ) throws Exception {
		System.out.println("Prog : ContactsPageTest and Method : clickOnNewContactTest");
		contactsPage = homePage.clickOnNewContact();
		Thread.sleep(2000);
		contactsPage.createNewContact(sTitle, sUsername, sSurname, sCompany);
	}
	
	
	@DataProvider
	public Object[][] getCreateNewContactsTestData() {
		System.out.println("Prog : ContactsPageTest and Method : getCreateNewContactsTestData");
		String sExcelFilePath = prop.getProperty("TestDataExcelFilePath");
		String sExcelFileSheetName = prop.getProperty("TestDataContactsSheetName");
		
		System.out.println("sExcelFilePath = "+sExcelFilePath);
		System.out.println("sExcelFileSheetName = "+sExcelFileSheetName);
		
		testUtility = new TestUtility();
		
		Object[][] data = testUtility.getTestDataFromExcel(sExcelFilePath,sExcelFileSheetName);
		System.out.println("data = "+data);
		return data;
	}
	
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Prog : ContactsPageTest and Method : tearDown");
		driver.quit();
	}

}
