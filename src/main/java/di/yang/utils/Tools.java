package di.yang.utils;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tools {
	private static Date dd;
	private static final Logger log = LoggerFactory.getLogger(Tools.class);
	/**
	 * 记录小步骤
	 * @param param
	 */
	public static void step(Object param){
		String step = "step-->" + param;
		log.info("step--> param = [{}]", param);
		Reporter.log(step);
	}


	/**
	 * 记录错误日志
	 * @param text
	 */
	public static void error(String text){
		String step = "出现错误--> " + text;
		log.error(step);
		Reporter.log(step);
	}

	/**
	 *获取时间空间
	 * @return 返回201702251057时间格式
	 */
	public static String getCurrentTime(){
		Calendar ca = Calendar.getInstance();
		String y = String .valueOf(ca.get(Calendar.YEAR));
		String M = String .valueOf(ca.get(Calendar.MONTH));
		String d = String .valueOf(ca.get(Calendar.DATE));
		String h = String .valueOf(ca.get(Calendar.HOUR));
		String m = String .valueOf(ca.get(Calendar.MINUTE));
		String s = String .valueOf(ca.get(Calendar.SECOND));
		return y+M+d+h+m+s;
	}

	/**
	 * 获取时间“时分秒”
	 * @return 如105832
	 */
	public static String getTime() {
		String time = new SimpleDateFormat("HHmmss").format(new Date());
		return time;
	}
	
	/**
	 * 暂停
	 * @param secound
	 */
	public static void pause(int secound){
		try{
			Thread.sleep(secound*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 获取时间"年-月-日"
	 * @return 例如2017-02-25
	 */
	public static String getDate() {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		return date;
	}
	
	/**
	 * 获取时间"年-月-日 时:分:秒"
	 * @return 例如2017-02-25 22:20:50
	 */
	public static String GetDate() {
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		return date;
	}

    /**
     * 当前系统时间减去过去的时间，格式yyyy-MM-dd HH:mm:ss
     * @param data
     */
	public static long NewDateReduceOldDate(String data) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = df.parse(df.format(new Date()));
		Date d2 = df.parse(data);
		long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
        long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);

		return minutes;
	}

	/**
	 * 当前系统时间减去过去的时间，格式yyyy-MM-dd
	 * @param data
	 * @return
	 * @throws ParseException
	 */
	public static long NewDateReduceOldDateDay(String data) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = df.parse(df.format(new Date()));
		Date d2 = df.parse(data);
		long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
		long days = diff / (1000 * 60 * 60 * 24);

		return days;
	}

	/**获取时间"时:分"
	 *
	 * @return 例如22:20
	 */
	public static String getHourMin(){
		Calendar ca = Calendar.getInstance();
		String h = String .valueOf(ca.get(Calendar.HOUR));
		String m = String .valueOf(ca.get(Calendar.MINUTE));
		return h+m;
	}
	/**
	 * 完全时间
	 * @return 年月日-时分秒毫秒
	 */
	public static String getAbosoluteTime() {
		String time = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
		return time;
	}

	/**
	 * 获取当前时间的后3天
	 * @return 返回当前时间的后3天，格式如：例如2017-02-25 22:20:50
	 */
	public static String GetThreeDaysLater(){
		  Calendar calendar = Calendar.getInstance();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  calendar.add(Calendar.DATE, 3);
		  String three_days_after = sdf.format(calendar.getTime());
		  return three_days_after;
	}

	/**
	 * 获取指定日期后两天
	 */
	public static String getNextDay(String day) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day1 = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day1 + 2);

		return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
	}

	/**
	 * 截屏控件
	 * @param dr webdriver类型
	 * @return
	 */
	public static String screenShot(final MyWebDriver dr){
		String dir = "screenshot";
		dd = new Date();
		String time = getAbosoluteTime();
		System.out.println("目前的时间是:" + time);
		String screenShotPath = dir + File.separator + time + ".png";
		try {
			File sourceFile = ((TakesScreenshot) dr.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(screenShotPath));
		} catch (Exception e) {
			e.printStackTrace();
			return "截图失败";
		}
		return screenShotPath;
	}


	/**
	 * 截屏控件，输出到指定带测试用例名称的文件夹当中
	 * @param
	 * @return
	 */
	public static String screenShot(String TestCaseName) {
		String time = getAbosoluteTime();
		System.out.println("目前的时间是:" + time);
		String screenShotPath = "screenshot"+ TestCaseName
				+"/"+TestCaseName+ " # " + time + ".png";
		File file = ((TakesScreenshot) new MyWebDriver().getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(screenShotPath));

		} catch (Exception e) {
			MyWebDriver.getLog().error("截屏错误...");
		}
		return screenShotPath;
	}




}
