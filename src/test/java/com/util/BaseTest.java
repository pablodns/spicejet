package com.util;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.data.Constants;
import com.data.FlightDescriptionSingleton;
import com.data.PropertyLoader;
import com.listeners.IReportListener;
import com.vo.FlightDescription;


@Listeners (IReportListener.class)

public class BaseTest {

	
	public WebDriver driver;
	public HashMap<String, FlightDescription> testData = FlightDescriptionSingleton.getFlightDescriptionSingleton();
	
	
	public BaseTest() {
		
		switch (getDefaultBrowser()) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", PropertyLoader.getProperty(Constants.CHROME_V81));
			driver = new ChromeDriver();
			
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", PropertyLoader.getProperty(Constants.FIREFOX_PATH));
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.manage().window().maximize();
	}
	
	
	
	@AfterMethod
	public void AfterMethod() {
		driver.quit();
	}
	
	
	private String getDefaultBrowser() {
		
		return PropertyLoader.getProperty(Constants.DEFAULT_BROWSER);
		
	}

}
