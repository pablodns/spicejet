package com.listeners;

import java.util.HashMap;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.data.ReportSingleton;
import com.vo.Report;

public class IReportListener implements ITestListener{
	
	HashMap<String, Report> dataReport = ReportSingleton.getSingleton();
	String className = null;

	@Override
	public void onTestStart(ITestResult result) {
		className = getSimpleClassName(result);
		dataReport.put(className, new Report(className,"",""));
		
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		dataReport.get(className).setStatus("PASSED");
		
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		dataReport.get(className).setStatus("FAILED");
		dataReport.get(className).setFailedDescription(result.getThrowable().getMessage());
		ITestListener.super.onTestFailure(result);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		dataReport.get(className).setStatus("SKIPPED");
		dataReport.get(className).setFailedDescription(result.getThrowable().getMessage());
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
		
		Object [] values = 	dataReport.values().toArray();
		
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i].toString());
		}
		
	}
	
	
	public String getSimpleClassName(ITestResult result) {

		String name = result.getInstanceName();
		String convert;
		int lastDot = 0;
		
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			
			if(c == '.') {
				lastDot = i + 1;
			}
		}
		convert = name.substring(lastDot);
		
		return convert;
	}
	
	
	
	
	

}
