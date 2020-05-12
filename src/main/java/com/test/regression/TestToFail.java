package com.test.regression;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.util.BaseTest;

public class TestToFail extends BaseTest{

	
	
	@Test
	public void g() {
		Assert.fail("This method is failed manually");
		System.out.println("This is the second test case");
	}
	
  
}
