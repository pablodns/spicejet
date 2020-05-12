package com.test.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.data.Constants;
import com.data.FlightDescriptionSingleton;
import com.data.PropertyLoader;
import com.test.listeners.IReportListener;
import com.vo.FlightDescription;


@Listeners (IReportListener.class)

public class BaseTest {

	
	public WebDriver driver;
	public HashMap<String, FlightDescription> testData = FlightDescriptionSingleton.getFlightDescriptionSingleton();
	public FlightDescription data;
	
	public BaseTest() {
		
		data = testData.get(this.getClass().getSimpleName());
		
		if(PropertyLoader.getProperty(Constants.SERVER).equals("LOCAL")) {

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
		}else if (PropertyLoader.getProperty(Constants.SERVER).equals("BROWSERSTACK")) {
			String USERNAME = "gammapartners";
			  String AUTOMATE_KEY = "2wyKQnjt9yj8VAcK9JjZ";
			  String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
			  DesiredCapabilities caps = new DesiredCapabilities();
			    caps.setCapability("browser", PropertyLoader.getProperty(Constants.BROWSER));
			    caps.setCapability("browser_version", PropertyLoader.getProperty(Constants.BROWSER_VERSION));
			    caps.setCapability("os", PropertyLoader.getProperty(Constants.OS));
			    caps.setCapability("os_version", PropertyLoader.getProperty(Constants.OS_VERSION));
			    caps.setCapability("resolution", PropertyLoader.getProperty(Constants.RESOLUTION));
			    caps.setCapability("name", this.getClass().getSimpleName());
			    
			    try {
					driver = new RemoteWebDriver(new URL(URL), caps);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
