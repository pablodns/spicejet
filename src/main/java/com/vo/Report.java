package com.vo;

import com.data.excel.IExcelWriter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"headers", "values", "title"})
public class Report implements IExcelWriter {
	
	private String title;
	private int test_id;
	private int status_id;
	private String comment;
	private String defects;
	
	public Report() {
		super();
	}
	
	public Report(String title, int test_id) {
		this.title = title; 
		this.test_id = test_id; 
		this.status_id = 3;
		this.comment = "";
		this.defects = "";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
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

	@Override
	public String toString() {
		return "Report [title=" + title + ", test_id=" + test_id + ", status_id=" + status_id + ", comment=" + comment
				+ ", defects=" + defects + "]";
	}

	@Override
	public String[] getHeaders() {
		String [] headers = {"Test ID", "Test Case","Status","Comment", "Defect"};
		
		return headers;
	}

	@Override
	public Object[] getValues() {
		Object [] values = {getTest_id(), getTitle(), getStatus_id(), getComment(), getDefects()};
		return values;
	}
}
