package com.ptpl.ems;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ptpl.base.Base;
import com.ptpl.util.Util;

public class ImageDownload1 extends Base{

	public File folder;
	public File folder1;
	public File folderd;
	
	public ImageDownload1() {
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
	public void imageDownload(String divisioonFolder, String mscode, String imageType, String fileName) throws AWTException, IOException {
		
		//path
		path = System.getProperty("user.dir");
		String thermal = divisioonFolder+"/"+mscode+"/THERMAL";
		String gis = divisioonFolder+"/"+mscode+"/GIS";
		folder = new File(path+ "/sampleTest/"+thermal);
		folder1 = new File(path+ "/sampleTest/"+gis);
		folder.mkdir();
		folder1.mkdir();
		
		//url
		//String url = prop.getProperty("url");
		//String fileName = "IMG_20150319_100149_347_10ab2c9e49b8df7a_1426739509734.jpg";
		//url = url + fileName;
		System.out.println(thermal);
		System.out.println(gis);
		
		//copy
		String source = path+ "/source/" +fileName;
		String des = path +"/sampleTest/"+divisioonFolder+"/"+mscode+ "/" +imageType+ "/" +fileName ; 
		Path s = Paths.get(source);
		Path d = Paths.get(des);
		Files.copy(s, d);
//		String s= Util.getDataFromExcel();
//		System.out.println(s);


	}
	
	
	
	
	
	
}
