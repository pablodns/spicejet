package com.data;

public class Constants {
	public static final Constants BROWSER = new Constants("BROWSER");
	public static final Constants ENVIRONMENT = new Constants("ENVIRONMENT");
	public static final Constants DATA_FILE = new Constants("DATA_FILE");
	public static final Constants CHROME_V81 = new Constants("CHROME_V81");
	public static final Constants DEFAULT_BROWSER = new Constants("DEFAULT_BROWSER");
	public static final Constants FIREFOX_PATH = new Constants("FIREFOX_PATH");
	public static final Constants REPORT_PATH = new Constants("REPORT_PATH");
	public static final Constants REPORT_NAME = new Constants("REPORT_NAME");
	
	private String name;
	
	public Constants(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name; 
	}

}
