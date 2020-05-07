package com.testng;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.TestNG;

import com.data.util.DataParser;
import com.testrail.APIClient;
import com.testrail.APIException;
import com.vo.TestRuns;

public class TestRunner {

public static void main(String[] args) throws InvalidFormatException, IOException {
		
		APIClient call = new APIClient("https://gammapartners.testrail.net/");
		
		call.setUser("pgarcia@pkglobal.com");
		call.setPassword("Q5IOKL.7AiUQqcyFBV2Y-ZyUK.xG1PCGsI1F39G9L");
		String response = "";
		//JSONArray array = null; 
		
		try {
			response = call.sendGet("get_tests/1331").toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(response);
		
		List<TestRuns> runList = new ArrayList<TestRuns>();
		
		runList = DataParser.parseJson(response, TestRuns.class);
		
		runList.stream().forEach(System.out::println);
		
		TestNG objeto = new TestNG();
		
		Class [] classList;
		
		String path = "com.regression";
		
		for (int i = 0; i < runList.size(); i++) {
			runList.get(i).getTitle();
			
		}
		
	}
	

	public static Class [] addClassToClassArray(Class clazz, Class [] classArray) {
		
		
	}
}
