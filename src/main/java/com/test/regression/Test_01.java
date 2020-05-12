package com.test.regression;



import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.MainPage;
import com.test.util.BaseTest;

public class Test_01 extends BaseTest {
	
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
