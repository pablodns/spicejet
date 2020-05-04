package com.listeners;

import java.util.HashMap;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.data.ReportSingleton;
import com.data.util.DataParser;
import com.vo.Report;

public class IReportListener implements ITestListener{
	
	HashMap<String, Report> dataReport = ReportSingleton.getSingleton();
	String className = null;

	@Override
	public void onTestStart(ITestResult result) {
		//className = getSimpleClassName(result);
		//dataReport.put(className, new Report(className,"",""));
		
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		setResult(result);
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		setResult(result);
		ITestListener.super.onTestFailure(result);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		setResult(result);
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		setResult(result);
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		setResult(result);
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
		
		System.out.println(DataParser.parseObject(values));
		
		
		
	}
	
	
	public void setResult(ITestResult result) {
		
		String name = getSimpleClassName(result);
		System.out.println("****************" + name);
		dataReport.put(name, new Report(name, "", ""));
		
		String defect = ""; 
		int run_status_id = result.getStatus();
		
		switch (run_status_id) {
		case ITestResult.SUCCESS:
			dataReport.get(name).setStatus("PASSED");
			
			break;
		case ITestResult.FAILURE:
			dataReport.get(name).setStatus("FAILED");
			dataReport.get(name).setFailedDescription(result.getThrowable().getMessage());
			
			break;
			
		case ITestResult.SKIP:
			dataReport.get(name).setStatus("SKIPED");
			dataReport.get(name).setFailedDescription(result.getThrowable().getMessage());
			break;
		default:
			break;
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
