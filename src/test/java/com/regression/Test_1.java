package com.regression;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.MainPage;
import com.util.BaseTest;

public class Test_1 extends BaseTest {
	
	@Test
	public void f() {
		
		driver.get("https://www.interjet.com/en-us");
		
		MainPage mainPage = new MainPage(driver);
		

		mainPage.clickOrigin();
		
		try {
			Thread.sleep(1000);

			//Assert.assertEquals(mainPage.setRadioButton("One way"), true, "This radio does not exist");

			//Assert.assertEquals(mainPage.clickOrigin(), true, "Failed click on Origin");
			//driver.findElement(By.xpath("//*[@id=\\\"BookingEngineOlyFlight\\\"]/div[2]/div[1]/div[1]/button[1]")).click();
			//Assert.assertEquals(mainPage.clickDestination(), true, "Failed click on Destination");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
