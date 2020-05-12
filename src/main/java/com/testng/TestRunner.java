package com.testng;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONObject;
import org.testng.TestNG;
import com.data.ReportSingleton;
import com.data.util.DataParser;
import com.testrail.APIClient;
import com.testrail.APIException;
import com.vo.Report;
import com.vo.TestRuns;

public class TestRunner {

public static void main(String[] args) throws InvalidFormatException, IOException {
		
		APIClient call = new APIClient("https://gammapartners.testrail.net/");
		call.setUser("pgarcia@pkglobal.com");
		call.setPassword("Q5IOKL.7AiUQqcyFBV2Y-ZyUK.xG1PCGsI1F39G9L");
		String response = "";
		
		try {
			response = call.sendGet("get_tests/1343").toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
		
		
		List<TestRuns> runList = new ArrayList<TestRuns>();
		
		runList = DataParser.parseJson(response, TestRuns.class);

		TestNG objeto = new TestNG();
		
		Class [] classList = getValidTestClassArray(runList);
		
		objeto.setTestClasses(classList);
		objeto.run();
		
		//ReportSingleton.getSingleton().values().stream().forEach(System.out::println);
		String result = DataParser.parseObject(ReportSingleton.getSingleton().values().toArray());
		String send_json = "{\"results\":?}";
		send_json = send_json.replace("?",  result);

		JSONObject objResults = new JSONObject(send_json);
		
		System.out.println(send_json);
		
		try {
			call.sendPost("add_results/1343", objResults);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
		
	}

	public static Class[] getValidTestClassArray(List<TestRuns> list) {
		Class [] returnClass = null;
		
		for (TestRuns test : list) {
			ReportSingleton.getSingleton().put(test.getTitle(),  new Report(test.getTitle(), Integer.parseInt(test.getId())));
			
			String name = test.getTitle();
			
			try {
				Class c = Class.forName(name);
				returnClass = addClassToClassArray(c, returnClass);
								
			} catch (ClassNotFoundException e) {
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
