package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBaseClass;

public class LoginPage extends TestBaseClass {

	// Page Factory - OR
	@FindBy(name = "username")
	WebElement ele_Username;

	@FindBy(name = "password")
	WebElement ele_Password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement ele_Submit_Button;

	@FindBy(xpath = "//button[contains(@text(),'Sign Up')")
	WebElement ele_Signup_Button;

	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement ele_Crm_Logo;

	
	// Initialize the page objects / elements in constructor
	public LoginPage() {
		System.out.println("Prog : LoginPage and contructor : LoginPage");
		PageFactory.initElements(driver, this);

	}
	
	
	//Define Methods/Actions
	public String getLoginPageTitle() {
		System.out.println("Prog : LoginPage and Method : getLoginPageTitle");
		return driver.getTitle();
	}
	
	public boolean isDisplayedFreeCRMLogo() {
		System.out.println("Prog : LoginPage and Method : isDisplayedFreeCRMLogo");
		return ele_Crm_Logo.isDisplayed();
	}
	
	public HomePage doLogin(String sUsername, String sPassword) throws Exception {
		System.out.println("Prog : LoginPage and Method : doLogin");
		ele_Username.sendKeys(sUsername);
		ele_Password.sendKeys(sPassword);
		Thread.sleep(2000);
		ele_Submit_Button.click();

		return new HomePage();
		
	}
	
	

}
