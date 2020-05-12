package com.test.regression;


import org.testng.SkipException;
import org.testng.annotations.Test;
import com.test.util.BaseTest;

public class TestToSkip extends BaseTest{

	@Test
	public void h() {
		System.out.println("This is the third test case");
		throw new SkipException("This is the exception");
	}
	
}
