package com.data;

import java.util.HashMap;

import com.vo.Report;
import com.vo.Results;

public class ReportSingleton {
	
	private static HashMap<String, Results> reportData = null;
	
	private ReportSingleton() {
		
	}
	
	public static HashMap<String, Results> getSingleton() {
		
		if(reportData == null) {
			reportData = new HashMap<String, Results>();
			return reportData;
		}else {
			return reportData;
		}
		
	}

}
