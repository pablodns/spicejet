package com.data.util;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class DataParser {
	
	
	//regrese un Object en una Lista dado un String en formato JSON.
	
	public static <T> List<T> parseJson(String json, Class<?> clazz){
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
			
			List<T> returnList = mapper.readValue(json, listType);
			return returnList;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
