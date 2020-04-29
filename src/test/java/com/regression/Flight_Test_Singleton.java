package com.regression;

import java.util.HashMap;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.data.FlightDescriptionSingleton;
import com.util.BaseTest;
import com.vo.FlightDescription;

public class Flight_Test_Singleton extends BaseTest{

	@Test
	public void h() {
		System.out.println("This is the third test case");
		throw new SkipException("This is the exception");
	}
	
}
