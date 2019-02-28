package com.ptpl.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	
	public static Properties prop;
	public static FileInputStream ip;
	public static WebDriver driver;
	public static String path; 

	public Base() {

		prop = new Properties();
		try {
			path = System.getProperty("user.dir");
			System.out.println(path);
			ip = new FileInputStream(path+ "/src/main/java/com/ptpl/config/config.properties");
			prop.load(ip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initialization() {
		
		String browserName = prop.getProperty("Browsername");
		if (browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", path+ "/src/test/java/com/ptpl/testdata/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/src/test/java/com/ptpl/testdata/chromedriver");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitwaitTime")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTime")), TimeUnit.SECONDS);
		

	}
	
	
	
	
}
