package com.vo;

public class Report {
	
	private String testName;
	private String status;
	private String failedDescription;
	
	public Report() {
		super();
	}

	public Report(String testName, String status, String failedDescription) {
		super();
		this.testName = testName;
		this.status = status;
		this.failedDescription = failedDescription;
	}
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFailedDescription() {
		return failedDescription;
	}
	public void setFailedDescription(String failedDescription) {
		this.failedDescription = failedDescription;
	}

	@Override
	public String toString() {
		return "Report [testName=" + testName + ", status=" + status + ", failedDescription=" + failedDescription + "]";
	}
	
}
