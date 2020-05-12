package com.data.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.data.Constants;
import com.data.PropertyLoader;

public class ExcelWriter {
	
	Workbook wBook;
	
	public ExcelWriter() {
		wBook = new XSSFWorkbook();
	}
	
	public <T extends IExcelWriter> void writeWorkBook(List<T> t) {
		if(!t.isEmpty()) {
			XSSFSheet sheet = (XSSFSheet) wBook.createSheet("Results");
			String [] headers = t.get(0).getHeaders();
			
			Row row = sheet.createRow(0);
			
			for(int i = 0; i < headers.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(headers[i]);
			}
			
			for (int i = 1; i <= t.size(); i++) {
				Object [] values = t.get(i - 1).getValues();
				Row dataRow = sheet.createRow(i);
				
				for(int j = 0; j < values.length; j++) {
					Cell cell = dataRow.createCell(j);
					cell.setCellValue(values[j].toString());
				}
			}

			String filePath = PropertyLoader.getProperty(Constants.REPORT_PATH);
			String fileName = PropertyLoader.getProperty(Constants.REPORT_NAME);
			//C:/codebase/UISpiceJet/Reports/Report.xlsx
			//File file = new File(filePath + fileName);
			
			if(createDir(filePath)) {
				try {
					FileOutputStream output = new FileOutputStream(filePath + fileName);
					wBook.write(output);
					wBook.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				System.err.println("Error after create the report file");
			}
						
			
		}else {
			System.err.println("Error, the report list is empty.");
		}
	}
	
	public boolean createDir(String filePath) {
		
		File file = new File(filePath);
		
		if(file.exists()) {
			return true; 
		}else {
			return file.mkdirs();
		}
				
	}
	

}
