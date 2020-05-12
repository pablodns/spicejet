package com.vo;

import java.util.HashMap;

public class TestRelationSingleton {
	
	private static HashMap<String, String> relation = null; 
	
	private TestRelationSingleton() {}

	
	public static HashMap<String, String> getRelation(){
		
		if (relation == null) {
			relation = new HashMap<String, String>();
			return relation;
		}else {
			return relation; 
		}
		
	}
	

}
