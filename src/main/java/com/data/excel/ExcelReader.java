package com.data.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExcelReader {
	
	static Workbook wBook = null;
	static int lastRow;
	static int lastColumn;
		
	public static String getDataInJsonFormat(Sheet sheet) {
		
		JSONArray array = new JSONArray();
		Row row = sheet.getRow(0);
		String [] headers = getHeaders(sheet);
		lastRow = sheet.getLastRowNum();
		
		
		for(int i = 1; i <= lastRow; i ++) {
			JSONObject object = new JSONObject();
			
			row = sheet.getRow(i);
			
			if(true) {
				
				for(int j = 0; j < lastColumn; j++) {
					Cell cell = row.getCell(j);
					
					DataFormatter formater = new DataFormatter();
					String value;
					
					value = formater.formatCellValue(cell);
					object.put(headers[j], value);
					
				}
				
			}
			array.put(object);
		}
		return array.toString(1);
		
	}
	
	public static String [] getHeaders(Sheet sheet) {

		if(sheet != null) {
			Row row = sheet.getRow(0);
			lastColumn = row.getLastCellNum();
			String[] headers = new String[lastColumn];
		
			for(int i = 0; i < lastColumn; i++) {
				Cell cell = row.getCell(i);
				headers[i] = cell.getStringCellValue();
			}
			
			return headers;
		}else {
			return null;
		}
		
	}
	

}
