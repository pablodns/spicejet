package com.regression;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.data.FlightDescriptionSingleton;
import com.util.BaseTest;
import com.vo.FlightDescription;

public class Flight_Test_Singleton extends BaseTest{
	
  @Test
  public void f() {
	  
	  FlightDescription data = testData.get(this.getClass().getSimpleName());
	  
	  System.out.println(data.toString());
	  	  
  }
}
