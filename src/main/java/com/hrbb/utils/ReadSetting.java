package com.hrbb.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 环境变量读取控制类
* @author Chris Yeung 
* @version V1.0
* 
*/
public class ReadSetting {
	public static Properties prop = getProperties() ;
	
	public static int WebDriverType = Integer.parseInt(prop.getProperty("WebDriverType"));
	
	public static String HubUrl = prop.getProperty("HubUrl");
	
	public static String ChromeDriverPath = prop.getProperty("ChromeDriverPath");
	
	public static String FirefoxDriverPath = prop.getProperty("FirefoxDriverPath");

	public static String FirefoxDriverForLinuxPath = prop.getProperty("FirefoxDriverForLinuxPath");

	public static String ChromeDriverForLinuxPath = prop.getProperty("ChromeDriverForLinuxPath");

	public static String IEDriverPath = prop.getProperty("IEDriverPath");

	public static String PhantomjsPath = prop.getProperty("PhantomjsPath");

	public static String StepInterval = prop.getProperty("StepInterval");
	
	public static String UpLoadMode = prop.getProperty("UpLoadMode");

	public static String ClickTimeout = prop.getProperty("ClickTimeout");
	
	public static String DatabaseIP = prop.getProperty("DatabaseIP");
	
	public static String Sid = prop.getProperty("Sid");
	
	public static String User = prop.getProperty("User");
	
	public static String Password = prop.getProperty("Password");
	
	public static String DatabasePort = prop.getProperty("DatabasePort");
	
	public static String driver = prop.getProperty("driver");
	
	public static String userName = prop.getProperty("userName");
	
	public static String passWord = prop.getProperty("passWord");
	
	public static String url = prop.getProperty("url");
	
	public static String timeout = Integer.toString(Integer.parseInt(prop.getProperty("ClickTimeout"))*1000);
	
	
	public  static  Properties getProperties() {
	try{
		prop = new Properties();
		InputStream path = Thread.currentThread().getContextClassLoader().getResourceAsStream("prop.properties");
		System.out.println(path);
//		InputStream input = new FileInputStream(path);
		prop.load(path);
		path.close();
	} catch (Exception e) {
		MyWebDriver.getLog().warn("prop.properties文件路径错误，请检查...");
		e.printStackTrace();
	}
	return prop;
		
	}
//	public static void main(String args[]){
//		System.out.println(ClickTimeout);
//	}
	
}

