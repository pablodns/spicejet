package com.vo;

public class TestRelation {
	
	private String test_id; 
	private String className;
	
	public TestRelation() {}
	
	public TestRelation(String test_id, String className) {
		super();
		this.test_id = test_id;
		this.className = className;
	}
	public String getTest_id() {
		return test_id;
	}
	public void setTest_id(String test_id) {
		this.test_id = test_id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	} 
	
	

}
