package com.data;

import java.util.HashMap;

import com.vo.Report;

public class ReportSingleton {
	
	private static HashMap<String, Report> reportData = null;
	
	private ReportSingleton() {
		
	}
	
	public static HashMap<String, Report> getSingleton() {
		
		if(reportData == null) {
			reportData = new HashMap<String, Report>();
			return reportData;
		}else {
			return reportData;
		}
		
	}

}
