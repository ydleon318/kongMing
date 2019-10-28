package com.hrbb.utils;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class MyAndroidDriver {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;
	private static Logger log = Logger.getLogger(MyAndroidDriver.class.getName());

	public static Logger getLog() {
		return log;
	}

	public static void setLog(final Logger newLog) {
		log = newLog;
	}
	
	public void setAndroidDriver(){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName","Honor V8");
//		capabilities.setCapability("deviceName","127.0.0.1:62001");
		capabilities.setCapability("udid","TDCDU17901000228");
		capabilities.setCapability("platformVersion","5.1.1");
		capabilities.setCapability("app","D:\\kaoyan3.1.0.apk");
		capabilities.setCapability("appPackage","com.tal.kaoyan");
		capabilities.setCapability("appActivity","com.tal.kaoyan.ui.activity.SplashActivity");
		capabilities.setCapability("noReset",true);
		capabilities.setCapability("unicodeKeyboard", true);//设置appium自带输入法
	    capabilities.setCapability("resetKeyboard", true);//重置手机默认输入法
	    
	    try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			log.error("启动Driver失败");
			e.printStackTrace();
		}
	}
	
	public AndroidDriver<WebElement> getAndroidDriver(){
		return driver;	
	}
	
	public MyAndroidDriver(){
		setAndroidDriver();
	}
	
	
