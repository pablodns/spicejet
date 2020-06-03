package com.data;

import java.util.HashMap;
import java.util.List;

import com.data.excel.ExcelReader;
import com.data.util.DataParser;
import com.vo.FlightDescription;

public class FlightDescriptionSingleton {
	
	private static HashMap<String, FlightDescription> data = null; 
	
	
	private FlightDescriptionSingleton() {
		
	}
	
	public static HashMap<String, FlightDescription> getFlightDescriptionSingleton() {
		
		if(data == null) {
			data = new HashMap<String, FlightDescription>();
			
			List<FlightDescription> lista = DataParser.parseJson(ExcelReader.getDefaultData(), FlightDescription.class);
			
			for (FlightDescription flightDescription : lista) {
				data.put(flightDescription.getTEST(), flightDescription);
				
			}
			return data;
			
		}else {
			return data;
		}
		
	}

}
