package com.data.excel;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	
	Workbook wBook;
	
	public ExcelWriter() {
		wBook = new XSSFWorkbook();
	}
	
	
	public <T> void writeWorkBook(List<T> t) {
		
		if(!t.isEmpty()) {
			XSSFSheet sheet = (XSSFSheet) wBook.createSheet("Results");
			
			
			
					
			
			
			
		}
		
		
		
	}
	

}