//----------------------------以下为操作app界面动作的空间，如click，tap，swipe等-----------------
	
	
	/**
	 * 通过元素xpath触摸屏幕元素
	 * @param xpath
	 */
	public void tapXpath(final String xpath){
		try{
			TouchAction ta = new TouchAction(driver);
			ta.tap(driver.findElementByXPath(xpath));
		}catch(Exception e){
			log.info("无法点击"+ xpath +"元素！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过文本text触摸屏幕元素
	 * @param text
	 */
	public void tapText(final String text){
		log.info("准备触摸： “"+text+"”");
		tapXpath("//*[text()='"+text+"']");
	}
	
	public WebElement element(By by){	
			return driver.findElement(by);
	}
	
	/**
	 * 点击某元素
	 * @param by 传递webelement类型参数
	 */
	public void tap(By by){
		try{
			TouchAction ta = new TouchAction(driver);
			ta.tap(element(by));
		}catch(Exception e){
			log.info("无法点击"+ by +"元素！");
			e.printStackTrace();
		}
	}
	/**
	 * 点击制定坐标元素
	 * @param x 坐标
	 * @param y 坐标
	 */
	public void tap(int x,int y){
		try{
			TouchAction ta = new TouchAction(driver);
			ta.tap(x,y);
		}catch(Exception e){
			e.printStackTrace();
			log.info("无法点击"+x+y+"坐标元素");
		}
	}
	/**
	 * 获取应用占据屏幕大小
	 * @return 长与宽
	 */
	private int[] appScreen(){
		int width = driver.manage().window().getSize().getWidth();
		int heightScreen=driver.manage().window().getSize().getHeight();
		int[] appWidthAndHight={width,heightScreen};
		return appWidthAndHight;
	}
	/**
	 * 手指向下滑动屏幕
	 * @param time 滑动持续时间，可控制滑屏速度
	 */
	public void swipeToDown(int time){
		int starty=this.appScreen()[1]*1/5;
		int endy=this.appScreen()[1]*4/5;
		int x=this.appScreen()[0]*1/2;
		try{
			driver.swipe(x, starty, x, endy, time);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 手指向右滑动屏幕
	 * @param time 滑动持续时间，可控制滑屏速度
	 */
	public void swipeToRight(int time){
		int startx=this.appScreen()[0]*1/5;
		int endx=this.appScreen()[0]*4/5;
		int y=this.appScreen()[1]*1/2;
		try{
			driver.swipe(startx, y, endx, y, time);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 手指向左滑动屏幕
	 * @param time 滑动持续时间，可控制滑屏速度
	 */
	public void swipeToLeft(int time){
		int startx=this.appScreen()[0]*4/5;
		int endx=this.appScreen()[0]*1/5;
		int y=this.appScreen()[1]*1/2; 
		try{
			driver.swipe(startx, y, endx, y, time);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 手指向上滑动屏幕
	 * @param time 滑动持续时间，可控制滑屏速度
	 */
	public void swipeToUp(int time){
		int starty=this.appScreen()[1]*4/5;
		int endy=this.appScreen()[1]*1/5;
		int x=this.appScreen()[0]*1/2; 
		try{
			driver.swipe(x,starty,x,endy,time);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过输入Up,Down,Right,Left实现滑动屏幕方式
	 * @param direction 滑动方向参数
	 * @param time 滑动持续时间，可控制滑屏速度
	 */
	public void swipe(String direction,int time){
		switch(direction){
		case"Up":
			this.swipeToUp(time);
			break;
		case"Down":
			this.swipeToDown(time);
			break;
		case"Right":
			this.swipeToRight(time);
			break;
		case"Left":
			this.swipeToLeft(time);
			break;
		}
	}
	/**
	 * 在某元素上面滑动
	 * @param element 元素
	 * @param direction 滑动方向参数，通过输入Up,Down,Right,Left
	 * @param time 滑动持续时间，可控制滑屏速度
	 */
	public void swipeOnElement(WebElement element,String direction,int time){
		int x=element.getLocation().getX();
		int y=element.getLocation().getY();
		int elementWidth=element.getSize().getWidth();
		int elementHight=element.getSize().getHeight();
		switch(direction){
		case"up":
			int startx = x+elementWidth/2;
			int starty=y+elementHight*4/5;
			int endy=y+elementHight*1/5;
			driver.swipe(startx, starty, startx, endy, time);
			break;
		case"Down":
			startx=x+elementWidth/2;
			starty=y+elementHight*1/5;
			endy=y+elementHight*4/5;
			driver.swipe(startx, starty, startx, endy, time);
			break;
		case"Left":
			starty=y+elementHight/2;
			startx=y+elementWidth*4/5;
			int endx=y+elementWidth*1/5;
			driver.swipe(startx, starty, endx, starty, time);
			break;
		case"Right":
			starty=x+elementHight/2;
			startx=y+elementWidth*1/5;
			endx=y+elementWidth*4/5;
			driver.swipe(startx, starty, endx, starty, time);
			break;
		default:
			break;	
		}
	}
	/**
	 * 在某方向上滑动直到期望元素出现
	 * @param by 期望出现的元素
	 * @param direction 滑动方向参数，通过输入Up,Down,Right,Left
	 * @param time 滑动持续时间，可控制滑屏速度
	 */
	public void swipeUtilElementAppear(By by,String direction,int time){
		boolean flag = true;
		while(flag){
			try{
				driver.findElement(by);
				flag=false;
			} catch(Exception e){
				this.swipe(direction, time);
			}
		}
	}

	/**
	 * 在某元素上长按
	 * @param by 长按的某元素
	 */
	public void longPress(By by){
		try{
			WebElement element = driver.findElement(by);
			TouchAction ta = new TouchAction(driver);
			ta.longPress(element).release().perform();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 在某坐标位置长按
	 * @param x 
	 * @param y
	 */
	public void longPress(int x,int y){
		try{
			TouchAction ta = new TouchAction(driver);
			ta.longPress(x,y).release().perform();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 判断元素是否存在
	 * @param by
	 * @return
	 */
	public boolean isElementExist(By by){
		try{
			driver.findElement(by);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 在指定时间判断元素是否存在，如存在返回结果，不存在则超时后返回结果
	 * @param by 被判断的元素
	 * @param timeout 超时时间
	 * @return
	 */
	public boolean isElementExis(By by,int timeout){
		try{
			new WebDriverWait(driver,timeout).until(ExpectedConditions.presenceOfElementLocated(by));
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
