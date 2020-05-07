package com.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestRuns {

	String title;
	String id;
	
	TestRuns(){
		
	}
	
	public TestRuns(String title, String id) {
		super();
		this.title = title;
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "TestRuns [title=" + title + ", id=" + id + "]";
	}
	
	
}
