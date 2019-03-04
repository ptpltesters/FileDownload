package com.ptpl.util;

import java.util.ArrayList;






public class Util {

	static Xls_Reader reader;
	static String xslPath;
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		xslPath = System.getProperty("user.dir");
		xslPath = xslPath +"/src/test/java/com/ptpl/testdata/SampleImage.xlsx";
		try {
			reader = new Xls_Reader(xslPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum < reader.getRowCount("Sheet1"); rowNum++) {
			String divisionName = reader.getCellData("Sheet1", "Division", rowNum);
			String DTCCODE = reader.getCellData("Sheet1", "DTCCODE", rowNum);
			String imageType = reader.getCellData("Sheet1", "SurveyCycleDesc", rowNum);
			String fileName = reader.getCellData("Sheet1", "ImageFileName", rowNum);
			
			Object obj[] = {divisionName, DTCCODE, imageType, fileName};
			myData.add(obj);
		}
//		String divisionName= reader.getCellData("Sheet1", "Division1", 2);
//		System.out.println(divisionName);
		return myData;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
