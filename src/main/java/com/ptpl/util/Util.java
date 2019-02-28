package com.ptpl.util;

import java.util.ArrayList;






public class Util {

	static Xls_Reader reader;
	static String xslPath;
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		xslPath = System.getProperty("user.dir");
		xslPath = xslPath +"/src/test/java/com/ptpl/testdata/ImageHescomsample50.xlsx";
		try {
			reader = new Xls_Reader(xslPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum < reader.getRowCount("Sheet1"); rowNum++) {
			String divisionName = reader.getCellData("Sheet1", "Division", rowNum);
			String mscode = reader.getCellData("Sheet1", "Mscode", rowNum);
//			String imageType = reader.getCellData("Sheet1", "ImageType", rowNum);
//			String fileName = reader.getCellData("Sheet1", "fileName", rowNum);
//			imageType, fileName
			Object obj[] = {divisionName, mscode };
			myData.add(obj);
		}
//		String divisionName= reader.getCellData("Sheet1", "Division1", 2);
//		System.out.println(divisionName);
		return myData;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
