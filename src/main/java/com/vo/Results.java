	package com.vo;

public class Results {
	
	private String test_id;
	private String status_id;
	private String comment;
	private String defects;
	
	public Results() {}	
	
	public Results(String test_id, String status_id, String comment, String defects) {
		super();
		this.test_id = test_id;
		this.status_id = status_id;
		this.comment = comment;
		this.defects = defects;
	}
	public String getTest_id() {
		return test_id;
	}
	public void setTest_id(String test_id) {
		this.test_id = test_id;
	}
	public String getStatus_id() {
		return status_id;
	}
	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDefects() {
		return defects;
	}
	public void setDefects(String defects) {
		this.defects = defects;
	} 
	
	

}
