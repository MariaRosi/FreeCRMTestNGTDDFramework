package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.utility.TestUtility;

public class TestBaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	//constructor
	//Read the config.properties file
	public TestBaseClass() {
		try {
			System.out.println("Prog : TestBaseClass and Constructor : TestBaseClass");
			prop = new Properties();
			
			FileInputStream fis = new FileInputStream("D:\\Maria\\Selenium\\Workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\config\\confg.properties");
			
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Open the browser
	public void initializeBaseClass() {
		System.out.println("Prog : initializeBaseClass and Method : initializeBaseClass");
		String sBrowserName = prop.getProperty("browser");
		String sUrl = prop.getProperty("url");
		
		if("chrome".equalsIgnoreCase(sBrowserName)) {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Maria\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if("FF".equalsIgnoreCase(sBrowserName)) {
			
			System.setProperty("webdriver.gecko.driver", "D:\\Maria\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(sUrl);
	}
	
	

}
