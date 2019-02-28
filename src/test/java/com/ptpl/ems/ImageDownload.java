package com.ptpl.ems;

import java.awt.AWTException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptpl.base.Base;
import com.ptpl.util.Util;

public class ImageDownload extends Base{

	public File folder;
	public File folder1;
	public File folderd;
	
	public ImageDownload() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		//initialization();
		
		
	}
	
	@DataProvider
	public Iterator<Object[]> folderName() {
		ArrayList<Object[]> testData =Util.getDataFromExcel();
		return testData.iterator();
		//Division1
	}
	
	@Test (dataProvider = "folderName")
	public void imageDownload(String divisioonFolder, String mscode) throws AWTException {
		path = System.getProperty("user.dir");
		String thermal = divisioonFolder+"/"+mscode+"/Thermal";
		String gis = divisioonFolder+"/"+mscode+"/GIS";
		folder = new File(path+ "/50SampleSurveyHESCOM1/"+thermal);
		folder1 = new File(path+ "/50SampleSurveyHESCOM1/"+gis);
		folder.mkdir();
		folder1.mkdir();
		String url = prop.getProperty("url");
		String fileName = "IMG_20150319_100149_347_10ab2c9e49b8df7a_1426739509734.jpg";
		url = url + fileName;
		System.out.println(thermal);
		System.out.println(gis);

//		String s= Util.getDataFromExcel();
//		System.out.println(s);


	}
	
	
	
	
	
	
}
