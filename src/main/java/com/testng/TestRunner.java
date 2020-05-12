package com.testng;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.TestNG;

import com.data.ReportSingleton;
import com.data.util.DataParser;
import com.testrail.APIClient;
import com.testrail.APIException;
import com.vo.Results;
import com.vo.TestRelationSingleton;
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

		TestNG objeto = new TestNG();
		
		Class [] classList = getValidTestClassArray(runList);
		
		objeto.setTestClasses(classList);
		objeto.run();
		
		ReportSingleton.getSingleton().values().stream().forEach(System.out::println);
		
		
	}



	public static Class[] getValidTestClassArray(List<TestRuns> list) {
		
		Class [] returnClass = null;
		
		for (TestRuns test : list) {
			Results singleResult = new Results();
			singleResult.setTest_id(test.getId());
			
			TestRelationSingleton.getRelation().put(test.getTitle(), test.getId());
			
			ReportSingleton.getSingleton().put(test.getId(),  singleResult);
			String name = test.getTitle();
			
			try {
				Class c = Class.forName(name);
				returnClass = addClassToClassArray(c, returnClass);
								
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return returnClass;
		
	}
	




	public static Class [] addClassToClassArray(Class clazz, Class [] classArray) {
		
		Class [] newArray = null; 
		
		if(classArray == null) {
			newArray = new Class[1];
			newArray[0] = clazz;
		}else {
			int actualCount = classArray.length;
			int newClassSize = actualCount + 1;
			newArray = new Class[newClassSize];
			
			for(int i = 0; i < actualCount; i++) {
				
				newArray[i] = classArray[i];		
			}
			newArray[actualCount] = clazz; 		
		}
		
		return newArray; 
	}
}
