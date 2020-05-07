package com.regression;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.pages.MainPage;
import com.util.BaseTest;

public class Test_02 extends BaseTest {
	
	@Test
	public void f() {
		
		driver.get("https://www.interjet.com/en-us");
		
		MainPage mainPage = new MainPage(driver);
		

		try {
			Thread.sleep(1000);

			Assert.assertEquals(mainPage.setRadioButton(data.getTYPE()), true, "This radio option "+data.getTYPE()+" does not exist");

			Assert.assertEquals(mainPage.writeOrigin(data.getFROM()), true, "Failed click on Origin");
			
			Assert.assertEquals(mainPage.writeDestination(data.getTO()), true, "Failed click on Destination");
			
			Assert.assertEquals(mainPage.clickPassengers(), true, "Failed after click on Passengers");
			Assert.assertEquals(mainPage.clickAddAdult(Integer.parseInt(data.getADULTS())),  true, "Error after add adults");
			Assert.assertEquals(mainPage.clickAddChild(Integer.parseInt(data.getCHILDREN())),  true, "Error after add adults");
			Assert.assertEquals(mainPage.clickAddInfant(Integer.parseInt(data.getINFANT())),  true, "Error after add adults");
			Thread.sleep(6000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		
	}
	

}
