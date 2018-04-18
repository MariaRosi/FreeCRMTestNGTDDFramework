package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBaseClass;

public class HomePage extends TestBaseClass {
	
	//define the elements
	// Page Factory - OR
	@FindBy(xpath="//td[contains(text(),'User: Maria Rosi')]")
	WebElement ele_LoggedInUser;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ele_Contacts;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement ele_Deals;
	
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement ele_NewContact;
	
	
	
	
	// Initialize the page objects / elements in constructor
	public HomePage() {
		System.out.println("Prog : HomePage and contructor : HomePage");
		PageFactory.initElements(driver, this);

	}
	
	
	//define method
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	
	
	public String getLoggedInUserName() {
		System.out.println("Prog : HomePage and Method : getLoggedInUserName");
		return ele_LoggedInUser.getText();
	}
	
	public ContactsPage clickOnContacts() {
		System.out.println("Prog : HomePage and Method : clickOnContacts");
		ele_Contacts.click();
		return new ContactsPage();
		
	}
	
	public ContactsPage clickOnNewContact() {
		System.out.println("Prog : HomePage and Method : clickOnNewContact");
		
		Actions action = new Actions(driver);
		action.moveToElement(ele_Contacts).build().perform();
		ele_NewContact.click();
		return new ContactsPage();
		
	}
	
	public DealsPage clickOnDeals() {
		System.out.println("Prog : HomePage and Method : clickOnDeals");
		ele_Deals.click();
		return new DealsPage();
		
	}

}
