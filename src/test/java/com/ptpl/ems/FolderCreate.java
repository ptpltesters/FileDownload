package com.ptpl.ems;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptpl.util.Util;

public class FolderCreate {
	String defaultPath;
	
	@DataProvider
	public Iterator<Object[]> folderName() {
		ArrayList<Object[]> testData =Util.getDataFromExcel();
		return testData.iterator();
		//Division1
	}
	
	
//	@Test (dataProvider = "folderName")
//	public void folderCreate(String divisionName, String DTCCODE, String imageType, String fileName) {
//		System.out.println(divisionName);
//		System.out.println(DTCCODE);
//		defaultPath = System.getProperty("user.dir");
//		String printPath = defaultPath +"/HESCOMSampleSurvey/"+divisionName+"/"+DTCCODE+"/"+imageType+"/"+fileName;
//		System.out.println(printPath);
////		File gisfolder = new File(defaultPath+"/HESCOMSampleSurvey/"+divisionName+"/"+DTCCODE+"/THERMAL" );
////		gisfolder.mkdir();
//		
//		
//	}
	
	@Test(dataProvider = "folderName")
	public void copyFile(String divisionName, String DTCCODE ,String imageType , String fileName) throws IOException {
		defaultPath = System.getProperty("user.dir");
		String sourcePath = "/home/suraj/Music/tar/Digital_Images/" +fileName;
		//System.out.println(sourcePath);
		String desPath = defaultPath +"/HESCOMSampleSurvey/"+divisionName+"/"+DTCCODE+"/"+imageType+"/"+fileName;
		//System.out.println(desPath);
		Path source = Paths.get(sourcePath);
		Path destination = Paths.get(desPath);
		Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING );
		
	}

}
