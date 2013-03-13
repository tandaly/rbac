package com.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * mport java.text.SimpleDateFormat;
import java.util.Calendar;
public class Super2{
 public static void main(String args[]){
  Calendar cal = Calendar.getInstance();
  //n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
  int n = 2;
  String monday;
  cal.add(Calendar.DATE, n*7);
  //想周几，这里就传几Calendar.MONDAY（TUESDAY...）
  cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
  monday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
  System.out.println(monday);
 }
}
 * @project baidamei
 * @author cevencheng 
 * @create 2012-11-10 上午1:12:21
 */
public class DateUtil {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date begin = dfs.parse("2004-01-02 11:30:24");
		java.util.Date end = dfs.parse("2004-03-26 13:31:40");
		long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒

		long day = between / (24 * 3600);
		long hour = between % (24 * 3600) / 3600;
		long minute = between % 3600 / 60;
		long second = between % 60 / 60;
		System.out.println("" + day + "天" + hour + "小时" + minute + "分" + second + "秒");
		System.out.println(begin.getTime());
		
		System.out.println(getDaysBeforeNow(new Date()));
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse("2012-11-18");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); //上周一
		System.out.println(df.format(cal.getTime()));
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); //周末
		System.out.println(df.format(cal.getTime()));
		
	}

	/**
	 * 时间间隔计算
	 * 
	 */
	public static String getDaysBeforeNow(Date date) {
		long sysTime = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		long ymdhms = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(date));
		String strYear = "年前";
		String strMonth = "月前";
		String strDay = "天前";
		String strHour = "小时前";
		String strMinute = "分钟前";
		try {
			if (ymdhms == 0) {
				return "";
			}
			long between = (sysTime / 10000000000L) - (ymdhms / 10000000000L);
			if (between > 0) {
				return between + strYear;
			}
			between = (sysTime / 100000000L) - (ymdhms / 100000000L);
			if (between > 0) {
				return between + strMonth;
			}
			between = (sysTime / 1000000L) - (ymdhms / 1000000L);
			if (between > 0) {
				return between + strDay;
			}
			between = (sysTime / 10000) - (ymdhms / 10000);
			if (between > 0) {
				return between + strHour;
			}
			between = (sysTime / 100) - (ymdhms / 100);
			if (between > 0) {
				return between + strMinute;
			}
			return "1" + strMinute;
		} catch (Exception e) {
			return "";
		}
	}
}