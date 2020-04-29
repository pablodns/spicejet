package com.regression;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.util.BaseTest;

public class Flight_Second_Test extends BaseTest{

	
	
	@Test
	public void g() {
		Assert.fail("This method is failed manually");
		System.out.println("This is the second test case");
	}
	
  
}
