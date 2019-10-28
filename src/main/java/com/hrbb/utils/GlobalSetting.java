package com.hrbb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

/**
 * Android环境变量配置
* @author Chris Yeung 
* @version V1.0
* 
*/
public  class GlobalSetting {
	public static Properties prop = getProperties();
	
	public static String devicename = prop.getProperty("devicename");
	
	public static String udid = prop.getProperty("udid");
	
	public static String platformversion = prop.getProperty("platformversion");
	
	public static String app = prop.getProperty("app");
	
	public static String app1 = prop.getProperty("app1");
	
	public static String apppackage = prop.getProperty("apppackage");
	
	public static String appactivity = prop.getProperty("appactivity");
	
	public static String getProperty(final String property) {
		return prop.getProperty(property);
	}
	
	public static Properties getProperties(){
	try{
		prop = new Properties();
		String path = GlobalSetting.class.getResource("GlobalSetting.class").getPath();
		System.out.println(path);
	    String dir = path.split("\\/bin/myAppium/framework/GlobalSetting.class")[0];
	    System.out.println(dir);
	    String filepath = dir.split("/", 2)[1] + "/prop/AndroidSetting.properties";
	    System.out.println(filepath);
		InputStream input = new FileInputStream(filepath);
		prop.load(input);
		input.close();
	} catch (Exception e) {
		System.out.println("工作空间路径不能有\".\"");
		e.printStackTrace();
	}
		
	return prop;
	}
	
	@Test
	public void demo(){
		System.out.println(udid);
		System.out.println(app);
	}
}
