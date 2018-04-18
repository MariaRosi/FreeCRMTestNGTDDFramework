package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBaseClass;

public class ContactsPage extends TestBaseClass {
	
	//define the elements
		// Page Factory - OR
		@FindBy(xpath="//td[contains(text(),'Contacts')]")
		WebElement ele_ContactsLabel;
		
		@FindBy(name="title")
		WebElement ele_TitleSelect;
		
		@FindBy(id="first_name")
		WebElement ele_Firstname;
		
		
		@FindBy(id="surname")
		WebElement ele_Surname;
		
		
		@FindBy(name="client_lookup")
		WebElement ele_Company;
		
		@FindBy(xpath="//input[@type='button' and @value='Load From Company']//following-sibling::input[@type='submit' and @value='Save']")
		WebElement ele_Save;
		
			
		// Initialize the page objects / elements in constructor
		public ContactsPage() {
			System.out.println("Prog : ContactsPage and contructor : ContactsPage");
			PageFactory.initElements(driver, this);

		}
		
		
		//define method
		public boolean isDisplayedContactsPageContactLabel() {
			System.out.println("Prog : ContactsPage and Method : isDisplayedContactsPageContactLabel");
			return ele_ContactsLabel.isDisplayed();
		}
		
		public void selectContactsByName(String sName) {
			System.out.println("Prog : ContactsPage and Method : selectContactsByName");
			driver.findElement(By.xpath("//a[(text()='"+sName+"')]//parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
			
		}
		
		public void createNewContact(String sTitle, String sUsername, String sSurname, String sCompany) {
			System.out.println("Prog : ContactsPage and Method : createNewContact");
			Select sel_Title = new Select(ele_TitleSelect);
			sel_Title.selectByVisibleText(sTitle);
			ele_Firstname.sendKeys(sUsername);
			ele_Surname.sendKeys(sSurname);
			ele_Company.sendKeys(sCompany);
			
			ele_Save.click();
			
		}
		
		

}
